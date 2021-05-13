package com.teamaurora.abundance.core;

import com.minecraftabnormals.abnormals_core.core.util.registry.RegistryHelper;
import com.teamaurora.abundance.common.capability.AbundanceCapabilities;
import com.teamaurora.abundance.common.event.AttachCapabilityEvents;
import com.teamaurora.abundance.common.event.PlayerEvents;
import com.teamaurora.abundance.common.network.NetworkHelper;
import com.teamaurora.abundance.common.network.PacketHandler;
import com.teamaurora.abundance.core.other.AbundanceCompat;
import com.teamaurora.abundance.core.registry.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.teamaurora.abundance.core.Abundance.MODID;

/**
 * THE BIG FUCKIN TO-DO LIST
 * Add all basic cypress blocks & items
 * Cypress tree shaping
 * Add bayou biome & reveal mod
 * Add cypress knees
 * Add gooseberries
 * Add cypress branches
 */
@Mod(Abundance.MODID)
public class Abundance {

    public static final String MODID = "abundance";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MODID);

    private final PacketHandler packetHandler = new PacketHandler();

    public static Abundance INSTANCE;

    public Abundance() {
        INSTANCE = this;

        this.packetHandler.registerMessages();

        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        REGISTRY_HELPER.register(eventBus);

        AbundanceFeatures.FEATURES.register(eventBus);
        AbundanceEffects.EFFECTS.register(eventBus);
        AbundanceEffects.POTIONS.register(eventBus);
        AbundanceSoundEvents.SOUNDS.register(eventBus);

        eventBus.addListener(this::commonSetup);
        eventBus.addListener(AbundanceEntities::registerEntityAttributes);

        MinecraftForge.EVENT_BUS.register(new PlayerEvents());
        MinecraftForge.EVENT_BUS.register(new AttachCapabilityEvents());

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, AbundanceConfig.COMMON_SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            AbundanceFeatures.Configured.registerConfiguredFeatures();
            AbundanceCompat.registerCompostables();
            AbundanceCompat.registerFlammables();

            AbundanceBiomes.addBiomeTypes();
            AbundanceBiomes.registerBiomesToDictionary();
            AbundanceBiomes.addSubBiomes();

            AbundanceEffects.registerBrewingRecipes();

            AbundanceCapabilities.registerCapabilities();
        });
    }

    public static ResourceLocation resourceLoc(String path) {
        return new ResourceLocation(MODID, path);
    }
}

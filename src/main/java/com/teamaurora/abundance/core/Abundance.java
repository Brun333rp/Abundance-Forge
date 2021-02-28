package com.teamaurora.abundance.core;

import com.minecraftabnormals.abnormals_core.core.util.registry.RegistryHelper;
import com.teamaurora.abundance.core.other.AbundanceCompat;
import com.teamaurora.abundance.core.registry.AbundanceBiomes;
import com.teamaurora.abundance.core.registry.AbundanceEffects;
import com.teamaurora.abundance.core.registry.AbundanceFeatures;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

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
@Mod("abundance")
public class Abundance
{
    public static final String MODID = "abundance";
    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MODID);

    public Abundance() {
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        REGISTRY_HELPER.register(eventBus);

        AbundanceFeatures.FEATURES.register(eventBus);
        AbundanceEffects.EFFECTS.register(eventBus);
        AbundanceEffects.POTIONS.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);

        eventBus.addListener(this::commonSetup);

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
        });
    }
}

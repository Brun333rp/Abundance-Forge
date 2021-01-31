package com.teamaurora.abundance.core;

import com.minecraftabnormals.abnormals_core.core.util.registry.RegistryHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.teamaurora.abundance.core.Abundance.MODID;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MODID)
@Mod.EventBusSubscriber(modid = MODID)
public class Abundance
{
    public static final String MODID = "abundance";
    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MODID);

    public Abundance() {
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        REGISTRY_HELPER.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);

        eventBus.addListener(EventPriority.LOWEST, this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void clientSetup(final FMLClientSetupEvent event) {}
}

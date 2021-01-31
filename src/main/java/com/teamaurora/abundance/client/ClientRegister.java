package com.teamaurora.abundance.client;

import com.teamaurora.abundance.core.Abundance;
import com.teamaurora.abundance.core.registry.AbundanceBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = Abundance.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientRegister {

    @SubscribeEvent
    public static void registerClient(final FMLClientSetupEvent event) {

    }

    private static void setupRenderLayer() {
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.LAVENDER.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.TALL_LAVENDER.get(), RenderType.getCutoutMipped());

        RenderTypeLookup.setRenderLayer(AbundanceBlocks.SUNNY_MARIGOLD.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.SHADY_MARIGOLD.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.TALL_MARIGOLD.get(), RenderType.getCutoutMipped());
    }
}

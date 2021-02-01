package com.teamaurora.abundance.core.other;

import com.teamaurora.abundance.core.registry.AbundanceBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

public class AbundanceRendering {
    public static void setupRenderLayer() {
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.LAVENDER.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.TALL_LAVENDER.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.LAVENDER_BLOSSOM_CARPET.get(), RenderType.getCutoutMipped());

        RenderTypeLookup.setRenderLayer(AbundanceBlocks.SUNNY_MARIGOLD.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.SHADY_MARIGOLD.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.TALL_MARIGOLD.get(), RenderType.getCutoutMipped());
    }
}

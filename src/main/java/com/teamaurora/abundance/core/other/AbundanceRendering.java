package com.teamaurora.abundance.core.other;

import com.teamaurora.abundance.core.registry.AbundanceBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

public class AbundanceRendering {
    public static void setupRenderLayer() {
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.LAVENDER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.TALL_LAVENDER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.LAVENDER_BLOSSOM_CARPET.get(), RenderType.getCutoutMipped());

        RenderTypeLookup.setRenderLayer(AbundanceBlocks.SUNNY_MARIGOLD.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.SHADY_MARIGOLD.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.TALL_MARIGOLD.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(AbundanceBlocks.JACARANDA_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.JACARANDA_LEAF_CARPET.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.BUDDING_JACARANDA_LEAF_CARPET.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.FLOWERING_JACARANDA_LEAF_CARPET.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.JACARANDA_LADDER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.JACARANDA_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.JACARANDA_DOOR.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(AbundanceBlocks.REDBUD_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.REDBUD_LEAF_CARPET.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.FLOWERING_REDBUD_LEAF_CARPET.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.REDBUD_LADDER.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(AbundanceBlocks.AMARANTHUS.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.CHICORY.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.NEMOPHILA.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.PURPLE_AFRICAN_DAISY.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.YELLOW_AFRICAN_DAISY.get(), RenderType.getCutout());
    }
}

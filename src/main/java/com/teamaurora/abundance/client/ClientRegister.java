package com.teamaurora.abundance.client;

import com.minecraftabnormals.abnormals_core.core.util.DataUtil;
import com.teamaurora.abundance.core.Abundance;
import com.teamaurora.abundance.core.registry.AbundanceBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.Arrays;

@Mod.EventBusSubscriber(modid = Abundance.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientRegister {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            registerBlockColors();
            setupRenderLayer();
        });
    }

    public static void setupRenderLayer() {
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.LAVENDER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.TALL_LAVENDER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.LAVENDER_BLOSSOM_CARPET.get(), RenderType.getCutoutMipped());

        RenderTypeLookup.setRenderLayer(AbundanceBlocks.SUNNY_MARIGOLD.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.SHADY_MARIGOLD.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.TALL_MARIGOLD.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(AbundanceBlocks.JACARANDA_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.POTTED_JACARANDA_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.JACARANDA_LEAF_CARPET.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.BUDDING_JACARANDA_LEAF_CARPET.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.FLOWERING_JACARANDA_LEAF_CARPET.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.JACARANDA_LADDER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.JACARANDA_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.JACARANDA_DOOR.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(AbundanceBlocks.REDBUD_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.POTTED_REDBUD_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.FLOWERING_REDBUD_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.POTTED_FLOWERING_REDBUD_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.REDBUD_LEAF_CARPET.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.BUDDING_REDBUD_LEAF_CARPET.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.FLOWERING_REDBUD_LEAF_CARPET.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.REDBUD_LADDER.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(AbundanceBlocks.AMARANTHUS.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.CHICORY.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.NEMOPHILA.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.PURPLE_AFRICAN_DAISY.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AbundanceBlocks.YELLOW_AFRICAN_DAISY.get(), RenderType.getCutout());
    }

    public static void registerBlockColors() {
        BlockColors blockColors = Minecraft.getInstance().getBlockColors();
        DataUtil.registerBlockColor(blockColors, (x, world, pos, u) -> world != null && pos != null ? BiomeColors.getFoliageColor(world, pos) : FoliageColors.getDefault(), Arrays.asList(
                AbundanceBlocks.REDBUD_LEAVES,
                AbundanceBlocks.REDBUD_LEAF_CARPET,
                AbundanceBlocks.BUDDING_REDBUD_LEAVES,
                AbundanceBlocks.BUDDING_REDBUD_LEAF_CARPET
        ));

        ItemColors itemColors = Minecraft.getInstance().getItemColors();
        DataUtil.registerBlockItemColor(itemColors, (color, items) -> FoliageColors.getDefault(), Arrays.asList(
                AbundanceBlocks.REDBUD_LEAVES,
                AbundanceBlocks.REDBUD_LEAF_CARPET,
                AbundanceBlocks.BUDDING_REDBUD_LEAVES,
                AbundanceBlocks.BUDDING_REDBUD_LEAF_CARPET
        ));
    }
}

package com.teamaurora.abundance.core.other;

import com.minecraftabnormals.abnormals_core.core.util.DataUtil;
import com.teamaurora.abundance.core.registry.AbundanceBlocks;
import com.teamaurora.abundance.core.registry.AbundanceItems;

public class AbundanceCompat {
    public static void registerCompostables() {
        DataUtil.registerCompostable(AbundanceItems.LAVENDER.get(), 0.65F);
        DataUtil.registerCompostable(AbundanceItems.LAVENDER_BLOSSOMS.get(), 0.65F);
        DataUtil.registerCompostable(AbundanceBlocks.LAVENDER_BLOSSOM_CARPET.get(), 0.65F);
        DataUtil.registerCompostable(AbundanceBlocks.LAVENDER_BASKET.get(), 1.0F);

        DataUtil.registerCompostable(AbundanceBlocks.JACARANDA_LEAVES.get(), 0.3F);
        DataUtil.registerCompostable(AbundanceBlocks.BUDDING_JACARANDA_LEAVES.get(), 0.3F);
        DataUtil.registerCompostable(AbundanceBlocks.FLOWERING_JACARANDA_LEAVES.get(), 0.3F);
        DataUtil.registerCompostable(AbundanceBlocks.JACARANDA_SAPLING.get(), 0.3F);
        DataUtil.registerCompostable(AbundanceBlocks.JACARANDA_LEAF_CARPET.get(), 0.3F);
        DataUtil.registerCompostable(AbundanceBlocks.BUDDING_JACARANDA_LEAF_CARPET.get(), 0.3F);
        DataUtil.registerCompostable(AbundanceBlocks.FLOWERING_JACARANDA_LEAF_CARPET.get(), 0.3F);

        DataUtil.registerCompostable(AbundanceBlocks.REDBUD_LEAVES.get(), 0.3F);
        DataUtil.registerCompostable(AbundanceBlocks.BUDDING_REDBUD_LEAVES.get(), 0.3F);
        DataUtil.registerCompostable(AbundanceBlocks.FLOWERING_REDBUD_LEAVES.get(), 0.3F);
        DataUtil.registerCompostable(AbundanceBlocks.REDBUD_SAPLING.get(), 0.3F);
        DataUtil.registerCompostable(AbundanceBlocks.FLOWERING_REDBUD_SAPLING.get(), 0.3F);
        DataUtil.registerCompostable(AbundanceBlocks.REDBUD_LEAF_CARPET.get(), 0.3F);
        DataUtil.registerCompostable(AbundanceBlocks.BUDDING_REDBUD_LEAF_CARPET.get(), 0.3F);
        DataUtil.registerCompostable(AbundanceBlocks.FLOWERING_REDBUD_LEAF_CARPET.get(), 0.3F);

        DataUtil.registerCompostable(AbundanceBlocks.SAGUARO_CACTUS.get(), 0.5F);
        DataUtil.registerCompostable(AbundanceBlocks.SMALL_SAGUARO_CACTUS.get(), 0.5F);
        DataUtil.registerCompostable(AbundanceItems.SAGUARO_FLOWER.get(), 0.5F);

        DataUtil.registerCompostable(AbundanceBlocks.SUNNY_MARIGOLD.get(), 0.65F);
        DataUtil.registerCompostable(AbundanceBlocks.SHADY_MARIGOLD.get(), 0.65F);
        DataUtil.registerCompostable(AbundanceBlocks.TALL_MARIGOLD.get(), 0.65F);

        DataUtil.registerCompostable(AbundanceBlocks.AMARANTHUS.get(), 0.65F);
        DataUtil.registerCompostable(AbundanceBlocks.CHICORY.get(), 0.65F);
        DataUtil.registerCompostable(AbundanceBlocks.NEMOPHILA.get(), 0.65F);
        DataUtil.registerCompostable(AbundanceBlocks.PURPLE_AFRICAN_DAISY.get(), 0.65F);
        DataUtil.registerCompostable(AbundanceBlocks.YELLOW_AFRICAN_DAISY.get(), 0.65F);

        DataUtil.registerCompostable(AbundanceItems.SUNFLOWER_SEEDS.get(), 0.3F);
        DataUtil.registerCompostable(AbundanceBlocks.SUNFLOWER_SEED_SACK.get(), 1.0F);
    }

    public static void registerFlammables() {
        DataUtil.registerFlammable(AbundanceBlocks.LAVENDER_BLOSSOM_CARPET.get(), 30, 60);
        DataUtil.registerFlammable(AbundanceBlocks.LAVENDER_BASKET.get(), 5, 20);

        DataUtil.registerFlammable(AbundanceBlocks.JACARANDA_LEAVES.get(), 30, 60);
        DataUtil.registerFlammable(AbundanceBlocks.FLOWERING_JACARANDA_LEAVES.get(), 30, 60);
        DataUtil.registerFlammable(AbundanceBlocks.BUDDING_JACARANDA_LEAVES.get(), 30, 60);
        DataUtil.registerFlammable(AbundanceBlocks.JACARANDA_LOG.get(), 5, 5);
        DataUtil.registerFlammable(AbundanceBlocks.JACARANDA_WOOD.get(), 5, 5);
        DataUtil.registerFlammable(AbundanceBlocks.STRIPPED_JACARANDA_LOG.get(), 5, 5);
        DataUtil.registerFlammable(AbundanceBlocks.STRIPPED_JACARANDA_WOOD.get(), 5, 5);
        DataUtil.registerFlammable(AbundanceBlocks.JACARANDA_PLANKS.get(), 5, 20);
        DataUtil.registerFlammable(AbundanceBlocks.JACARANDA_SLAB.get(), 5, 20);
        DataUtil.registerFlammable(AbundanceBlocks.JACARANDA_STAIRS.get(), 5, 20);
        DataUtil.registerFlammable(AbundanceBlocks.JACARANDA_FENCE.get(), 5, 20);
        DataUtil.registerFlammable(AbundanceBlocks.JACARANDA_FENCE_GATE.get(), 5, 20);
        DataUtil.registerFlammable(AbundanceBlocks.VERTICAL_JACARANDA_PLANKS.get(), 5, 20);
        DataUtil.registerFlammable(AbundanceBlocks.JACARANDA_LEAF_CARPET.get(), 30, 60);
        DataUtil.registerFlammable(AbundanceBlocks.BUDDING_JACARANDA_LEAF_CARPET.get(), 30, 60);
        DataUtil.registerFlammable(AbundanceBlocks.FLOWERING_JACARANDA_LEAF_CARPET.get(), 30, 60);
        DataUtil.registerFlammable(AbundanceBlocks.JACARANDA_VERTICAL_SLAB.get(), 5, 20);
        DataUtil.registerFlammable(AbundanceBlocks.JACARANDA_BOOKSHELF.get(), 30, 20);
        DataUtil.registerFlammable(AbundanceBlocks.JACARANDA_BEEHIVE.get(), 5, 20);

        DataUtil.registerFlammable(AbundanceBlocks.REDBUD_LEAVES.get(), 30, 60);
        DataUtil.registerFlammable(AbundanceBlocks.BUDDING_REDBUD_LEAVES.get(), 30, 60);
        DataUtil.registerFlammable(AbundanceBlocks.FLOWERING_REDBUD_LEAVES.get(), 30, 60);
        DataUtil.registerFlammable(AbundanceBlocks.REDBUD_LOG.get(), 5, 5);
        DataUtil.registerFlammable(AbundanceBlocks.FLOWERING_REDBUD_LOG.get(), 5, 5);
        DataUtil.registerFlammable(AbundanceBlocks.REDBUD_WOOD.get(), 5, 5);
        DataUtil.registerFlammable(AbundanceBlocks.STRIPPED_REDBUD_LOG.get(), 5, 5);
        DataUtil.registerFlammable(AbundanceBlocks.STRIPPED_REDBUD_WOOD.get(), 5, 5);
        DataUtil.registerFlammable(AbundanceBlocks.REDBUD_PLANKS.get(), 5, 20);
        DataUtil.registerFlammable(AbundanceBlocks.REDBUD_SLAB.get(), 5, 20);
        DataUtil.registerFlammable(AbundanceBlocks.REDBUD_STAIRS.get(), 5, 20);
        DataUtil.registerFlammable(AbundanceBlocks.REDBUD_FENCE.get(), 5, 20);
        DataUtil.registerFlammable(AbundanceBlocks.REDBUD_FENCE_GATE.get(), 5, 20);
        DataUtil.registerFlammable(AbundanceBlocks.VERTICAL_REDBUD_PLANKS.get(), 5, 20);
        DataUtil.registerFlammable(AbundanceBlocks.REDBUD_LEAF_CARPET.get(), 30, 60);
        DataUtil.registerFlammable(AbundanceBlocks.BUDDING_REDBUD_LEAF_CARPET.get(), 30, 60);
        DataUtil.registerFlammable(AbundanceBlocks.FLOWERING_REDBUD_LEAF_CARPET.get(), 30, 60);
        DataUtil.registerFlammable(AbundanceBlocks.REDBUD_VERTICAL_SLAB.get(), 5, 20);
        DataUtil.registerFlammable(AbundanceBlocks.REDBUD_BOOKSHELF.get(), 30, 20);
        DataUtil.registerFlammable(AbundanceBlocks.REDBUD_BEEHIVE.get(), 5, 20);

        DataUtil.registerFlammable(AbundanceBlocks.SUNFLOWER_SEED_SACK.get(), 5, 20);
    }
}

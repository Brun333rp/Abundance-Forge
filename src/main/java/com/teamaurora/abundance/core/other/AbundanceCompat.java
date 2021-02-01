package com.teamaurora.abundance.core.other;

import com.minecraftabnormals.abnormals_core.core.util.DataUtil;
import com.teamaurora.abundance.core.registry.AbundanceBlocks;
import com.teamaurora.abundance.core.registry.AbundanceItems;

public class AbundanceCompat {
    public static void registerCompostables() {
        DataUtil.registerCompostable(AbundanceItems.LAVENDER.get(), 0.65F);
        DataUtil.registerCompostable(AbundanceItems.LAVENDER_BLOSSOMS.get(), 0.65F);
        DataUtil.registerCompostable(AbundanceBlocks.LAVENDER_BLOSSOM_CARPET.get(), 0.65F);
    }

    public static void registerFlammables() {
        DataUtil.registerFlammable(AbundanceBlocks.LAVENDER_BLOSSOM_CARPET.get(), 30, 60);
    }
}

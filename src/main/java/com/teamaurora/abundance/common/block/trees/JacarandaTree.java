package com.teamaurora.abundance.common.block.trees;

import com.teamaurora.abundance.core.registry.AbundanceFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class JacarandaTree extends Tree {
    @Nullable
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean largeHive) {
        if (randomIn.nextBoolean()) {
            return largeHive ? AbundanceFeatures.Configured.JACARANDA_BEES_005 : AbundanceFeatures.Configured.JACARANDA;
        } else {
            return largeHive ? AbundanceFeatures.Configured.FLOWERING_JACARANDA_BEES_005 : AbundanceFeatures.Configured.FLOWERING_JACARANDA;
        }
    }
}

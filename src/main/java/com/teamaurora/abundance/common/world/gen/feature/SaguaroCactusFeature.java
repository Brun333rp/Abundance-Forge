package com.teamaurora.abundance.common.world.gen.feature;

import com.google.common.collect.Sets;
import com.minecraftabnormals.abnormals_core.core.util.TreeUtil;
import com.mojang.serialization.Codec;
import com.teamaurora.abundance.core.registry.AbundanceBlocks;
import net.minecraft.block.*;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;

import java.util.*;

public class SaguaroCactusFeature extends Feature<BaseTreeFeatureConfig> {
    public SaguaroCactusFeature(Codec<BaseTreeFeatureConfig> config) {
        super(config);
    }

    private int randBetween(int low, int high, Random rand) {
        return low + rand.nextInt(high - low + 1);
    }

    @Override
    public boolean generate(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos position, BaseTreeFeatureConfig config) {
        int height = rand.nextInt(2) + 3;
        Direction dir = Direction.byHorizontalIndex(rand.nextInt(4));
        boolean back = rand.nextBoolean();
        if (position.getY() <= 0 || position.getY() + height > worldIn.getHeight() - 2) {
            return false;
        }
        Block downward = worldIn.getBlockState(position.down()).getBlock();
        if (downward != Blocks.SAND && downward != Blocks.RED_SAND) {
            return false;
        }

        for (BlockPos pos : BlockPos.getAllInBoxMutable(position.up().offset(dir), position.up(height).offset(dir, back ? -1 : 0))) {
            if (!TreeUtil.isAirOrLeaves(worldIn, pos)) return false;
        }

        for (int i = 0; i <= height; i++) {
            TreeUtil.setForcedState(worldIn, position.up(i), AbundanceBlocks.SAGUARO_CACTUS.get().getDefaultState());
        }
        int height1, height2, depth1, depth2;
        if (height == 3) {
            depth1 = 1;
            depth2 = 1;
            height1 = 2;
            height2 = 2;
        } else {
            depth1 = 1 + rand.nextInt(2);
            depth2 = 1 + rand.nextInt(2);
            height1 = randBetween(depth1 + 1, 3, rand);
            height2 = randBetween(depth2 + 1, 3, rand);
        }
        for (int i = depth1; i <= height1; i++) {
            BlockState sag1 = AbundanceBlocks.SMALL_SAGUARO_CACTUS.get().getDefaultState();
            if (i == depth1) {
                sag1 = sag1.with(SixWayBlock.UP, true).with(SixWayBlock.FACING_TO_PROPERTY_MAP.get(dir.getOpposite()), true);
            } else if (i == height1) {
                sag1 = sag1.with(SixWayBlock.DOWN, true);
            } else {
                sag1 = sag1.with(SixWayBlock.UP, true).with(SixWayBlock.DOWN, true);
            }
            TreeUtil.setForcedState(worldIn, position.offset(dir).up(i), sag1);
        }
        if (back) {
            for (int i = depth2; i <= height2; i++) {
                BlockState sag2 = AbundanceBlocks.SMALL_SAGUARO_CACTUS.get().getDefaultState();
                if (i == depth2) {
                    sag2 = sag2.with(SixWayBlock.UP, true).with(SixWayBlock.FACING_TO_PROPERTY_MAP.get(dir), true);
                } else if (i == height2) {
                    sag2 = sag2.with(SixWayBlock.DOWN, true);
                } else {
                    sag2 = sag2.with(SixWayBlock.UP, true).with(SixWayBlock.DOWN, true);
                }
                TreeUtil.setForcedState(worldIn, position.offset(dir.getOpposite()).up(i), sag2);
            }
        }

        return true;
    }
}

package com.teamaurora.abundance.common.world.gen.feature;

import com.google.common.collect.Sets;
import com.minecraftabnormals.abnormals_core.core.util.TreeUtil;
import com.mojang.serialization.Codec;
import com.teamaurora.abundance.core.registry.AbundanceBlocks;
import net.minecraft.block.SaplingBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.*;

public class RedbudFeature extends Feature<BaseTreeFeatureConfig> {

    public RedbudFeature(Codec<BaseTreeFeatureConfig> config) {
        super(config);
    }

    @Override
    public boolean generate(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos position, BaseTreeFeatureConfig config) {
        int height = rand.nextInt(3) + 2;
        if (position.getY() <= 0 || position.getY() + height > worldIn.getHeight() - 2) {
            return false;
        }
        if (!TreeUtil.isValidGround(worldIn, position.down(), (SaplingBlock) AbundanceBlocks.REDBUD_SAPLING.get())) {
            return false;
        }

        List<DirectionalBlockPos> logs = new ArrayList<>();
        List<BlockPos> leaves = new ArrayList<>();

        for (int i = 0; i <= height; i++) {
            logs.add(new DirectionalBlockPos(position.up(i), Direction.UP));
        }

        int variant = rand.nextInt(3);
        if (variant == 0) {
            Direction dir = Direction.byHorizontalIndex(rand.nextInt(4));
            int offset1 = rand.nextInt(3) - 1;
            int offset2 = rand.nextInt(3) - 1;
            BlockPos bp1 = position.up(height).offset(dir).offset(dir.rotateY(), offset1);
            BlockPos bp2 = position.up(height).offset(dir, -1).offset(dir.rotateY(), offset2);
            logs.add(new DirectionalBlockPos(bp1, dir));
            logs.add(new DirectionalBlockPos(bp2, dir));
            addCanopy(bp1.offset(dir), leaves, rand);
            addCanopy(bp2.offset(dir, -1), leaves, rand);
        } else if (variant == 1) {
            Direction dir = Direction.byHorizontalIndex(rand.nextInt(4));
            BlockPos bp1 = position.up(height).offset(dir);
            BlockPos bp2 = position.up(height).offset(dir, -1).offset(dir.rotateY());
            BlockPos bp3 = position.up(height).offset(dir, -1).offset(dir.rotateY(), -1);
            logs.add(new DirectionalBlockPos(bp1, dir));
            logs.add(new DirectionalBlockPos(bp2, dir));
            logs.add(new DirectionalBlockPos(bp3, dir));
            addCanopy(bp1.offset(dir), leaves, rand);
            addCanopy(bp2.offset(dir, -1), leaves, rand);
            addCanopy(bp3.offset(dir, -1), leaves, rand);
        } else {
            logs.add(new DirectionalBlockPos(position.up(height).north(), Direction.NORTH));
            logs.add(new DirectionalBlockPos(position.up(height).east(), Direction.EAST));
            logs.add(new DirectionalBlockPos(position.up(height).south(), Direction.SOUTH));
            logs.add(new DirectionalBlockPos(position.up(height).west(), Direction.WEST));
            addCanopy(position.up(height).north(2), leaves, rand);
            addCanopy(position.up(height).east(2), leaves, rand);
            addCanopy(position.up(height).south(2), leaves, rand);
            addCanopy(position.up(height).west(2), leaves, rand);
        }
        addCanopy(position.up(height+1), leaves, rand);


        List<BlockPos> leavesClean = cleanLeavesArray(leaves, logs);

        boolean flag = true;
        for (DirectionalBlockPos log : logs) {
            if (!TreeUtil.isAirOrLeaves(worldIn, log.getPos())) {
                flag = false;
            }
        }
        if (!flag) return false;

        TreeUtil.setDirtAt(worldIn, position.down());

        for (DirectionalBlockPos log : logs) {
            TreeUtil.placeDirectionalLogAt(worldIn, log.getPos(), log.getDirection(), rand, config);
        }
        for (BlockPos leaf : leavesClean) {
            TreeUtil.placeLeafAt(worldIn, leaf, rand, config);
        }


        Set<BlockPos> decSet = Sets.newHashSet();
        MutableBoundingBox mutableBoundingBox = MutableBoundingBox.getNewBoundingBox();

        List<BlockPos> logsPos = new ArrayList<>();
        for (DirectionalBlockPos log : logs) {
            logsPos.add(log.getPos());
        }

        if (!config.decorators.isEmpty()) {
            logsPos.sort(Comparator.comparingInt(Vector3i::getY));
            leavesClean.sort(Comparator.comparingInt(Vector3i::getY));
            config.decorators.forEach((decorator) -> decorator.func_225576_a_(worldIn, rand, logsPos, leavesClean, decSet, mutableBoundingBox));
        }
        return true;
    }

    private void addCanopy(BlockPos pos, List<BlockPos> leaves, Random rand) {
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    if (x == 0 || y == 0 || z == 0 || rand.nextInt(3) == 0) {
                        leaves.add(pos.add(x, y, z));
                    }
                }
            }
        }
    }

    private List<BlockPos> cleanLeavesArray(List<BlockPos> leaves, List<DirectionalBlockPos> logs) {
        List<BlockPos> logsPos = new ArrayList<>();

        for (DirectionalBlockPos log : logs) {
            logsPos.add(log.getPos());
        }
        List<BlockPos> newLeaves = new ArrayList<>();
        for (BlockPos leaf : leaves) {
            if (!logsPos.contains(leaf)) {
                newLeaves.add(leaf);
            }
        }
        return newLeaves;
    }
}

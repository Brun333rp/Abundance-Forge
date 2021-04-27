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

public class JacarandaFeature extends Feature<BaseTreeFeatureConfig> {

    public JacarandaFeature(Codec<BaseTreeFeatureConfig> config) {
        super(config);
    }

    @Override
    public boolean generate(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos position, BaseTreeFeatureConfig config) {
        int height = rand.nextInt(4) + 4;
        if (position.getY() <= 0 || position.getY() + height > worldIn.getHeight() - 2) {
            return false;
        }
        if (!TreeUtil.isValidGround(worldIn, position.down(), (SaplingBlock) AbundanceBlocks.JACARANDA_SAPLING.get())) {
            return false;
        }
        List<DirectionalBlockPos> logs = new ArrayList<>();
        List<BlockPos> leaves = new ArrayList<>();

        for (int i = 0; i <= height; i++) {
            logs.add(new DirectionalBlockPos(position.up(i), Direction.UP));
        }

        List<Direction> dirs = new ArrayList<>();
        dirs.add(Direction.NORTH);
        dirs.add(Direction.EAST);
        dirs.add(Direction.SOUTH);
        dirs.add(Direction.EAST);

        for (int i = 2; i <= height - 2; i++) {
            Direction dir = dirs.get(rand.nextInt(dirs.size()));
            dirs.remove(dir);
            addBranch(position.up(i), dir, leaves, logs, rand);
        }
        addCanopy(position.up(height), leaves, rand);

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

    private void addBranch(BlockPos pos, Direction dir, List<BlockPos> leaves, List<DirectionalBlockPos> logs, Random rand) {
        logs.add(new DirectionalBlockPos(pos.offset(dir), dir));
        int i = rand.nextInt(3) - 1;
        BlockPos b2pos = pos.offset(dir, 2).offset(dir.rotateY(), i);
        logs.add(new DirectionalBlockPos(b2pos, dir));
        addCanopy(b2pos, leaves, rand);
    }

    private void addCanopy(BlockPos pos, List<BlockPos> leaves, Random rand) {
        cir1(pos.down(), leaves, rand);
        cir2(pos, leaves, rand);
        cir2(pos.up(), leaves, rand);
        cir1(pos.up(2), leaves, rand);
    }

    private void cir1(BlockPos pos, List<BlockPos> leaves, Random rand) {
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                //if (Math.abs(x) != 1 || Math.abs(z) != 1 || rand.nextBoolean()) {
                if (Math.abs(x) != 1 || Math.abs(z) != 1) {
                        leaves.add(pos.add(x, 0, z));
                }
            }
        }
    }

    private void cir2(BlockPos pos, List<BlockPos> leaves, Random rand) {
        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {
                //if (Math.abs(x) != 2 || Math.abs(z) != 2 || rand.nextBoolean()) {
                if (Math.abs(x) != 2 || Math.abs(z) != 2) {
                    leaves.add(pos.add(x, 0, z));
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

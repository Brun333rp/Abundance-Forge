package com.teamaurora.abundance.common.world.gen.feature;

import com.mojang.serialization.Codec;
import com.teamaurora.abundance.common.block.LavenderBlock;
import com.teamaurora.abundance.core.registry.AbundanceBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class LavenderFeature extends Feature<NoFeatureConfig> {
    public LavenderFeature(Codec<NoFeatureConfig> config) {
        super(config);
    }

    public boolean generate(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        int i = 0;
        for (BlockPos pos2 : BlockPos.getAllInBoxMutable(pos.add(-6, -6, -6), pos.add(6, 6, 6))) {
            if (pos.withinDistance(pos2, 6.0) && AbundanceBlocks.LAVENDER.get().getDefaultState().isValidPosition(worldIn, pos2) && isAirAt(worldIn, pos2)) {
                if (pos.withinDistance(pos2, 3.0)) {
                    if (rand.nextBoolean()) {
                        if (rand.nextBoolean()) {
                            if (AbundanceBlocks.TALL_LAVENDER.get().getDefaultState().isValidPosition(worldIn, pos2) && isAirAt(worldIn, pos2.up())) {
                                ((DoublePlantBlock) AbundanceBlocks.TALL_LAVENDER.get()).placeAt(worldIn, pos2, 2);
                                worldIn.setBlockState(pos2.down(), Blocks.COARSE_DIRT.getDefaultState(), 2);
                                i++;
                            }
                        } else {
                            worldIn.setBlockState(pos2, AbundanceBlocks.LAVENDER.get().getDefaultState().with(LavenderBlock.AGE, 2), 2);
                            i++;
                        }
                    }
                } else {
                    if (rand.nextInt(3) == 0) {
                        worldIn.setBlockState(pos2, AbundanceBlocks.LAVENDER.get().getDefaultState().with(LavenderBlock.AGE, 2), 2);
                        i++;
                    }
                }
            }
        }
        return i > 0;
    }
}

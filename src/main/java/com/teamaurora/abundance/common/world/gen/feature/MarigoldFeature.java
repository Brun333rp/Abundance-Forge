package com.teamaurora.abundance.common.world.gen.feature;

import com.mojang.serialization.Codec;
import com.teamaurora.abundance.common.block.LavenderBlock;
import com.teamaurora.abundance.core.registry.AbundanceBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class MarigoldFeature extends Feature<NoFeatureConfig> {
    public MarigoldFeature(Codec<NoFeatureConfig> config) {
        super(config);
    }

    public boolean generate(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        int i = 0;
        for (BlockPos pos2 : BlockPos.getAllInBoxMutable(pos.add(-3, -3, -3), pos.add(3, 3, 3))) {
            if (pos.withinDistance(pos2, 3.0) && AbundanceBlocks.SUNNY_MARIGOLD.get().getDefaultState().isValidPosition(worldIn, pos2) && isAirAt(worldIn, pos2)) {
                int variant = rand.nextInt(4);
                if (variant == 0) {
                    worldIn.setBlockState(pos2, AbundanceBlocks.SUNNY_MARIGOLD.get().getDefaultState(), 2);
                    i++;
                } else if (variant == 1) {
                    worldIn.setBlockState(pos2, AbundanceBlocks.SHADY_MARIGOLD.get().getDefaultState(), 2);
                    i++;
                } else if (variant == 2 && AbundanceBlocks.TALL_MARIGOLD.get().getDefaultState().isValidPosition(worldIn, pos2) && isAirAt(worldIn, pos2.up())) {
                    ((DoublePlantBlock) AbundanceBlocks.TALL_MARIGOLD.get()).placeAt(worldIn, pos2, 2);
                    i++;
                }
            }
        }
        return i > 0;
    }
}

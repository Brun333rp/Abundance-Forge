package com.teamaurora.abundance.common.world.gen.feature;

import com.mojang.serialization.Codec;
import com.teamaurora.abundance.core.registry.AbundanceBlocks;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class NemophilaFeature extends Feature<NoFeatureConfig> {
    public NemophilaFeature(Codec<NoFeatureConfig> config) {
        super(config);
    }

    public boolean generate(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        int i = 0;
        for (BlockPos pos2 : BlockPos.getAllInBoxMutable(pos.add(-3, -3, -3), pos.add(3, 3, 3))) {
            if (pos.withinDistance(pos2, 3.0) && AbundanceBlocks.NEMOPHILA.get().getDefaultState().isValidPosition(worldIn, pos2) && isAirAt(worldIn, pos2)) {
                if (rand.nextBoolean()) {
                    worldIn.setBlockState(pos2, AbundanceBlocks.NEMOPHILA.get().getDefaultState(), 2);
                    i++;
                }
            }
        }
        return i > 0;
    }
}

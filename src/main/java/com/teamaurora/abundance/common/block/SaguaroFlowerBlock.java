package com.teamaurora.abundance.common.block;

import com.teamaurora.abundance.core.registry.AbundanceBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

public class SaguaroFlowerBlock extends BushBlock {
    public SaguaroFlowerBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        Block below = worldIn.getBlockState(pos.down()).getBlock();
        return below == AbundanceBlocks.SAGUARO_CACTUS.get() || below == AbundanceBlocks.SMALL_SAGUARO_CACTUS.get();
    }

    @Override
    public PlantType getPlantType(IBlockReader world, BlockPos pos) {
        return PlantType.DESERT;
    }
}

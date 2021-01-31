package com.teamaurora.abundance.common.block;

import com.minecraftabnormals.abnormals_core.common.blocks.AbnormalsFlowerBlock;
import com.teamaurora.abundance.core.registry.AbundanceBlocks;
import net.minecraft.block.*;
import net.minecraft.network.DebugPacketSender;
import net.minecraft.potion.Effect;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class LavenderBlock extends AbnormalsFlowerBlock {
    public LavenderBlock(Supplier<Effect> stewEffect, int stewEffectDuration, Properties properties) {
        super(stewEffect, stewEffectDuration, properties);
    }

    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.getBlock() == AbundanceBlocks.LAVENDER.get() || super.isValidGround(state, worldIn, pos);
    }

    /*@Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (facing == Direction.DOWN && facingState.getBlock() == AbundanceBlocks.LAVENDER.get()) {
            worldIn.setBlockState(facingPos, AbundanceBlocks.TALL_LAVENDER.get().getDefaultState().with(TallFlowerBlock.HALF, DoubleBlockHalf.LOWER), 2);
            return AbundanceBlocks.TALL_LAVENDER.get().getDefaultState().with(TallFlowerBlock.HALF, DoubleBlockHalf.UPPER);
        } else {
            return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        }
    }*/

    @Override
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (worldIn.getBlockState(pos.up()).getBlock() == AbundanceBlocks.LAVENDER.get()) {
            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
            worldIn.setBlockState(pos.up(), Blocks.AIR.getDefaultState());
            ((DoublePlantBlock) AbundanceBlocks.TALL_LAVENDER.get()).placeAt(worldIn, pos, 3);
        }
    }
}

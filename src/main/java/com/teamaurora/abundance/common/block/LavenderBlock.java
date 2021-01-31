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
import net.minecraft.world.server.ServerWorld;

import java.util.Random;
import java.util.function.Supplier;

public class LavenderBlock extends AbnormalsFlowerBlock implements IGrowable {
    public LavenderBlock(Supplier<Effect> stewEffect, int stewEffectDuration, Properties properties) {
        super(stewEffect, stewEffectDuration, properties);
    }

    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        DoublePlantBlock doubleplantblock = (DoublePlantBlock)(AbundanceBlocks.TALL_LAVENDER.get());
        if (doubleplantblock.getDefaultState().isValidPosition(worldIn, pos) && worldIn.getBlockState(pos.up()).getBlock() == AbundanceBlocks.LAVENDER.get()) {
            doubleplantblock.placeAt(worldIn, pos, 2);
        }

    }
}

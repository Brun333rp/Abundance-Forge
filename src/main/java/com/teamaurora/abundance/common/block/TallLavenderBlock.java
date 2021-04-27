package com.teamaurora.abundance.common.block;

import com.teamaurora.abundance.core.registry.AbundanceBlocks;
import com.teamaurora.abundance.core.registry.AbundanceItems;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class TallLavenderBlock extends DoublePlantBlock {

    public TallLavenderBlock(AbstractBlock.Properties properties) {
        super(properties);
    }

    @Override
    @SuppressWarnings("deprecation")
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(AbundanceItems.LAVENDER.get());
    }

    //public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)

    @Override
    @SuppressWarnings("deprecation")
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        spawnAsEntity(worldIn, pos, new ItemStack(AbundanceItems.LAVENDER.get(), 2));
        worldIn.playSound(null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
        int downAmount = state.get(HALF) == DoubleBlockHalf.LOWER ? 0 : 1;
        worldIn.setBlockState(pos.down(downAmount), AbundanceBlocks.LAVENDER.get().getDefaultState().with(LavenderBlock.AGE, 0), 2);
        worldIn.setBlockState(pos.down(downAmount).up(), Blocks.AIR.getDefaultState(), 2);

        return ActionResultType.func_233537_a_(worldIn.isRemote);
    }
}

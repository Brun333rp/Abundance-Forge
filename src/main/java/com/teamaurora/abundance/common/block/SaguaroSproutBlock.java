package com.teamaurora.abundance.common.block;

import com.minecraftabnormals.abnormals_core.common.blocks.wood.AbnormalsSaplingBlock;
import com.teamaurora.abundance.core.registry.AbundanceItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

public class SaguaroSproutBlock extends AbnormalsSaplingBlock {
    public SaguaroSproutBlock(Tree tree, Properties properties) {
        super(tree, properties);
    }

    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(AbundanceItems.SAGUARO_FLOWER.get());
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        Block below = worldIn.getBlockState(pos.down()).getBlock();
        return below == Blocks.SAND || below == Blocks.RED_SAND;
    }
}

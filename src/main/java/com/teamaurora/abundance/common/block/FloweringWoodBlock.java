package com.teamaurora.abundance.common.block;

import com.minecraftabnormals.abnormals_core.common.blocks.wood.WoodBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class FloweringWoodBlock extends WoodBlock {

    private final Supplier<Block> snipBlock;

    public FloweringWoodBlock(Supplier<Block> snippedBlock, Supplier<Block> strippedBlock, Properties properties) {
        super(strippedBlock, properties);
        this.snipBlock = snippedBlock;
    }

    @Override
    @SuppressWarnings("deprecation")
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack item = player.getHeldItem(handIn);

        if (item.getItem() instanceof ShearsItem) {
            worldIn.playSound(null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
            worldIn.setBlockState(pos, snipBlock.get().getDefaultState().with(AXIS, state.get(AXIS)), 2);

            if (player instanceof ServerPlayerEntity && !player.isCreative()) {
                item.attemptDamageItem(1, worldIn.getRandom(), (ServerPlayerEntity) player);
            }
            return ActionResultType.func_233537_a_(worldIn.isRemote);
        }
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
}

package com.teamaurora.abundance.common.block;

import com.minecraftabnormals.abnormals_core.common.blocks.AbnormalsFlowerBlock;
import com.teamaurora.abundance.core.registry.AbundanceBlocks;
import com.teamaurora.abundance.core.registry.AbundanceItems;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.DebugPacketSender;
import net.minecraft.potion.Effect;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;
import java.util.function.Supplier;

public class LavenderBlock extends BushBlock implements IGrowable {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_0_2;
    protected static final VoxelShape SHAPE_SMALL = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 6.0D, 14.0D);
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D);

    public LavenderBlock(AbstractBlock.Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(0)));
    }

    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(AbundanceItems.LAVENDER.get());
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        if (state.get(AGE) == 0) {
            return SHAPE_SMALL;
        } else {
            return SHAPE;
        }
    }

    public boolean ticksRandomly(BlockState state) {
        return state.get(AGE) < 3;
    }

    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        int j = state.get(AGE);
        if (j < 3 && worldIn.getLightSubtracted(pos.up(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state,random.nextInt(14) == 0) && (j < 2 || (worldIn.getBlockState(pos.down()).getBlock() != Blocks.COARSE_DIRT && worldIn.getBlockState(pos.down(2)).getBlock() != Blocks.COARSE_DIRT))) {
            if (j == 2) {
                if (worldIn.isAirBlock(pos.up())) {
                    TallLavenderBlock tallLavender = (TallLavenderBlock) AbundanceBlocks.TALL_LAVENDER.get();
                    tallLavender.placeAt(worldIn, pos, 2);
                }
            } else {
                int i = Math.min(2, j + 1);
                worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i)), 2);
            }
            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
        }
    }

    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        int i = state.get(AGE);
        boolean flag = i == 3;
        if (!flag && player.getHeldItem(handIn).getItem() == Items.BONE_MEAL) {
            return ActionResultType.PASS;
        } else if (i > 1) {
            spawnAsEntity(worldIn, pos, new ItemStack(AbundanceItems.LAVENDER.get(), 1));
            worldIn.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
            worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(0)), 2);
            return ActionResultType.func_233537_a_(worldIn.isRemote);
        } else {
            return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
        }
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return state.get(AGE) < 3;
    }

    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        if (state.get(AGE) == 2) {
            if (worldIn.isAirBlock(pos.up())) {
                TallLavenderBlock tallLavender = (TallLavenderBlock) AbundanceBlocks.TALL_LAVENDER.get();
                tallLavender.placeAt(worldIn, pos, 2);
            }
        } else {
            int i = Math.min(2, state.get(AGE) + 1);
            worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i)), 2);
        }
    }
}

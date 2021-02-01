package com.teamaurora.abundance.common.block;

import com.minecraftabnormals.abnormals_core.common.blocks.LeafCarpetBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlossomCarpetBlock extends LeafCarpetBlock {
    public BlossomCarpetBlock(Properties properties) {
        super(properties);
    }

    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (worldIn.isAirBlock(pos.down()) && entityIn instanceof LivingEntity && entityIn.getType() != EntityType.BAT && entityIn.getType() != EntityType.BEE) {
            worldIn.destroyBlock(pos, false);
        }
    }
}

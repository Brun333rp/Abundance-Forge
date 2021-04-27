package com.teamaurora.abundance.common.world.gen.feature;

import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;

public class DirectionalBlockPos {

    private final BlockPos pos;
    private final Direction direction;

    public DirectionalBlockPos(BlockPos pos, Direction direction) {
        this.pos = pos;
        this.direction = direction;
    }

    public BlockPos getPos() {
        return this.pos;
    }

    public Direction getDirection() {
        return this.direction;
    }
}

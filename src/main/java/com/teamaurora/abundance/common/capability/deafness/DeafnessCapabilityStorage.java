package com.teamaurora.abundance.common.capability.deafness;

import com.teamaurora.abundance.core.Abundance;
import net.minecraft.nbt.ByteNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;

import javax.annotation.Nullable;

public class DeafnessCapabilityStorage implements Capability.IStorage<IDeafnessCapability> {

    @Nullable
    @Override
    public INBT writeNBT(Capability<IDeafnessCapability> capability, IDeafnessCapability instance, Direction side) {
        return ByteNBT.valueOf(instance.isDeaf());
    }

    @Override
    public void readNBT(Capability<IDeafnessCapability> capability, IDeafnessCapability instance, Direction side, INBT nbt) {
        if (nbt.getId() != Constants.NBT.TAG_BYTE) {
            Abundance.LOGGER.error("Tried to read deafness capability value, but got the wrong NBT type (Should be ByteNBT).");
            return;
        }
        instance.setDeaf(((ByteNBT)nbt).getByte() == 1);
    }
}
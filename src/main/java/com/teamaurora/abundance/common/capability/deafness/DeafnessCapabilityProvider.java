package com.teamaurora.abundance.common.capability.deafness;

import com.teamaurora.abundance.common.capability.AbundanceCapabilities;
import net.minecraft.nbt.ByteNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@SuppressWarnings("all")
public class DeafnessCapabilityProvider implements ICapabilitySerializable<ByteNBT> {

    private final IDeafnessCapability INSTANCE = AbundanceCapabilities.DEAFNESS_CAPABILITY.getDefaultInstance();
    private final LazyOptional<IDeafnessCapability> optional = LazyOptional.of(() -> INSTANCE);

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == AbundanceCapabilities.DEAFNESS_CAPABILITY ? optional.cast() : LazyOptional.empty();
    }

    @Override
    public ByteNBT serializeNBT() {
        return (ByteNBT) AbundanceCapabilities.DEAFNESS_CAPABILITY.getStorage().writeNBT(AbundanceCapabilities.DEAFNESS_CAPABILITY, INSTANCE, null);
    }

    @Override
    public void deserializeNBT(ByteNBT nbt) {
        AbundanceCapabilities.DEAFNESS_CAPABILITY.getStorage().readNBT(AbundanceCapabilities.DEAFNESS_CAPABILITY, INSTANCE, null, nbt);
    }
}

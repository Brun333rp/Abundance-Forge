package com.teamaurora.abundance.common.capability;

import com.teamaurora.abundance.common.capability.deafness.DeafnessCapabilityStorage;
import com.teamaurora.abundance.common.capability.deafness.DefaultDeafnessCapability;
import com.teamaurora.abundance.common.capability.deafness.IDeafnessCapability;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class AbundanceCapabilities {

    @CapabilityInject(IDeafnessCapability.class)
    public static final Capability<IDeafnessCapability> DEAFNESS_CAPABILITY = null;

    public static void registerCapabilities() {
        CapabilityManager.INSTANCE.register(IDeafnessCapability.class, new DeafnessCapabilityStorage(), DefaultDeafnessCapability::new);
    }
}

package com.teamaurora.abundance.common.event;

import com.teamaurora.abundance.common.capability.deafness.DeafnessCapabilityProvider;
import com.teamaurora.abundance.core.Abundance;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class AttachCapabilityEvents {

    @SubscribeEvent
    public void attachPlayerCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof PlayerEntity) {
            event.addCapability(Abundance.resourceLoc("deafness"), new DeafnessCapabilityProvider());
        }
    }
}

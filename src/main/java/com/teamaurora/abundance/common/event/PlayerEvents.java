package com.teamaurora.abundance.common.event;

import com.teamaurora.abundance.common.capability.CapabilityHelper;
import com.teamaurora.abundance.core.registry.AbundanceEffects;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraftforge.event.entity.living.PotionEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PlayerEvents {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onPotionEffectExpire(PotionEvent.PotionExpiryEvent event) {
        if (event.getPotionEffect() == null || !(event.getEntityLiving() instanceof ServerPlayerEntity))
            return;

        if (event.getPotionEffect().getPotion() == AbundanceEffects.DEAFNESS.get()) {
            ServerPlayerEntity player = (ServerPlayerEntity) event.getEntityLiving();
            CapabilityHelper.setPlayerDeafened(player, false);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onPotionEffectAdded(PotionEvent.PotionAddedEvent event) {
        if (event.getEntityLiving() instanceof ServerPlayerEntity) {
            ServerPlayerEntity player = (ServerPlayerEntity) event.getEntityLiving();
            Effect newEffect = event.getPotionEffect().getPotion();

            if (newEffect == AbundanceEffects.DEAFNESS.get()) {
                if (event.getOldPotionEffect() != null && event.getOldPotionEffect().getPotion() == newEffect)
                    return;

                CapabilityHelper.setPlayerDeafened(player, true);
            }
        }
    }
}

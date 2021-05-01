package com.teamaurora.abundance.common.event;

import com.teamaurora.abundance.common.capability.CapabilityHelper;
import com.teamaurora.abundance.common.network.NetworkHelper;
import com.teamaurora.abundance.core.registry.AbundanceEffects;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.PotionEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
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

    @SubscribeEvent
    public void onPotionRemoved(PotionEvent.PotionRemoveEvent event) {
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

    @SubscribeEvent
    public void onPlayerJoinWorld(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof ServerPlayerEntity) {
            ServerPlayerEntity player = (ServerPlayerEntity) event.getEntity();

            NetworkHelper.updatePlayerDeafness(player);
        }
    }

    @SubscribeEvent
    public void onPlayerDimensionChanged(PlayerEvent.PlayerChangedDimensionEvent event) {
        // Not even sure if destination and current
        // dimension can even be the same
        if (event.getFrom() == event.getTo()) {
            return;
        }

        if (event.getPlayer() instanceof ServerPlayerEntity) {
            NetworkHelper.updatePlayerDeafness((ServerPlayerEntity) event.getPlayer());
        }
    }

    @SubscribeEvent
    public void onPlayerCloned(PlayerEvent.Clone event) {
        // This is to make sure the deafness capability persists
        // after a player leaves The End.
        if (!event.isWasDeath()) {

            if (event.getPlayer() instanceof ServerPlayerEntity) {
                boolean deafened = CapabilityHelper.getPlayerDeafened(event.getOriginal());
                CapabilityHelper.setPlayerDeafened((ServerPlayerEntity) event.getPlayer(), deafened);
            }
        }
    }
}

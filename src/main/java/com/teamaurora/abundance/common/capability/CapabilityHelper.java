package com.teamaurora.abundance.common.capability;

import com.teamaurora.abundance.common.network.NetworkHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;

import javax.annotation.Nonnull;

@SuppressWarnings("all")
public class CapabilityHelper {

    public static void setPlayerDeafened(@Nonnull ServerPlayerEntity player, boolean deafened) {
        player.getCapability(AbundanceCapabilities.DEAFNESS_CAPABILITY).orElse(AbundanceCapabilities.DEAFNESS_CAPABILITY.getDefaultInstance()).setDeaf(deafened);
        NetworkHelper.updatePlayerDeafness(player, deafened);
    }

    public static boolean getPlayerDeafened(@Nonnull PlayerEntity player) {
        return player.getCapability(AbundanceCapabilities.DEAFNESS_CAPABILITY).orElse(AbundanceCapabilities.DEAFNESS_CAPABILITY.getDefaultInstance()).isDeaf();
    }
}

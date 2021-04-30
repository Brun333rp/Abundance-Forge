package com.teamaurora.abundance.common.network;

import com.teamaurora.abundance.common.network.messages.S2CUpdatePlayerDeafness;
import net.minecraft.entity.player.ServerPlayerEntity;

import javax.annotation.Nonnull;

public class NetworkHelper {

    public static void updatePlayerDeafness(@Nonnull ServerPlayerEntity player, boolean deafened) {
        PacketHandler.sendToClient(new S2CUpdatePlayerDeafness(deafened), player);
    }
}

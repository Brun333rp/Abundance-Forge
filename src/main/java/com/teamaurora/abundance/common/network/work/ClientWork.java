package com.teamaurora.abundance.common.network.work;

import com.teamaurora.abundance.common.capability.AbundanceCapabilities;
import com.teamaurora.abundance.common.network.messages.S2CUpdatePlayerDeafness;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;

public class ClientWork {

    @SuppressWarnings("all")
    public static void handleUpdatePlayerDeafness(S2CUpdatePlayerDeafness message) {
        ClientPlayerEntity clientPlayer = Minecraft.getInstance().player;

        if (clientPlayer != null) {
            clientPlayer.getCapability(AbundanceCapabilities.DEAFNESS_CAPABILITY).orElse(AbundanceCapabilities.DEAFNESS_CAPABILITY.getDefaultInstance()).setDeaf(message.deafened);
        }
    }
}

package com.teamaurora.abundance.common.misc.mixinwork;

import com.teamaurora.abundance.common.capability.CapabilityHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class MixinClientHooks {

    /**
     * Checks if the client player is deafened and
     * sets the parsed CallbackInfo to canceled if so.
     */
    public static void checkDeafenedAndCancel(CallbackInfo callbackInfo) {
        ClientPlayerEntity player = Minecraft.getInstance().player;

        if (player != null && CapabilityHelper.getPlayerDeafened(player)) {
            callbackInfo.cancel();
        }
    }
}

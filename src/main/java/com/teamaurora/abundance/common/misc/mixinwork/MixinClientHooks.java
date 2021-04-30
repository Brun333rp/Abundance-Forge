package com.teamaurora.abundance.common.misc.mixinwork;

import com.teamaurora.abundance.common.capability.CapabilityHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class MixinClientHooks {

    public static void handleOnPlaySound(CallbackInfo callbackInfo) {
        ClientPlayerEntity player = Minecraft.getInstance().player;

        if (player != null && CapabilityHelper.getPlayerDeafened(player)) {
            callbackInfo.cancel();
        }
    }
}

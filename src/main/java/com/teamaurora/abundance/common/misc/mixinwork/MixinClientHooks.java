package com.teamaurora.abundance.common.misc.mixinwork;

import com.teamaurora.abundance.common.capability.CapabilityHelper;
import com.teamaurora.abundance.core.Abundance;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.IAmbientSoundHandler;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Iterator;

public class MixinClientHooks {

    @SuppressWarnings("all")
    private static final Iterator<IAmbientSoundHandler> EMPTY_SOUND_HANDLER_ITERATOR = new ArrayList<IAmbientSoundHandler>().iterator();

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

    /**
     * Checks if the client player is deafened and
     * modifies the list of ambient sound handlers accordingly.
     *
     * @param soundHandlers The original iterator of sound handlers.
     * @return An iterator of sound handlers that will be ticked.
     */
    public static Iterator<IAmbientSoundHandler> clientPlayerModifyAmbientSoundList(Iterator<IAmbientSoundHandler> soundHandlers) {
        ClientPlayerEntity player = Minecraft.getInstance().player;

        if (player != null && CapabilityHelper.getPlayerDeafened(player)) {
            Abundance.LOGGER.info("Parsed the empty iterator");
            return EMPTY_SOUND_HANDLER_ITERATOR;
        }
        Abundance.LOGGER.info("Parsed the default iterator, smh");
        return soundHandlers;
    }
}

package com.teamaurora.abundance.common.mixin;

import com.mojang.authlib.GameProfile;
import com.teamaurora.abundance.common.misc.mixinwork.MixinClientHooks;
import net.minecraft.client.audio.IAmbientSoundHandler;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.Iterator;

@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin extends PlayerEntity {

    public ClientPlayerEntityMixin(World world, BlockPos pos, float headYaw, GameProfile gameProfile) {
        super(world, pos, headYaw, gameProfile);
    }

    @ModifyVariable(method = "tick", at = @At(value = "STORE"), index = 1, ordinal = 0, name = "var1", print = true)
    public Iterator<IAmbientSoundHandler> onTick(Iterator<IAmbientSoundHandler> soundHandlers) {
        return MixinClientHooks.clientPlayerModifyAmbientSoundList(soundHandlers);
    }
}

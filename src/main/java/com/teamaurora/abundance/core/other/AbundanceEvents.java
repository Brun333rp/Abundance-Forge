package com.teamaurora.abundance.core.other;

import com.teamaurora.abundance.core.Abundance;
import com.teamaurora.abundance.core.registry.AbundanceEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Abundance.MODID)
public class AbundanceEvents {
    @SubscribeEvent
    public static void onLivingEntityDamage(LivingDamageEvent event) {
        LivingEntity entity = event.getEntityLiving();
        if (entity.isPotionActive(AbundanceEffects.SUCCUMBING.get())) {
            int amplifier = entity.getActivePotionEffect(AbundanceEffects.SUCCUMBING.get()).getAmplifier();
            entity.addPotionEffect(new EffectInstance(Effects.POISON, 100 + 25 * amplifier, 0, false, false, false));
        }
    }
}

package com.teamaurora.abundance.common.potion;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IAngerable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class SupportiveEffect extends Effect {
    public SupportiveEffect() {
        super(EffectType.NEUTRAL, 0x845AAA);
    }

    // 0 = passive, 1 = neutral, 2 = hostile
    private int getHostility(Entity entity) {
        if (entity instanceof IAngerable) {
            return 1;
        } else if (entity instanceof AnimalEntity) {
            return 0;
        } else if (entity instanceof MonsterEntity) {
            return 2;
        } else {
            return 1;
        }
    }

    private int getHostilityBetween(Entity e1, Entity e2) {
        int hos1 = getHostility(e1);
        int hos2 = getHostility(e2);
        if (hos1 == 1 || hos2 == 1) {
            return 1;
        }
        if (hos1 == hos2) {
            return 0;
        }
        return 2;
    }

    @Override
    public void performEffect(LivingEntity livingEntity, int amplifier) {
        World world = livingEntity.getEntityWorld();
        BlockPos entityPos = livingEntity.getPosition();
        List<Entity> entities = world.getEntitiesWithinAABBExcludingEntity(livingEntity, new AxisAlignedBB(entityPos.add(-10, -10, -10), entityPos.add(10, 10, 10)));
        for (Entity entity : entities) {
            if (entity instanceof LivingEntity) {
                LivingEntity livingEntity2 = (LivingEntity) entity;
                int hostility = getHostilityBetween(livingEntity, livingEntity2);
                if (hostility == 0) {
                    // passive
                    livingEntity2.addPotionEffect(new EffectInstance(Effects.REGENERATION, 200, amplifier, false, true, true));
                } else if (hostility == 1) {
                    // neutral
                    livingEntity2.addPotionEffect(new EffectInstance(Effects.STRENGTH, 200, amplifier, false, true, true));
                } else {
                    // aggressive
                    livingEntity2.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 200, amplifier, false, true, true));
                }
            }
        }
    }

    @Override
    public void affectEntity(Entity source, Entity indirectSource, LivingEntity livingEntity, int amplifier, double health) {

    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }
}

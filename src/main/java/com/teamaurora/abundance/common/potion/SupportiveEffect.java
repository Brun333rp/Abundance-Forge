package com.teamaurora.abundance.common.potion;

import mcp.MethodsReturnNonnullByDefault;
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

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
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

    private int getHostilityBetween(Entity effectUser, Entity affectedEntity) {
        int hos1 = getHostility(effectUser);
        int hos2 = getHostility(affectedEntity);

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
        List<LivingEntity> entities = world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(entityPos.add(-10, -10, -10), entityPos.add(10, 10, 10)));
        entities.remove(livingEntity);

        for (LivingEntity affectedEntity : entities) {
            int hostility = getHostilityBetween(livingEntity, affectedEntity);
            Effect effectToApply;

            switch (hostility) {
                default:
                case 0:
                   // Passive
                    effectToApply = Effects.REGENERATION;
                    break;
                case 1:
                   // Strength
                    effectToApply = Effects.STRENGTH;
                    break;
                case 2:
                    // Aggressive
                    effectToApply = Effects.RESISTANCE;
                    break;
            }
            affectedEntity.addPotionEffect(new EffectInstance(effectToApply, 200, amplifier, false, true, true));
        }
    }

    @Override
    public void affectEntity(@Nullable Entity source, @Nullable Entity indirectSource, LivingEntity livingEntity, int amplifier, double health) {

    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return duration % 4 == 0;
    }
}

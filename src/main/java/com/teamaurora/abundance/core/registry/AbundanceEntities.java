package com.teamaurora.abundance.core.registry;

import com.minecraftabnormals.abnormals_core.core.util.registry.EntitySubRegistryHelper;
import com.teamaurora.abundance.common.entity.living.ScreecherEntity;
import com.teamaurora.abundance.core.Abundance;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Abundance.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AbundanceEntities {

    public static final EntitySubRegistryHelper HELPER = Abundance.REGISTRY_HELPER.getEntitySubHelper();

    public static final RegistryObject<EntityType<ScreecherEntity>> SCREECHER = HELPER.createLivingEntity("screecher", ScreecherEntity::new, EntityClassification.MONSTER, 2.0F, 2.0F);


    public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(SCREECHER.get(), ScreecherEntity.createScreecherAttributes().create());
    }
}

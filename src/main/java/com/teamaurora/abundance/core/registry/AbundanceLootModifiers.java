package com.teamaurora.abundance.core.registry;

import com.teamaurora.abundance.common.loot_modifier.LootModifierAdd;
import com.teamaurora.abundance.common.loot_modifier.LootModifierRemove;
import com.teamaurora.abundance.core.Abundance;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class AbundanceLootModifiers {

    public static final DeferredRegister<GlobalLootModifierSerializer<?>> LOOT_MODIFIER_SERIALIZERS = DeferredRegister.create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, Abundance.MODID);

    public static final RegistryObject<LootModifierAdd.LootModifierAddSerializer> ADD_ITEM_MODIFIER = register("add_item_modifier", LootModifierAdd.LootModifierAddSerializer::new);
    public static final RegistryObject<LootModifierRemove.LootModifierRemoveSerializer> REMOVE_ITEM_MODIFIER = register("remove_item_modifier", LootModifierRemove.LootModifierRemoveSerializer::new);


    private static <T extends GlobalLootModifierSerializer<?>> RegistryObject<T> register(String name, Supplier<T> serializerSupplier) {
        return LOOT_MODIFIER_SERIALIZERS.register(name, serializerSupplier);
    }
}

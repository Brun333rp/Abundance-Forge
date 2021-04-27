package com.teamaurora.abundance.core.registry;

import com.teamaurora.abundance.common.potion.SupportiveEffect;
import com.teamaurora.abundance.core.Abundance;
import net.minecraft.item.Items;
import net.minecraft.potion.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AbundanceEffects {
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, Abundance.MODID);
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTION_TYPES, Abundance.MODID);

    public static RegistryObject<Effect> SUPPORTIVE = EFFECTS.register("supportive", SupportiveEffect::new);


    public static final RegistryObject<Potion> SUPPORTIVE_NORMAL = POTIONS.register("supportive", ()->new Potion(new EffectInstance(SUPPORTIVE.get(), 1800)));
    public static final RegistryObject<Potion> SUPPORTIVE_LONG = POTIONS.register("supportive_long", ()->new Potion(new EffectInstance(SUPPORTIVE.get(), 3600)));
    public static final RegistryObject<Potion> SUPPORTIVE_STRONG = POTIONS.register("supportive_strong", ()->new Potion(new EffectInstance(SUPPORTIVE.get(), 864, 1)));

    public static void registerBrewingRecipes() {
        PotionBrewing.addMix(Potions.AWKWARD, AbundanceItems.LAVENDER.get(), SUPPORTIVE_NORMAL.get());
        PotionBrewing.addMix(SUPPORTIVE_NORMAL.get(), Items.GLOWSTONE_DUST, SUPPORTIVE_STRONG.get());
        PotionBrewing.addMix(SUPPORTIVE_NORMAL.get(), Items.REDSTONE, SUPPORTIVE_LONG.get());
    }
}

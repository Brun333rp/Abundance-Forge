package com.teamaurora.abundance.core.registry;

import com.teamaurora.abundance.common.potion.SuccumbingEffect;
import com.teamaurora.abundance.common.potion.SupportiveEffect;
import com.teamaurora.abundance.core.Abundance;
import net.minecraft.item.Items;
import net.minecraft.potion.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Abundance.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AbundanceEffects {
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, Abundance.MODID);
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTION_TYPES, Abundance.MODID);

    public static RegistryObject<Effect> SUCCUMBING = EFFECTS.register("succumbing", SuccumbingEffect::new);
    public static RegistryObject<Effect> SUPPORTIVE = EFFECTS.register("supportive", SupportiveEffect::new);

    public static final RegistryObject<Potion> SUCCUMBING_NORMAL = POTIONS.register("succumbing", ()->new Potion(new EffectInstance(SUCCUMBING.get(), 900)));
    public static final RegistryObject<Potion> SUCCUMBING_LONG = POTIONS.register("succumbing_long", ()->new Potion(new EffectInstance(SUCCUMBING.get(), 1800)));
    public static final RegistryObject<Potion> SUCCUMBING_STRONG = POTIONS.register("succumbing_strong", ()->new Potion(new EffectInstance(SUCCUMBING.get(), 432, 1)));

    public static final RegistryObject<Potion> SUPPORTIVE_NORMAL = POTIONS.register("supportive", ()->new Potion(new EffectInstance(SUPPORTIVE.get(), 1800)));
    public static final RegistryObject<Potion> SUPPORTIVE_LONG = POTIONS.register("supportive_long", ()->new Potion(new EffectInstance(SUPPORTIVE.get(), 3600)));
    public static final RegistryObject<Potion> SUPPORTIVE_STRONG = POTIONS.register("supportive_strong", ()->new Potion(new EffectInstance(SUPPORTIVE.get(), 864, 1)));

    public static void registerBrewingRecipes() {
        PotionBrewing.addMix(Potions.AWKWARD, AbundanceItems.SAGUARO_FLOWER.get(), SUCCUMBING_NORMAL.get());
        PotionBrewing.addMix(SUCCUMBING_NORMAL.get(), Items.GLOWSTONE_DUST, SUCCUMBING_STRONG.get());
        PotionBrewing.addMix(SUCCUMBING_NORMAL.get(), Items.REDSTONE, SUCCUMBING_LONG.get());
        PotionBrewing.addMix(Potions.AWKWARD, AbundanceItems.LAVENDER.get(), SUPPORTIVE_NORMAL.get());
        PotionBrewing.addMix(SUPPORTIVE_NORMAL.get(), Items.GLOWSTONE_DUST, SUPPORTIVE_STRONG.get());
        PotionBrewing.addMix(SUPPORTIVE_NORMAL.get(), Items.REDSTONE, SUPPORTIVE_LONG.get());
    }
}

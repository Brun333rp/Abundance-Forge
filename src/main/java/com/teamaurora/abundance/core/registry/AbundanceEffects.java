package com.teamaurora.abundance.core.registry;

import com.teamaurora.abundance.common.potion.SuccumbingEffect;
import com.teamaurora.abundance.core.Abundance;
import net.minecraft.potion.Effect;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Abundance.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AbundanceEffects {
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, Abundance.MODID);

    public static RegistryObject<Effect> SUCCUMBING = EFFECTS.register("succumbing", SuccumbingEffect::new);
}

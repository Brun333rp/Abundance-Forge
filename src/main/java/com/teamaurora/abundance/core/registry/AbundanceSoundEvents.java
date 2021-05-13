package com.teamaurora.abundance.core.registry;

import com.teamaurora.abundance.core.Abundance;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AbundanceSoundEvents {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Abundance.MODID);

    public static final RegistryObject<SoundEvent> SCREECHER_SCREECH = registerSound("screecher_screech");
    public static final RegistryObject<SoundEvent> SCREECHER_HURT = registerSound("screecher_hurt");
    public static final RegistryObject<SoundEvent> SCREECHER_DEATH = registerSound("screecher_death");


    private static RegistryObject<SoundEvent> registerSound(String name) {
        return SOUNDS.register(name, () -> new SoundEvent(Abundance.resourceLoc(name)));
    }
}

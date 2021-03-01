package com.teamaurora.abundance.core.registry;

import com.minecraftabnormals.abnormals_core.core.util.BiomeUtil;
import com.minecraftabnormals.abnormals_core.core.util.registry.BiomeSubRegistryHelper;
import com.mojang.datafixers.util.Pair;
import com.teamaurora.abundance.core.Abundance;
import com.teamaurora.abundance.core.AbundanceConfig;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Abundance.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AbundanceBiomes {
    private static final BiomeSubRegistryHelper HELPER = Abundance.REGISTRY_HELPER.getBiomeSubHelper();

    public static final BiomeSubRegistryHelper.KeyedBiome LAVENDER_FIELDS = HELPER.createBiome("lavender_fields", () -> makeLavenderFieldsBiome(-0.05F, 0.0F));
    public static final BiomeSubRegistryHelper.KeyedBiome LAVENDER_FOREST = HELPER.createBiome("lavender_forest", () -> makeLavenderFieldsBiome(0.375F, 0.15F));
    public static final BiomeSubRegistryHelper.KeyedBiome NEMOPHILA_FIELDS = HELPER.createBiome("nemophila_fields", () -> makeNemophilaFieldsBiome(0.1F, 0.025F));

    public static void addSubBiomes() {
        BiomeUtil.addHillBiome(LAVENDER_FIELDS.getKey(), Pair.of(LAVENDER_FOREST.getKey(), 1));
    }

    public static void registerBiomesToDictionary() {
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(LAVENDER_FIELDS.getKey(), AbundanceConfig.COMMON.lavenderFieldsWeight.get()));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(LAVENDER_FOREST.getKey(), AbundanceConfig.COMMON.lavenderForestWeight.get()));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(NEMOPHILA_FIELDS.getKey(), AbundanceConfig.COMMON.nemophilaFieldsWeight.get()));
    }

    public static void addBiomeTypes() {
        BiomeDictionary.addTypes(LAVENDER_FIELDS.getKey(), BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(LAVENDER_FOREST.getKey(), BiomeDictionary.Type.FOREST, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(NEMOPHILA_FIELDS.getKey(), BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.OVERWORLD);
    }

    private static Biome makeLavenderFieldsBiome(float depth, float scale) {
        return (new Biome.Builder())
                .precipitation(Biome.RainType.RAIN)
                .category(Biome.Category.PLAINS)
                .depth(depth)
                .scale(scale)
                .temperature(0.8F)
                .downfall(0.6F)
                .setEffects((new BiomeAmbience.Builder())
                        .setWaterColor(4159204)
                        .setWaterFogColor(329011)
                        .setFogColor(12638463)
                        .withSkyColor(getSkyColorWithTemperatureModifier(0.7F))
                        .setMoodSound(MoodSoundAmbience.DEFAULT_CAVE)
                        .build())
                .withMobSpawnSettings(new MobSpawnInfo.Builder().copy())
                .withGenerationSettings((new BiomeGenerationSettings.Builder())
                        .withSurfaceBuilder(ConfiguredSurfaceBuilders.field_244178_j)
                        .build()).build();
    }

    private static Biome makeNemophilaFieldsBiome(float depth, float scale) {
        return (new Biome.Builder())
                .precipitation(Biome.RainType.RAIN)
                .category(Biome.Category.PLAINS)
                .depth(depth)
                .scale(scale)
                .temperature(0.7F)
                .downfall(0.75F)
                .setEffects((new BiomeAmbience.Builder())
                        .setWaterColor(4159204)
                        .setWaterFogColor(329011)
                        .setFogColor(12638463)
                        .withSkyColor(getSkyColorWithTemperatureModifier(0.7F))
                        .setMoodSound(MoodSoundAmbience.DEFAULT_CAVE)
                        .build())
                .withMobSpawnSettings(new MobSpawnInfo.Builder().copy())
                .withGenerationSettings((new BiomeGenerationSettings.Builder())
                        .withSurfaceBuilder(ConfiguredSurfaceBuilders.field_244178_j)
                        .build()).build();
    }

    private static int getSkyColorWithTemperatureModifier(float temperature) {
        float lvt_1_1_ = temperature / 3.0F;
        lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
        return MathHelper.hsvToRGB(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
    }
}

package com.teamaurora.abundance.common.world.biome;

import com.minecraftabnormals.abnormals_core.core.util.DataUtil;
import com.teamaurora.abundance.core.Abundance;
import com.teamaurora.abundance.core.registry.AbundanceBiomes;
import com.teamaurora.abundance.core.registry.AbundanceFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = Abundance.MODID)
public class AbundanceBiomeFeatures {

    @SubscribeEvent
    public static void addFeatures(BiomeLoadingEvent event) {
        ResourceLocation biomeName = event.getName();

        if (DataUtil.matchesKeys(biomeName, AbundanceBiomes.LAVENDER_FIELDS.getKey())) {
            withLavenderFieldsFeatures(event.getGeneration(), event.getSpawns());
        }
        if (DataUtil.matchesKeys(biomeName, Biomes.FOREST, Biomes.WOODED_HILLS)) {
            event.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, AbundanceFeatures.Configured.TREES_REDBUD_SPARSE);
        } else if (DataUtil.matchesKeys(biomeName, Biomes.PLAINS)) {
            event.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, AbundanceFeatures.Configured.TREES_REDBUD_SPARSER);
        }
        if (DataUtil.matchesKeys(biomeName, Biomes.PLAINS)) {
            event.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, AbundanceFeatures.Configured.MARIGOLD);
        } else if (DataUtil.matchesKeys(biomeName, Biomes.SUNFLOWER_PLAINS)) {
            event.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, AbundanceFeatures.Configured.DENSE_MARIGOLD);
        }
        if (DataUtil.matchesKeys(biomeName, Biomes.BADLANDS, Biomes.BADLANDS_PLATEAU, Biomes.ERODED_BADLANDS, Biomes.MODIFIED_BADLANDS_PLATEAU, Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU, Biomes.WOODED_BADLANDS_PLATEAU)) {
            List<Supplier<ConfiguredFeature<?, ?>>> features = event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);
            if (event.getName() != null) {
                List<Supplier<ConfiguredFeature<?, ?>>> toRemove = new ArrayList<>();
                List<ConfiguredFeature<?, ?>> toAdd = new ArrayList<>();
                for (Supplier<ConfiguredFeature<?, ?>> configuredFeatureSupplier : features) {
                    IFeatureConfig config = configuredFeatureSupplier.get().config;
                    if (config instanceof DecoratedFeatureConfig) {
                        ConfiguredFeature<?, ?> configuredFeature = ((DecoratedFeatureConfig) config).feature.get();
                        if (configuredFeature.config instanceof DecoratedFeatureConfig) {
                            ConfiguredFeature<?, ?> configuredFeature1 = ((DecoratedFeatureConfig) configuredFeature.config).feature.get();
                            if (configuredFeature1.config instanceof BlockClusterFeatureConfig) {
                                BlockClusterFeatureConfig bcConfig = (BlockClusterFeatureConfig) configuredFeature1.config;
                                if (bcConfig.stateProvider instanceof SimpleBlockStateProvider) {
                                    SimpleBlockStateProvider sbsProvider = (SimpleBlockStateProvider) bcConfig.stateProvider;
                                    if (sbsProvider.getBlockState(new Random(), new BlockPos(0, 0, 0)).getBlock() == Blocks.CACTUS) {
                                        toRemove.add(configuredFeatureSupplier);
                                    }
                                }
                            }
                        }
                    }
                }
                toRemove.forEach(features::remove);
                event.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, AbundanceFeatures.Configured.PATCH_SAGUARO_CACTUS_DECORATED);
            }
        }
    }

    public static void withLavenderFieldsFeatures(BiomeGenerationSettingsBuilder builder, MobSpawnInfoBuilder spawns) {
        DefaultBiomeFeatures.withStrongholdAndMineshaft(builder);
        builder.withStructure(StructureFeatures.RUINED_PORTAL);
        DefaultBiomeFeatures.withCavesAndCanyons(builder);
        DefaultBiomeFeatures.withLavaAndWaterLakes(builder);
        DefaultBiomeFeatures.withMonsterRoom(builder);

        DefaultBiomeFeatures.withCommonOverworldBlocks(builder);
        DefaultBiomeFeatures.withOverworldOres(builder);
        DefaultBiomeFeatures.withDisks(builder);

        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, AbundanceFeatures.Configured.TREES_JACARANDA_REDBUD);
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.FLOWER_PLAIN_DECORATED);
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_GRASS_PLAIN);
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, AbundanceFeatures.Configured.LAVENDER);

        DefaultBiomeFeatures.withNormalMushroomGeneration(builder);
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_SUGAR_CANE);
        DefaultBiomeFeatures.withLavaAndWaterSprings(builder);
        DefaultBiomeFeatures.withFrozenTopLayer(builder);

        DefaultBiomeFeatures.withBatsAndHostiles(spawns);
        DefaultBiomeFeatures.withPassiveMobs(spawns);
        spawns.isValidSpawnBiomeForPlayer();
    }
}

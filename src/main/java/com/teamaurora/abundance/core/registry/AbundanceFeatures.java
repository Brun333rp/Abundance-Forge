package com.teamaurora.abundance.core.registry;

import com.google.common.collect.ImmutableList;
import com.teamaurora.abundance.common.world.gen.feature.JacarandaFeature;
import com.teamaurora.abundance.common.world.gen.feature.LavenderFeature;
import com.teamaurora.abundance.common.world.gen.feature.MarigoldFeature;
import com.teamaurora.abundance.common.world.gen.feature.RedbudFeature;
import com.teamaurora.abundance.core.Abundance;
import net.minecraft.block.BlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Abundance.MODID)
public class AbundanceFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Abundance.MODID);

    public static final RegistryObject<Feature<BaseTreeFeatureConfig>> JACARANDA_TREE = FEATURES.register("jacaranda_tree", ()->new JacarandaFeature(BaseTreeFeatureConfig.CODEC));
    public static final RegistryObject<Feature<BaseTreeFeatureConfig>> REDBUD_TREE = FEATURES.register("redbud_tree", ()->new RedbudFeature(BaseTreeFeatureConfig.CODEC));

    public static final RegistryObject<Feature<NoFeatureConfig>> LAVENDER = FEATURES.register("lavender", ()->new LavenderFeature(NoFeatureConfig.field_236558_a_));
    public static final RegistryObject<Feature<NoFeatureConfig>> MARIGOLD = FEATURES.register("marigold", ()->new MarigoldFeature(NoFeatureConfig.field_236558_a_));

    public static final class BlockStates {
        public static final BlockState JACARANDA_LOG = AbundanceBlocks.JACARANDA_LOG.get().getDefaultState();
        public static final BlockState JACARANDA_LEAVES = AbundanceBlocks.JACARANDA_LEAVES.get().getDefaultState();
        public static final BlockState BUDDING_JACARANDA_LEAVES = AbundanceBlocks.BUDDING_JACARANDA_LEAVES.get().getDefaultState();
        public static final BlockState FLOWERING_JACARANDA_LEAVES = AbundanceBlocks.FLOWERING_JACARANDA_LEAVES.get().getDefaultState();

        public static final BlockState REDBUD_LOG = AbundanceBlocks.REDBUD_LOG.get().getDefaultState();
        public static final BlockState FLOWERING_REDBUD_LOG = AbundanceBlocks.FLOWERING_REDBUD_LOG.get().getDefaultState();
        public static final BlockState REDBUD_LEAVES = AbundanceBlocks.REDBUD_LEAVES.get().getDefaultState();
        public static final BlockState FLOWERING_REDBUD_LEAVES = AbundanceBlocks.FLOWERING_REDBUD_LEAVES.get().getDefaultState();
    }

    public static final class Configs {
        public static final BaseTreeFeatureConfig JACARANDA_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
                new SimpleBlockStateProvider(BlockStates.JACARANDA_LOG),
                new SimpleBlockStateProvider(BlockStates.JACARANDA_LEAVES),
                new BlobFoliagePlacer(FeatureSpread.func_242252_a(0), FeatureSpread.func_242252_a(0), 0),
                new StraightTrunkPlacer(0, 0, 0),
                new TwoLayerFeature(0, 0, 0)
        )).setIgnoreVines().build();
        public static final BaseTreeFeatureConfig FLOWERING_JACARANDA_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
                new SimpleBlockStateProvider(BlockStates.JACARANDA_LOG),
                new WeightedBlockStateProvider().addWeightedBlockstate(BlockStates.BUDDING_JACARANDA_LEAVES, 3).addWeightedBlockstate(BlockStates.FLOWERING_JACARANDA_LEAVES, 2),
                new BlobFoliagePlacer(FeatureSpread.func_242252_a(0), FeatureSpread.func_242252_a(0), 0),
                new StraightTrunkPlacer(0, 0, 0),
                new TwoLayerFeature(0, 0, 0)
        )).setIgnoreVines().build();
        public static final BaseTreeFeatureConfig REDBUD_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
                new WeightedBlockStateProvider().addWeightedBlockstate(BlockStates.REDBUD_LOG, 1).addWeightedBlockstate(BlockStates.FLOWERING_REDBUD_LOG, 1),
                new WeightedBlockStateProvider().addWeightedBlockstate(BlockStates.REDBUD_LEAVES, 2).addWeightedBlockstate(BlockStates.FLOWERING_REDBUD_LEAVES, 1),
                new BlobFoliagePlacer(FeatureSpread.func_242252_a(0), FeatureSpread.func_242252_a(0), 0),
                new StraightTrunkPlacer(0, 0, 0),
                new TwoLayerFeature(0, 0, 0)
        )).setIgnoreVines().build();
    }

    public static final class Configured {
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> JACARANDA = AbundanceFeatures.JACARANDA_TREE.get().withConfiguration(Configs.JACARANDA_TREE_CONFIG);
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FLOWERING_JACARANDA = AbundanceFeatures.JACARANDA_TREE.get().withConfiguration(Configs.FLOWERING_JACARANDA_TREE_CONFIG);
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> JACARANDA_BEES_005 = AbundanceFeatures.JACARANDA_TREE.get().withConfiguration(Configs.JACARANDA_TREE_CONFIG.func_236685_a_(ImmutableList.of(Features.Placements.BEES_005_PLACEMENT)));
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FLOWERING_JACARANDA_BEES_005 = AbundanceFeatures.JACARANDA_TREE.get().withConfiguration(Configs.FLOWERING_JACARANDA_TREE_CONFIG.func_236685_a_(ImmutableList.of(Features.Placements.BEES_005_PLACEMENT)));
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> JACARANDA_BEES_0002 = AbundanceFeatures.JACARANDA_TREE.get().withConfiguration(Configs.JACARANDA_TREE_CONFIG.func_236685_a_(ImmutableList.of(Features.Placements.BEES_0002_PLACEMENT)));
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FLOWERING_JACARANDA_BEES_0002 = AbundanceFeatures.JACARANDA_TREE.get().withConfiguration(Configs.FLOWERING_JACARANDA_TREE_CONFIG.func_236685_a_(ImmutableList.of(Features.Placements.BEES_0002_PLACEMENT)));

        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> REDBUD = AbundanceFeatures.REDBUD_TREE.get().withConfiguration(Configs.REDBUD_TREE_CONFIG);

        public static final ConfiguredFeature<?, ?> TREES_JACARANDA_REDBUD = Feature.RANDOM_SELECTOR.withConfiguration((new MultipleRandomFeatureConfig(ImmutableList.of(Configured.JACARANDA_BEES_0002.withChance(0.1F), Configured.REDBUD.withChance(0.3F)), Configured.FLOWERING_JACARANDA_BEES_0002))).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(8)));
        public static final ConfiguredFeature<?, ?> TREES_REDBUD_SPARSE = REDBUD.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(64)));
        public static final ConfiguredFeature<?, ?> TREES_REDBUD_SPARSER = REDBUD.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(256)));

        public static final ConfiguredFeature<?, ?> LAVENDER = AbundanceFeatures.LAVENDER.get().withConfiguration(NoFeatureConfig.field_236559_b_).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(3, 0.1F, 1)));
        public static final ConfiguredFeature<?, ?> MARIGOLD = AbundanceFeatures.MARIGOLD.get().withConfiguration(NoFeatureConfig.field_236559_b_).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(32)));
        public static final ConfiguredFeature<?, ?> DENSE_MARIGOLD = AbundanceFeatures.MARIGOLD.get().withConfiguration(NoFeatureConfig.field_236559_b_).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1)));

        private static <FC extends IFeatureConfig> void register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
            Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(Abundance.MODID, name), configuredFeature);
        }

        public static void registerConfiguredFeatures() {
            register("jacaranda", JACARANDA);
            register("flowering_jacaranda", FLOWERING_JACARANDA);
            register("jacaranda_bees_005", JACARANDA_BEES_005);
            register("flowering_jacaranda_bees_005", FLOWERING_JACARANDA_BEES_005);
            register("jacaranda_bees_0002", JACARANDA_BEES_0002);
            register("flowering_jacaranda_bees_0002", FLOWERING_JACARANDA_BEES_0002);

            register("redbud", REDBUD);

            register("trees_jacaranda_redbud", TREES_JACARANDA_REDBUD);
            register("trees_redbud_sparse", TREES_REDBUD_SPARSE);
            register("trees_redbud_sparser", TREES_REDBUD_SPARSER);

            register("lavender", LAVENDER);
        }
    }
}

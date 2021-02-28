package com.teamaurora.abundance.core.registry;

import com.google.common.collect.ImmutableList;
import com.teamaurora.abundance.common.world.gen.feature.*;
import com.teamaurora.abundance.core.Abundance;
import net.minecraft.block.BlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.ColumnBlockPlacer;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
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

    public static final RegistryObject<Feature<BaseTreeFeatureConfig>> SAGUARO_CACTUS = FEATURES.register("saguaro_cactus", ()->new SaguaroCactusFeature(BaseTreeFeatureConfig.CODEC));

    public static final RegistryObject<Feature<NoFeatureConfig>> LAVENDER = FEATURES.register("lavender", ()->new LavenderFeature(NoFeatureConfig.field_236558_a_));
    public static final RegistryObject<Feature<NoFeatureConfig>> MARIGOLD = FEATURES.register("marigold", ()->new MarigoldFeature(NoFeatureConfig.field_236558_a_));
    public static final RegistryObject<Feature<NoFeatureConfig>> NEMOPHILA = FEATURES.register("nemophila", ()->new NemophilaFeature(NoFeatureConfig.field_236558_a_));

    public static final class BlockStates {
        public static final BlockState JACARANDA_LOG = AbundanceBlocks.JACARANDA_LOG.get().getDefaultState();
        public static final BlockState JACARANDA_LEAVES = AbundanceBlocks.JACARANDA_LEAVES.get().getDefaultState();
        public static final BlockState BUDDING_JACARANDA_LEAVES = AbundanceBlocks.BUDDING_JACARANDA_LEAVES.get().getDefaultState();
        public static final BlockState FLOWERING_JACARANDA_LEAVES = AbundanceBlocks.FLOWERING_JACARANDA_LEAVES.get().getDefaultState();

        public static final BlockState REDBUD_LOG = AbundanceBlocks.REDBUD_LOG.get().getDefaultState();
        public static final BlockState FLOWERING_REDBUD_LOG = AbundanceBlocks.FLOWERING_REDBUD_LOG.get().getDefaultState();
        public static final BlockState REDBUD_LEAVES = AbundanceBlocks.REDBUD_LEAVES.get().getDefaultState();
        public static final BlockState BUDDING_REDBUD_LEAVES = AbundanceBlocks.BUDDING_REDBUD_LEAVES.get().getDefaultState();
        public static final BlockState FLOWERING_REDBUD_LEAVES = AbundanceBlocks.FLOWERING_REDBUD_LEAVES.get().getDefaultState();

        public static final BlockState SAGUARO_CACTUS = AbundanceBlocks.SAGUARO_CACTUS.get().getDefaultState();

        public static final BlockState CHICORY = AbundanceBlocks.CHICORY.get().getDefaultState();
        public static final BlockState AMARANTHUS = AbundanceBlocks.AMARANTHUS.get().getDefaultState();
        public static final BlockState PURPLE_AFRICAN_DAISY = AbundanceBlocks.PURPLE_AFRICAN_DAISY.get().getDefaultState();
        public static final BlockState YELLOW_AFRICAN_DAISY = AbundanceBlocks.YELLOW_AFRICAN_DAISY.get().getDefaultState();
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
                new SimpleBlockStateProvider(BlockStates.REDBUD_LOG),
                new WeightedBlockStateProvider().addWeightedBlockstate(BlockStates.REDBUD_LEAVES, 3).addWeightedBlockstate(BlockStates.BUDDING_REDBUD_LEAVES, 1),
                new BlobFoliagePlacer(FeatureSpread.func_242252_a(0), FeatureSpread.func_242252_a(0), 0),
                new StraightTrunkPlacer(0, 0, 0),
                new TwoLayerFeature(0, 0, 0)
        )).setIgnoreVines().build();
        public static final BaseTreeFeatureConfig FLOWERING_REDBUD_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
                new WeightedBlockStateProvider().addWeightedBlockstate(BlockStates.REDBUD_LOG, 1).addWeightedBlockstate(BlockStates.FLOWERING_REDBUD_LOG, 1),
                new WeightedBlockStateProvider().addWeightedBlockstate(BlockStates.BUDDING_REDBUD_LEAVES, 4).addWeightedBlockstate(BlockStates.FLOWERING_REDBUD_LEAVES, 1),
                new BlobFoliagePlacer(FeatureSpread.func_242252_a(0), FeatureSpread.func_242252_a(0), 0),
                new StraightTrunkPlacer(0, 0, 0),
                new TwoLayerFeature(0, 0, 0)
        )).setIgnoreVines().build();

        public static final BlockClusterFeatureConfig CHICORY_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockStates.CHICORY), SimpleBlockPlacer.PLACER)).tries(64).func_227317_b_().build();
        public static final BlockClusterFeatureConfig AMARANTHUS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockStates.AMARANTHUS), SimpleBlockPlacer.PLACER)).tries(64).func_227317_b_().build();
        public static final BlockClusterFeatureConfig YELLOW_AFRICAN_DAISY_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockStates.YELLOW_AFRICAN_DAISY), SimpleBlockPlacer.PLACER)).tries(64).func_227317_b_().build();
        public static final BlockClusterFeatureConfig PURPLE_AFRICAN_DAISY_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockStates.PURPLE_AFRICAN_DAISY), SimpleBlockPlacer.PLACER)).tries(64).func_227317_b_().build();
    }

    public static final class Configured {
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> JACARANDA = AbundanceFeatures.JACARANDA_TREE.get().withConfiguration(Configs.JACARANDA_TREE_CONFIG);
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FLOWERING_JACARANDA = AbundanceFeatures.JACARANDA_TREE.get().withConfiguration(Configs.FLOWERING_JACARANDA_TREE_CONFIG);
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> JACARANDA_BEES_005 = AbundanceFeatures.JACARANDA_TREE.get().withConfiguration(Configs.JACARANDA_TREE_CONFIG.func_236685_a_(ImmutableList.of(Features.Placements.BEES_005_PLACEMENT)));
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FLOWERING_JACARANDA_BEES_005 = AbundanceFeatures.JACARANDA_TREE.get().withConfiguration(Configs.FLOWERING_JACARANDA_TREE_CONFIG.func_236685_a_(ImmutableList.of(Features.Placements.BEES_005_PLACEMENT)));
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> JACARANDA_BEES_0002 = AbundanceFeatures.JACARANDA_TREE.get().withConfiguration(Configs.JACARANDA_TREE_CONFIG.func_236685_a_(ImmutableList.of(Features.Placements.BEES_0002_PLACEMENT)));
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FLOWERING_JACARANDA_BEES_0002 = AbundanceFeatures.JACARANDA_TREE.get().withConfiguration(Configs.FLOWERING_JACARANDA_TREE_CONFIG.func_236685_a_(ImmutableList.of(Features.Placements.BEES_0002_PLACEMENT)));

        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> REDBUD = AbundanceFeatures.REDBUD_TREE.get().withConfiguration(Configs.REDBUD_TREE_CONFIG);
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FLOWERING_REDBUD = AbundanceFeatures.REDBUD_TREE.get().withConfiguration(Configs.FLOWERING_REDBUD_TREE_CONFIG);

        public static final ConfiguredFeature<?, ?> TREES_JACARANDA_REDBUD = Feature.RANDOM_SELECTOR.withConfiguration((new MultipleRandomFeatureConfig(ImmutableList.of(Configured.FLOWERING_REDBUD.withChance(0.1F), Configured.JACARANDA_BEES_0002.withChance(0.5F)), Configured.FLOWERING_JACARANDA_BEES_0002))).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(8)));
        public static final ConfiguredFeature<?, ?> TREES_REDBUD_SPARSE = REDBUD.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(64)));
        public static final ConfiguredFeature<?, ?> TREES_REDBUD_SPARSER = REDBUD.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(256)));
        public static final ConfiguredFeature<?, ?> TREES_JACARANDA = JACARANDA_BEES_0002.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(16)));
        public static final ConfiguredFeature<?, ?> TREES_JACARANDA_MIXED = Feature.RANDOM_SELECTOR.withConfiguration((new MultipleRandomFeatureConfig(ImmutableList.of(Configured.JACARANDA_BEES_0002.withChance(0.5F)), Configured.FLOWERING_JACARANDA_BEES_0002))).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 0.5F, 1)));

        public static final ConfiguredFeature<?, ?> LAVENDER = AbundanceFeatures.LAVENDER.get().withConfiguration(NoFeatureConfig.field_236559_b_).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(3, 0.1F, 1)));
        public static final ConfiguredFeature<?, ?> LAVENDER_SPARSE = AbundanceFeatures.LAVENDER.get().withConfiguration(NoFeatureConfig.field_236559_b_).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(3)));
        public static final ConfiguredFeature<?, ?> MARIGOLD = AbundanceFeatures.MARIGOLD.get().withConfiguration(NoFeatureConfig.field_236559_b_).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(32)));
        public static final ConfiguredFeature<?, ?> DENSE_MARIGOLD = AbundanceFeatures.MARIGOLD.get().withConfiguration(NoFeatureConfig.field_236559_b_).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1)));

        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> SAGUARO_CACTUS = AbundanceFeatures.SAGUARO_CACTUS.get().withConfiguration(Configs.JACARANDA_TREE_CONFIG); // this can use any config - it was originally a NoFeatureConfig but was changed to BaseTreeFeatureConfig to reuse sapling code
        public static final ConfiguredFeature<?, ?> SAGUARO_CACTUS_DECORATED = SAGUARO_CACTUS.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 3)));

        public static final ConfiguredFeature<?, ?> NEMOPHILA = AbundanceFeatures.NEMOPHILA.get().withConfiguration(NoFeatureConfig.field_236559_b_).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(64)));
        public static final ConfiguredFeature<?, ?> NEMOPHILA_NOT_QUITE_AS_DENSE = AbundanceFeatures.NEMOPHILA.get().withConfiguration(NoFeatureConfig.field_236559_b_).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(4)));
        public static final ConfiguredFeature<?, ?> NEMOPHILA_DENSE = AbundanceFeatures.NEMOPHILA.get().withConfiguration(NoFeatureConfig.field_236559_b_).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(24, 0.2F, 2)));

        public static final ConfiguredFeature<?, ?> CHICORY = Feature.RANDOM_PATCH.withConfiguration(Configs.CHICORY_CONFIG).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(24)));
        public static final ConfiguredFeature<?, ?> CHICORY_DENSE = Feature.RANDOM_PATCH.withConfiguration(Configs.CHICORY_CONFIG).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(6)));
        public static final ConfiguredFeature<?, ?> AMARANTHUS = Feature.RANDOM_PATCH.withConfiguration(Configs.AMARANTHUS_CONFIG).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(6)));
        public static final ConfiguredFeature<?, ?> YELLOW_AFRICAN_DAISY = Feature.RANDOM_PATCH.withConfiguration(Configs.YELLOW_AFRICAN_DAISY_CONFIG).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(18)));
        public static final ConfiguredFeature<?, ?> PURPLE_AFRICAN_DAISY = Feature.RANDOM_PATCH.withConfiguration(Configs.PURPLE_AFRICAN_DAISY_CONFIG).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(18)));
        public static final ConfiguredFeature<?, ?> YELLOW_AFRICAN_DAISY_SPARSE = Feature.NO_BONEMEAL_FLOWER.withConfiguration(Configs.YELLOW_AFRICAN_DAISY_CONFIG).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(32)));
        public static final ConfiguredFeature<?, ?> PURPLE_AFRICAN_DAISY_SPARSE = Feature.NO_BONEMEAL_FLOWER.withConfiguration(Configs.PURPLE_AFRICAN_DAISY_CONFIG).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.CHANCE.configure(new ChanceConfig(32)));


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
            register("flowering_redbud", FLOWERING_REDBUD);

            register("trees_jacaranda_redbud", TREES_JACARANDA_REDBUD);
            register("trees_redbud_sparse", TREES_REDBUD_SPARSE);
            register("trees_redbud_sparser", TREES_REDBUD_SPARSER);
            register("trees_jacaranda", TREES_JACARANDA);
            register("trees_jacaranda_mixed", TREES_JACARANDA_MIXED);

            register("lavender", LAVENDER);
            register("lavender_sparse", LAVENDER_SPARSE);

            register("saguaro_cactus", SAGUARO_CACTUS);
            register("saguaro_cactus_decorated", SAGUARO_CACTUS_DECORATED);

            register("nemophila", NEMOPHILA);
            register("nemophila_not_quite_as_dense", NEMOPHILA_NOT_QUITE_AS_DENSE);
            register("nemophila_dense", NEMOPHILA_DENSE);

            register("amaranthus", AMARANTHUS);
            register("chicory", CHICORY);
            register("chicory_dense", CHICORY_DENSE);
            register("yellow_african_daisy", YELLOW_AFRICAN_DAISY);
            register("purple_african_daisy", PURPLE_AFRICAN_DAISY);
            register("yellow_african_daisy_sparse", YELLOW_AFRICAN_DAISY_SPARSE);
            register("purple_african_daisy_sparse", PURPLE_AFRICAN_DAISY_SPARSE);
        }
    }
}

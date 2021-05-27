package com.teamaurora.abundance.core.registry;

import com.minecraftabnormals.abnormals_core.common.blocks.*;
import com.minecraftabnormals.abnormals_core.common.blocks.chest.AbnormalsChestBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.chest.AbnormalsTrappedChestBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.sign.AbnormalsStandingSignBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.sign.AbnormalsWallSignBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.wood.*;
import com.minecraftabnormals.abnormals_core.core.util.registry.BlockSubRegistryHelper;
import com.mojang.datafixers.util.Pair;
import com.teamaurora.abundance.common.block.*;
import com.teamaurora.abundance.common.block.trees.FloweringRedbudTree;
import com.teamaurora.abundance.common.block.trees.JacarandaTree;
import com.teamaurora.abundance.common.block.trees.RedbudTree;
import com.teamaurora.abundance.core.Abundance;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.trees.OakTree;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Abundance.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AbundanceBlocks {
    public static final BlockSubRegistryHelper HELPER = Abundance.REGISTRY_HELPER.getBlockSubHelper();

    // lavender
    public static final RegistryObject<Block> LAVENDER = HELPER.createBlockNoItem("lavender", ()->new LavenderBlock(AbstractBlock.Properties.from(Blocks.ALLIUM)));
    public static final RegistryObject<Block> TALL_LAVENDER = HELPER.createBlockNoItem("tall_lavender", ()->new TallLavenderBlock(AbstractBlock.Properties.from(Blocks.ALLIUM)));
    public static final RegistryObject<Block> LAVENDER_BASKET = HELPER.createCompatBlock("quark", "lavender_basket", ()->new Block(Block.Properties.create(Material.WOOL, MaterialColor.PURPLE).hardnessAndResistance(0.5F).sound(SoundType.WOOD)), ItemGroup.DECORATIONS);

    // marigold
    public static final RegistryObject<Block> SUNNY_MARIGOLD = HELPER.createBlock("sunny_marigold", ()->new MarigoldBlock(()->Effects.INSTANT_HEALTH, 1, AbstractBlock.Properties.from(Blocks.DANDELION)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> SHADY_MARIGOLD = HELPER.createBlock("shady_marigold", ()->new MarigoldBlock(()->Effects.INSTANT_HEALTH, 1, AbstractBlock.Properties.from(Blocks.DANDELION)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> TALL_MARIGOLD = HELPER.createBlock("tall_marigold", ()->new TallMarigoldBlock(AbstractBlock.Properties.from(Blocks.DANDELION)), ItemGroup.DECORATIONS);

    public static final RegistryObject<Block> POTTED_SUNNY_MARIGOLD = HELPER.createBlockNoItem("potted_sunny_marigold", ()->new FlowerPotBlock(SUNNY_MARIGOLD.get(), Properties.FLOWER_POT));
    public static final RegistryObject<Block> POTTED_SHADY_MARIGOLD = HELPER.createBlockNoItem("potted_shady_marigold", ()->new FlowerPotBlock(SHADY_MARIGOLD.get(), Properties.FLOWER_POT));

    // TODO: FIX CHEST UVS!
    // dunno why they're so janky - bottom pixel of lid/top pixel of base seems to have z-fighting

    // jacaranda
    public static final RegistryObject<Block> STRIPPED_JACARANDA_LOG = HELPER.createBlock("stripped_jacaranda_log", ()->new StrippedLogBlock(Properties.LOG), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_JACARANDA_WOOD = HELPER.createBlock("stripped_jacaranda_wood", ()->new StrippedWoodBlock(Properties.LOG), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> JACARANDA_LOG= HELPER.createBlock("jacaranda_log", ()->new AbnormalsLogBlock(STRIPPED_JACARANDA_LOG, Properties.LOG), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> JACARANDA_WOOD = HELPER.createBlock("jacaranda_wood", ()->new WoodBlock(STRIPPED_JACARANDA_WOOD, Properties.LOG), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> JACARANDA_LEAVES = HELPER.createBlock("jacaranda_leaves", ()->new AbnormalsLeavesBlock(Properties.JACARANDA_LEAVES), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> JACARANDA_SAPLING = HELPER.createBlock("jacaranda_sapling", ()->new AbnormalsSaplingBlock(new JacarandaTree(), Properties.SAPLING), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> POTTED_JACARANDA_SAPLING = HELPER.createBlockNoItem("potted_jacaranda_sapling", ()->new FlowerPotBlock(JACARANDA_SAPLING.get(), Properties.FLOWER_POT));
    public static final RegistryObject<Block> JACARANDA_PLANKS = HELPER.createBlock("jacaranda_planks", ()->new PlanksBlock(Properties.PLANKS), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> JACARANDA_SLAB = HELPER.createBlock("jacaranda_slab", ()->new WoodSlabBlock(Properties.PLANKS), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> JACARANDA_STAIRS = HELPER.createBlock("jacaranda_stairs", ()->new WoodStairsBlock(JACARANDA_PLANKS.get().getDefaultState(), Properties.PLANKS), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> JACARANDA_PRESSURE_PLATE = HELPER.createBlock("jacaranda_pressure_plate", ()->new WoodPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Properties.PRESSURE_PLATE), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> JACARANDA_FENCE = HELPER.createFuelBlock("jacaranda_fence", ()->new WoodFenceBlock(Properties.PLANKS), 300, ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> JACARANDA_FENCE_GATE = HELPER.createFuelBlock("jacaranda_fence_gate", ()->new WoodFenceGateBlock(Properties.PLANKS), 300, ItemGroup.REDSTONE);
    public static final RegistryObject<Block> JACARANDA_BUTTON = HELPER.createBlock("jacaranda_button", ()->new AbnormalsWoodButtonBlock(Properties.BUTTON), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> JACARANDA_DOOR = HELPER.createBlock("jacaranda_door", ()->new WoodDoorBlock(Properties.DOOR), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> JACARANDA_TRAPDOOR = HELPER.createBlock("jacaranda_trapdoor", ()->new WoodTrapDoorBlock(Properties.DOOR), ItemGroup.REDSTONE);
    public static final Pair<RegistryObject<AbnormalsStandingSignBlock>, RegistryObject<AbnormalsWallSignBlock>> JACARANDA_SIGNS = HELPER.createSignBlock("jacaranda", MaterialColor.PURPLE_TERRACOTTA);

    public static final RegistryObject<Block> JACARANDA_BOOKSHELF = HELPER.createCompatFuelBlock("quark", "jacaranda_bookshelf", ()->new BookshelfBlock(Properties.BOOKSHELF), 300, ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> VERTICAL_JACARANDA_PLANKS = HELPER.createCompatBlock("quark", "vertical_jacaranda_planks", ()->new Block(Properties.PLANKS), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> JACARANDA_VERTICAL_SLAB = HELPER.createCompatFuelBlock("quark", "jacaranda_vertical_slab", ()->new VerticalSlabBlock(Properties.PLANKS), 150, ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> JACARANDA_LADDER = HELPER.createCompatFuelBlock("quark", "jacaranda_ladder", ()->new AbnormalsLadderBlock(Properties.LADDER), 300, ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> JACARANDA_LEAF_CARPET = HELPER.createCompatBlock("quark", "jacaranda_leaf_carpet", ()->new LeafCarpetBlock(Properties.JACARANDA_CARPET), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> STRIPPED_JACARANDA_POST = HELPER.createCompatFuelBlock("quark", "stripped_jacaranda_post", () -> new WoodPostBlock(Properties.PLANKS), 300, ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> JACARANDA_POST = HELPER.createCompatFuelBlock("quark", "jacaranda_post", () -> new WoodPostBlock(STRIPPED_JACARANDA_POST, Properties.PLANKS), 300, ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> JACARANDA_HEDGE = HELPER.createCompatFuelBlock("quark", "jacaranda_hedge", () -> new HedgeBlock(Properties.HEDGE), 300, ItemGroup.DECORATIONS);
    public static final Pair<RegistryObject<AbnormalsChestBlock>, RegistryObject<AbnormalsTrappedChestBlock>> JACARANDA_CHESTS = HELPER.createCompatChestBlocks("quark", "jacaranda", MaterialColor.PURPLE_TERRACOTTA);

    public static final RegistryObject<Block> JACARANDA_BEEHIVE = HELPER.createCompatBlock("buzzier_bees", "jacaranda_beehive", ()->new AbnormalsBeehiveBlock(Block.Properties.from(Blocks.BEEHIVE)), ItemGroup.DECORATIONS);

    public static final RegistryObject<Block> BUDDING_JACARANDA_LEAVES = HELPER.createBlock("budding_jacaranda_leaves", ()->new AbnormalsLeavesBlock(Properties.JACARANDA_LEAVES), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> FLOWERING_JACARANDA_LEAVES = HELPER.createBlock("flowering_jacaranda_leaves", ()->new AbnormalsLeavesBlock(Properties.JACARANDA_LEAVES), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> BUDDING_JACARANDA_LEAF_CARPET = HELPER.createCompatBlock("quark", "budding_jacaranda_leaf_carpet", ()->new LeafCarpetBlock(Properties.JACARANDA_CARPET), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> FLOWERING_JACARANDA_LEAF_CARPET = HELPER.createCompatBlock("quark", "flowering_jacaranda_leaf_carpet", ()->new LeafCarpetBlock(Properties.JACARANDA_CARPET), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> BUDDING_JACARANDA_HEDGE = HELPER.createCompatFuelBlock("quark", "budding_jacaranda_hedge", () -> new HedgeBlock(Properties.HEDGE), 300, ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> FLOWERING_JACARANDA_HEDGE = HELPER.createCompatFuelBlock("quark", "flowering_jacaranda_hedge", () -> new HedgeBlock(Properties.HEDGE), 300, ItemGroup.DECORATIONS);

    // redbud
    public static final RegistryObject<Block> STRIPPED_REDBUD_LOG = HELPER.createBlock("stripped_redbud_log", ()->new StrippedLogBlock(Properties.LOG), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_REDBUD_WOOD = HELPER.createBlock("stripped_redbud_wood", ()->new StrippedWoodBlock(Properties.LOG), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDBUD_LOG = HELPER.createBlock("redbud_log", ()->new AbnormalsLogBlock(STRIPPED_REDBUD_LOG, Properties.LOG), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDBUD_WOOD = HELPER.createBlock("redbud_wood", ()->new WoodBlock(STRIPPED_REDBUD_WOOD, Properties.LOG), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDBUD_LEAVES = HELPER.createBlock("redbud_leaves", ()->new AbnormalsLeavesBlock(Properties.REDBUD_LEAVES), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> REDBUD_SAPLING = HELPER.createBlock("redbud_sapling", ()->new AbnormalsSaplingBlock(new RedbudTree(), Properties.SAPLING), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> POTTED_REDBUD_SAPLING = HELPER.createBlockNoItem("potted_redbud_sapling", ()->new FlowerPotBlock(REDBUD_SAPLING.get(), Properties.FLOWER_POT));
    public static final RegistryObject<Block> REDBUD_PLANKS = HELPER.createBlock("redbud_planks", ()->new PlanksBlock(Properties.PLANKS), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDBUD_SLAB = HELPER.createBlock("redbud_slab", ()->new WoodSlabBlock(Properties.PLANKS), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDBUD_STAIRS = HELPER.createBlock("redbud_stairs", ()->new WoodStairsBlock(REDBUD_PLANKS.get().getDefaultState(), Properties.PLANKS), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDBUD_PRESSURE_PLATE = HELPER.createBlock("redbud_pressure_plate", ()->new WoodPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Properties.PRESSURE_PLATE), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> REDBUD_FENCE = HELPER.createFuelBlock("redbud_fence", ()->new WoodFenceBlock(Properties.PLANKS), 300, ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> REDBUD_FENCE_GATE = HELPER.createFuelBlock("redbud_fence_gate", ()->new WoodFenceGateBlock(Properties.PLANKS), 300, ItemGroup.REDSTONE);
    public static final RegistryObject<Block> REDBUD_BUTTON = HELPER.createBlock("redbud_button", ()->new AbnormalsWoodButtonBlock(Properties.BUTTON), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> REDBUD_DOOR = HELPER.createBlock("redbud_door", ()->new WoodDoorBlock(Properties.DOOR), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> REDBUD_TRAPDOOR = HELPER.createBlock("redbud_trapdoor", ()->new WoodTrapDoorBlock(Properties.DOOR), ItemGroup.REDSTONE);
    public static final Pair<RegistryObject<AbnormalsStandingSignBlock>, RegistryObject<AbnormalsWallSignBlock>> REDBUD_SIGNS = HELPER.createSignBlock("redbud", MaterialColor.PURPLE_TERRACOTTA);

    public static final RegistryObject<Block> REDBUD_BOOKSHELF = HELPER.createCompatFuelBlock("quark", "redbud_bookshelf", ()->new BookshelfBlock(Properties.BOOKSHELF), 300, ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> VERTICAL_REDBUD_PLANKS = HELPER.createCompatBlock("quark", "vertical_redbud_planks", ()->new Block(Properties.PLANKS), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDBUD_VERTICAL_SLAB = HELPER.createCompatFuelBlock("quark", "redbud_vertical_slab", ()->new VerticalSlabBlock(Properties.PLANKS), 150, ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDBUD_LADDER = HELPER.createCompatFuelBlock("quark", "redbud_ladder", ()->new AbnormalsLadderBlock(Properties.LADDER), 300, ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> REDBUD_LEAF_CARPET = HELPER.createCompatBlock("quark", "redbud_leaf_carpet", ()->new LeafCarpetBlock(Properties.REDBUD_CARPET), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> STRIPPED_REDBUD_POST = HELPER.createCompatFuelBlock("quark", "stripped_redbud_post", () -> new WoodPostBlock(Properties.PLANKS), 300, ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDBUD_POST = HELPER.createCompatFuelBlock("quark", "redbud_post", () -> new WoodPostBlock(STRIPPED_REDBUD_POST, Properties.PLANKS), 300, ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDBUD_HEDGE = HELPER.createCompatFuelBlock("quark", "redbud_hedge", () -> new HedgeBlock(Properties.HEDGE), 300, ItemGroup.DECORATIONS);
    public static final Pair<RegistryObject<AbnormalsChestBlock>, RegistryObject<AbnormalsTrappedChestBlock>> REDBUD_CHESTS = HELPER.createCompatChestBlocks("quark", "redbud", MaterialColor.PURPLE_TERRACOTTA);

    public static final RegistryObject<Block> REDBUD_BEEHIVE = HELPER.createCompatBlock("buzzier_bees", "redbud_beehive", ()->new AbnormalsBeehiveBlock(Block.Properties.from(Blocks.BEEHIVE)), ItemGroup.DECORATIONS);

    public static final RegistryObject<Block> FLOWERING_REDBUD_LOG= HELPER.createBlock("flowering_redbud_log", ()->new FloweringLogBlock(REDBUD_LOG, STRIPPED_REDBUD_LOG, Properties.LOG), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> FLOWERING_REDBUD_WOOD= HELPER.createBlock("flowering_redbud_wood", ()->new FloweringWoodBlock(REDBUD_WOOD, STRIPPED_REDBUD_WOOD, Properties.LOG), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> FLOWERING_REDBUD_LEAVES = HELPER.createBlock("flowering_redbud_leaves", ()->new AbnormalsLeavesBlock(Properties.REDBUD_LEAVES), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> FLOWERING_REDBUD_LEAF_CARPET = HELPER.createCompatBlock("quark", "flowering_redbud_leaf_carpet", ()->new LeafCarpetBlock(Properties.REDBUD_CARPET), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> BUDDING_REDBUD_LEAVES = HELPER.createBlock("budding_redbud_leaves", ()->new AbnormalsLeavesBlock(Properties.REDBUD_LEAVES), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> BUDDING_REDBUD_LEAF_CARPET = HELPER.createCompatBlock("quark", "budding_redbud_leaf_carpet", ()->new LeafCarpetBlock(Properties.REDBUD_CARPET), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> BUDDING_REDBUD_HEDGE = HELPER.createCompatFuelBlock("quark", "budding_redbud_hedge", () -> new HedgeBlock(Properties.HEDGE), 300, ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> FLOWERING_REDBUD_HEDGE = HELPER.createCompatFuelBlock("quark", "flowering_redbud_hedge", () -> new HedgeBlock(Properties.HEDGE), 300, ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> FLOWERING_REDBUD_SAPLING = HELPER.createBlock("flowering_redbud_sapling", ()->new AbnormalsSaplingBlock(new FloweringRedbudTree(), Properties.SAPLING), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> POTTED_FLOWERING_REDBUD_SAPLING = HELPER.createBlockNoItem("potted_flowering_redbud_sapling", ()->new FlowerPotBlock(FLOWERING_REDBUD_SAPLING.get(), Properties.FLOWER_POT));

    public static final RegistryObject<Block> PINK_BLOSSOM_CARPET = HELPER.createBlock("pink_blossom_carpet", ()->new BlossomCarpetBlock(AbstractBlock.Properties.create(Material.CARPET, MaterialColor.PURPLE).notSolid().hardnessAndResistance(0.0f).tickRandomly().sound(SoundType.PLANT).harvestTool(ToolType.HOE)), ItemGroup.DECORATIONS);

    // random new flowers
    public static final RegistryObject<Block> CHICORY = HELPER.createBlock("chicory", ()->new AbnormalsFlowerBlock(()->Effects.HASTE, 5, AbstractBlock.Properties.from(Blocks.ALLIUM)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> AMARANTHUS = HELPER.createBlock("amaranthus", ()->new ThiccFlowerBlock(()->Effects.HUNGER, 6, AbstractBlock.Properties.from(Blocks.POPPY)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> NEMOPHILA = HELPER.createBlock("nemophila", ()->new NemophilaBlock(()->Effects.SPEED, 8, AbstractBlock.Properties.from(Blocks.CORNFLOWER)), ItemGroup.DECORATIONS);

    public static final RegistryObject<Block> POTTED_CHICORY = HELPER.createBlockNoItem("potted_chicory", ()->new FlowerPotBlock(CHICORY.get(), Properties.FLOWER_POT));
    public static final RegistryObject<Block> POTTED_AMARANTHUS = HELPER.createBlockNoItem("potted_amaranthus", ()->new FlowerPotBlock(AMARANTHUS.get(), Properties.FLOWER_POT));
    public static final RegistryObject<Block> POTTED_NEMOPHILA = HELPER.createBlockNoItem("potted_nemophila", ()->new FlowerPotBlock(NEMOPHILA.get(), Properties.FLOWER_POT));

    // sacc
    public static final RegistryObject<Block> SUNFLOWER_SEED_SACK = HELPER.createCompatBlock("quark", "sunflower_seed_sack", ()->new Block(Block.Properties.create(Material.WOOL, MaterialColor.GRAY).hardnessAndResistance(0.5F).sound(SoundType.CLOTH)), ItemGroup.DECORATIONS);

    public static class Properties {
        public static final AbstractBlock.Properties JACARANDA_LEAVES = AbstractBlock.Properties.create(Material.LEAVES, MaterialColor.PURPLE).harvestTool(ToolType.HOE).notSolid().hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).setAllowsSpawn(AbundanceBlocks.Properties::allowsSpawnOnLeaves).setSuffocates(AbundanceBlocks.Properties::isntSolid).setBlocksVision(AbundanceBlocks.Properties::isntSolid);;
        public static final AbstractBlock.Properties JACARANDA_CARPET = AbstractBlock.Properties.create(Material.CARPET, MaterialColor.PURPLE).hardnessAndResistance(0.0F).sound(SoundType.PLANT).harvestTool(ToolType.HOE).notSolid();
        public static final AbstractBlock.Properties REDBUD_LEAVES = AbstractBlock.Properties.create(Material.LEAVES, MaterialColor.PINK).harvestTool(ToolType.HOE).notSolid().hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).setAllowsSpawn(AbundanceBlocks.Properties::allowsSpawnOnLeaves).setSuffocates(AbundanceBlocks.Properties::isntSolid).setBlocksVision(AbundanceBlocks.Properties::isntSolid);;
        public static final AbstractBlock.Properties REDBUD_CARPET = AbstractBlock.Properties.create(Material.CARPET, MaterialColor.PINK).hardnessAndResistance(0.0F).sound(SoundType.PLANT).harvestTool(ToolType.HOE).notSolid();


        public static final AbstractBlock.Properties HEDGE = AbstractBlock.Properties.from(Blocks.OAK_FENCE);
        public static final AbstractBlock.Properties PLANKS = AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD);
        public static final AbstractBlock.Properties DOOR = AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).notSolid().hardnessAndResistance(3.0F).sound(SoundType.WOOD);
        public static final AbstractBlock.Properties BUTTON = AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD);
        public static final AbstractBlock.Properties PRESSURE_PLATE = AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD);
        public static final AbstractBlock.Properties LADDER = AbstractBlock.Properties.create(Material.MISCELLANEOUS).notSolid().harvestTool(ToolType.AXE).hardnessAndResistance(0.4F).sound(SoundType.LADDER);
        public static final AbstractBlock.Properties BOOKSHELF = AbstractBlock.Properties.create(Material.WOOD).hardnessAndResistance(1.5F).sound(SoundType.WOOD);
        public static final AbstractBlock.Properties LOG = AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F).sound(SoundType.WOOD);
        public static final AbstractBlock.Properties SAPLING = AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F).sound(SoundType.PLANT);

        public static final AbstractBlock.Properties FLOWER_POT = AbstractBlock.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.0F).notSolid();

        public static boolean allowsSpawnOnLeaves(BlockState state, IBlockReader access, BlockPos pos, EntityType<?> entity) {
            return entity == EntityType.OCELOT || entity == EntityType.PARROT;
        }

        public static boolean alwaysAllowSpawn(BlockState state, IBlockReader reader, BlockPos pos, EntityType<?> entity) {
            return true;
        }

        public static boolean needsPostProcessing(BlockState state, IBlockReader reader, BlockPos pos) {
            return true;
        }

        public static boolean isntSolid(BlockState state, IBlockReader reader, BlockPos pos) {
            return false;
        }
    }
}

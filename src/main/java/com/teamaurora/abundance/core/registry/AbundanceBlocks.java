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
import com.teamaurora.abundance.common.block.trees.SaguaroCactusTree;
import com.teamaurora.abundance.core.Abundance;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.trees.OakTree;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Abundance.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AbundanceBlocks {
    public static final BlockSubRegistryHelper HELPER = Abundance.REGISTRY_HELPER.getBlockSubHelper();

    // lavender
    public static final RegistryObject<Block> LAVENDER = HELPER.createBlockNoItem("lavender", ()->new LavenderBlock(AbstractBlock.Properties.from(Blocks.ALLIUM)));
    public static final RegistryObject<Block> TALL_LAVENDER = HELPER.createBlockNoItem("tall_lavender", ()->new TallLavenderBlock(AbstractBlock.Properties.from(Blocks.ALLIUM)));
    public static final RegistryObject<Block> LAVENDER_BLOSSOM_CARPET = HELPER.createBlock("lavender_blossom_carpet", ()->new BlossomCarpetBlock(AbstractBlock.Properties.create(Material.CARPET, MaterialColor.PURPLE).notSolid().hardnessAndResistance(0.0f).tickRandomly().sound(SoundType.PLANT).harvestTool(ToolType.HOE)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> LAVENDER_BASKET = HELPER.createCompatBlock("quark", "lavender_basket", ()->new Block(Block.Properties.create(Material.WOOL, MaterialColor.PURPLE).hardnessAndResistance(0.5F).sound(SoundType.WOOD)), ItemGroup.DECORATIONS);

    // marigold
    public static final RegistryObject<Block> SUNNY_MARIGOLD = HELPER.createBlock("sunny_marigold", ()->new MarigoldBlock(()->Effects.INSTANT_HEALTH, 1, AbstractBlock.Properties.from(Blocks.DANDELION)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> SHADY_MARIGOLD = HELPER.createBlock("shady_marigold", ()->new MarigoldBlock(()->Effects.INSTANT_HEALTH, 1, AbstractBlock.Properties.from(Blocks.DANDELION)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> TALL_MARIGOLD = HELPER.createBlock("tall_marigold", ()->new TallMarigoldBlock(AbstractBlock.Properties.from(Blocks.DANDELION)), ItemGroup.DECORATIONS);

    // TODO: FIX CHEST UVS!
    // dunno why they're so janky - bottom pixel of lid/top pixel of base seems to have z-fighting

    // jacaranda
    public static final RegistryObject<Block> STRIPPED_JACARANDA_LOG = HELPER.createBlock("stripped_jacaranda_log", ()->new StrippedLogBlock(Block.Properties.from(Blocks.STRIPPED_OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_JACARANDA_WOOD = HELPER.createBlock("stripped_jacaranda_wood", ()->new StrippedWoodBlock(Block.Properties.from(Blocks.STRIPPED_OAK_WOOD)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> JACARANDA_LOG= HELPER.createBlock("jacaranda_log", ()->new AbnormalsLogBlock(STRIPPED_JACARANDA_LOG, Block.Properties.from(Blocks.OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> JACARANDA_WOOD = HELPER.createBlock("jacaranda_wood", ()->new WoodBlock(STRIPPED_JACARANDA_WOOD, Block.Properties.from(Blocks.OAK_WOOD)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> JACARANDA_LEAVES = HELPER.createBlock("jacaranda_leaves", ()->new AbnormalsLeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> JACARANDA_SAPLING = HELPER.createBlock("jacaranda_sapling", ()->new AbnormalsSaplingBlock(new JacarandaTree(), Block.Properties.from(Blocks.OAK_SAPLING)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> POTTED_JACARANDA_SAPLING = HELPER.createBlockNoItem("potted_jacaranda_sapling", ()->new FlowerPotBlock(JACARANDA_SAPLING.get(), Block.Properties.from(Blocks.POTTED_ALLIUM)));
    public static final RegistryObject<Block> JACARANDA_PLANKS = HELPER.createBlock("jacaranda_planks", ()->new PlanksBlock(Block.Properties.from(Blocks.OAK_PLANKS)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> JACARANDA_SLAB = HELPER.createBlock("jacaranda_slab", ()->new WoodSlabBlock(Block.Properties.from(Blocks.OAK_SLAB)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> JACARANDA_STAIRS = HELPER.createBlock("jacaranda_stairs", ()->new WoodStairsBlock(JACARANDA_PLANKS.get().getDefaultState(), Block.Properties.from(Blocks.OAK_STAIRS)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> JACARANDA_PRESSURE_PLATE = HELPER.createBlock("jacaranda_pressure_plate", ()->new WoodPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.from(Blocks.OAK_PRESSURE_PLATE)), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> JACARANDA_FENCE = HELPER.createFuelBlock("jacaranda_fence", ()->new WoodFenceBlock(Block.Properties.from(Blocks.OAK_FENCE)), 300, ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> JACARANDA_FENCE_GATE = HELPER.createFuelBlock("jacaranda_fence_gate", ()->new WoodFenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)), 300, ItemGroup.REDSTONE);
    public static final RegistryObject<Block> JACARANDA_BUTTON = HELPER.createBlock("jacaranda_button", ()->new AbnormalsWoodButtonBlock(Block.Properties.from(Blocks.OAK_BUTTON)), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> JACARANDA_DOOR = HELPER.createBlock("jacaranda_door", ()->new WoodDoorBlock(Block.Properties.from(Blocks.OAK_DOOR)), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> JACARANDA_TRAPDOOR = HELPER.createBlock("jacaranda_trapdoor", ()->new WoodTrapDoorBlock(Block.Properties.from(Blocks.OAK_TRAPDOOR)), ItemGroup.REDSTONE);
    public static final Pair<RegistryObject<AbnormalsStandingSignBlock>, RegistryObject<AbnormalsWallSignBlock>> JACARANDA_SIGNS = HELPER.createSignBlock("jacaranda", MaterialColor.PURPLE_TERRACOTTA);

    public static final RegistryObject<Block> JACARANDA_BOOKSHELF = HELPER.createCompatFuelBlock("quark", "jacaranda_bookshelf", ()->new BookshelfBlock(Block.Properties.from(Blocks.BOOKSHELF)), 300, ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> VERTICAL_JACARANDA_PLANKS = HELPER.createCompatBlock("quark", "vertical_jacaranda_planks", ()->new Block(Block.Properties.from(Blocks.OAK_PLANKS)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> JACARANDA_VERTICAL_SLAB = HELPER.createCompatFuelBlock("quark", "jacaranda_vertical_slab", ()->new VerticalSlabBlock(Block.Properties.from(Blocks.OAK_PLANKS)), 150, ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> JACARANDA_LADDER = HELPER.createCompatFuelBlock("quark", "jacaranda_ladder", ()->new AbnormalsLadderBlock(Block.Properties.from(Blocks.LADDER).harvestTool(ToolType.AXE)), 300, ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> JACARANDA_LEAF_CARPET = HELPER.createCompatBlock("quark", "jacaranda_leaf_carpet", ()->new LeafCarpetBlock(Block.Properties.from(JACARANDA_LEAVES.get())), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> STRIPPED_JACARANDA_POST = HELPER.createCompatFuelBlock("quark", "stripped_jacaranda_post", () -> new WoodPostBlock(AbstractBlock.Properties.from(Blocks.OAK_FENCE)), 300, ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> JACARANDA_POST = HELPER.createCompatFuelBlock("quark", "jacaranda_post", () -> new WoodPostBlock(STRIPPED_JACARANDA_POST, AbstractBlock.Properties.from(Blocks.OAK_FENCE)), 300, ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> JACARANDA_HEDGE = HELPER.createCompatFuelBlock("quark", "jacaranda_hedge", () -> new HedgeBlock(AbstractBlock.Properties.from(Blocks.OAK_FENCE)), 300, ItemGroup.DECORATIONS);
    public static final Pair<RegistryObject<AbnormalsChestBlock>, RegistryObject<AbnormalsTrappedChestBlock>> JACARANDA_CHESTS = HELPER.createCompatChestBlocks("jacaranda", MaterialColor.PURPLE_TERRACOTTA);

    public static final RegistryObject<Block> JACARANDA_BEEHIVE = HELPER.createCompatBlock("buzzier_bees", "jacaranda_beehive", ()->new AbnormalsBeehiveBlock(Block.Properties.from(Blocks.BEEHIVE)), ItemGroup.DECORATIONS);

    public static final RegistryObject<Block> BUDDING_JACARANDA_LEAVES = HELPER.createBlock("budding_jacaranda_leaves", ()->new AbnormalsLeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> FLOWERING_JACARANDA_LEAVES = HELPER.createBlock("flowering_jacaranda_leaves", ()->new AbnormalsLeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> BUDDING_JACARANDA_LEAF_CARPET = HELPER.createCompatBlock("quark", "budding_jacaranda_leaf_carpet", ()->new LeafCarpetBlock(Block.Properties.from(JACARANDA_LEAVES.get())), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> FLOWERING_JACARANDA_LEAF_CARPET = HELPER.createCompatBlock("quark", "flowering_jacaranda_leaf_carpet", ()->new LeafCarpetBlock(Block.Properties.from(JACARANDA_LEAVES.get())), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> BUDDING_JACARANDA_HEDGE = HELPER.createCompatFuelBlock("quark", "budding_jacaranda_hedge", () -> new HedgeBlock(AbstractBlock.Properties.from(Blocks.OAK_FENCE)), 300, ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> FLOWERING_JACARANDA_HEDGE = HELPER.createCompatFuelBlock("quark", "flowering_jacaranda_hedge", () -> new HedgeBlock(AbstractBlock.Properties.from(Blocks.OAK_FENCE)), 300, ItemGroup.DECORATIONS);

    // redbud
    public static final RegistryObject<Block> STRIPPED_REDBUD_LOG = HELPER.createBlock("stripped_redbud_log", ()->new StrippedLogBlock(Block.Properties.from(Blocks.STRIPPED_OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_REDBUD_WOOD = HELPER.createBlock("stripped_redbud_wood", ()->new StrippedWoodBlock(Block.Properties.from(Blocks.STRIPPED_OAK_WOOD)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDBUD_LOG = HELPER.createBlock("redbud_log", ()->new AbnormalsLogBlock(STRIPPED_REDBUD_LOG, Block.Properties.from(Blocks.OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDBUD_WOOD = HELPER.createBlock("redbud_wood", ()->new WoodBlock(STRIPPED_REDBUD_WOOD, Block.Properties.from(Blocks.OAK_WOOD)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDBUD_LEAVES = HELPER.createBlock("redbud_leaves", ()->new AbnormalsLeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> REDBUD_SAPLING = HELPER.createBlock("redbud_sapling", ()->new AbnormalsSaplingBlock(new RedbudTree(), Block.Properties.from(Blocks.OAK_SAPLING)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> POTTED_REDBUD_SAPLING = HELPER.createBlockNoItem("potted_redbud_sapling", ()->new FlowerPotBlock(REDBUD_SAPLING.get(), Block.Properties.from(Blocks.POTTED_ALLIUM)));
    public static final RegistryObject<Block> REDBUD_PLANKS = HELPER.createBlock("redbud_planks", ()->new PlanksBlock(Block.Properties.from(Blocks.OAK_PLANKS)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDBUD_SLAB = HELPER.createBlock("redbud_slab", ()->new WoodSlabBlock(Block.Properties.from(Blocks.OAK_SLAB)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDBUD_STAIRS = HELPER.createBlock("redbud_stairs", ()->new WoodStairsBlock(REDBUD_PLANKS.get().getDefaultState(), Block.Properties.from(Blocks.OAK_STAIRS)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDBUD_PRESSURE_PLATE = HELPER.createBlock("redbud_pressure_plate", ()->new WoodPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.from(Blocks.OAK_PRESSURE_PLATE)), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> REDBUD_FENCE = HELPER.createFuelBlock("redbud_fence", ()->new WoodFenceBlock(Block.Properties.from(Blocks.OAK_FENCE)), 300, ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> REDBUD_FENCE_GATE = HELPER.createFuelBlock("redbud_fence_gate", ()->new WoodFenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)), 300, ItemGroup.REDSTONE);
    public static final RegistryObject<Block> REDBUD_BUTTON = HELPER.createBlock("redbud_button", ()->new AbnormalsWoodButtonBlock(Block.Properties.from(Blocks.OAK_BUTTON)), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> REDBUD_DOOR = HELPER.createBlock("redbud_door", ()->new WoodDoorBlock(Block.Properties.from(Blocks.OAK_DOOR)), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> REDBUD_TRAPDOOR = HELPER.createBlock("redbud_trapdoor", ()->new WoodTrapDoorBlock(Block.Properties.from(Blocks.OAK_TRAPDOOR)), ItemGroup.REDSTONE);
    public static final Pair<RegistryObject<AbnormalsStandingSignBlock>, RegistryObject<AbnormalsWallSignBlock>> REDBUD_SIGNS = HELPER.createSignBlock("redbud", MaterialColor.PURPLE_TERRACOTTA);

    public static final RegistryObject<Block> REDBUD_BOOKSHELF = HELPER.createCompatFuelBlock("quark", "redbud_bookshelf", ()->new BookshelfBlock(Block.Properties.from(Blocks.BOOKSHELF)), 300, ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> VERTICAL_REDBUD_PLANKS = HELPER.createCompatBlock("quark", "vertical_redbud_planks", ()->new Block(Block.Properties.from(Blocks.OAK_PLANKS)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDBUD_VERTICAL_SLAB = HELPER.createCompatFuelBlock("quark", "redbud_vertical_slab", ()->new VerticalSlabBlock(Block.Properties.from(Blocks.OAK_PLANKS)), 150, ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDBUD_LADDER = HELPER.createCompatFuelBlock("quark", "redbud_ladder", ()->new AbnormalsLadderBlock(Block.Properties.from(Blocks.LADDER).harvestTool(ToolType.AXE)), 300, ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> REDBUD_LEAF_CARPET = HELPER.createCompatBlock("quark", "redbud_leaf_carpet", ()->new LeafCarpetBlock(Block.Properties.from(REDBUD_LEAVES.get())), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> STRIPPED_REDBUD_POST = HELPER.createCompatFuelBlock("quark", "stripped_redbud_post", () -> new WoodPostBlock(AbstractBlock.Properties.from(Blocks.OAK_FENCE)), 300, ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDBUD_POST = HELPER.createCompatFuelBlock("quark", "redbud_post", () -> new WoodPostBlock(STRIPPED_REDBUD_POST, AbstractBlock.Properties.from(Blocks.OAK_FENCE)), 300, ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDBUD_HEDGE = HELPER.createCompatFuelBlock("quark", "redbud_hedge", () -> new HedgeBlock(AbstractBlock.Properties.from(Blocks.OAK_FENCE)), 300, ItemGroup.DECORATIONS);
    public static final Pair<RegistryObject<AbnormalsChestBlock>, RegistryObject<AbnormalsTrappedChestBlock>> REDBUD_CHESTS = HELPER.createCompatChestBlocks("redbud", MaterialColor.PURPLE_TERRACOTTA);

    public static final RegistryObject<Block> REDBUD_BEEHIVE = HELPER.createCompatBlock("buzzier_bees", "redbud_beehive", ()->new AbnormalsBeehiveBlock(Block.Properties.from(Blocks.BEEHIVE)), ItemGroup.DECORATIONS);

    public static final RegistryObject<Block> FLOWERING_REDBUD_LOG= HELPER.createBlock("flowering_redbud_log", ()->new AbnormalsLogBlock(STRIPPED_REDBUD_LOG, Block.Properties.from(Blocks.OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> FLOWERING_REDBUD_LEAVES = HELPER.createBlock("flowering_redbud_leaves", ()->new AbnormalsLeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> FLOWERING_REDBUD_LEAF_CARPET = HELPER.createCompatBlock("quark", "flowering_redbud_leaf_carpet", ()->new LeafCarpetBlock(Block.Properties.from(REDBUD_LEAVES.get())), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> BUDDING_REDBUD_LEAVES = HELPER.createBlock("budding_redbud_leaves", ()->new AbnormalsLeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> BUDDING_REDBUD_LEAF_CARPET = HELPER.createCompatBlock("quark", "budding_redbud_leaf_carpet", ()->new LeafCarpetBlock(Block.Properties.from(REDBUD_LEAVES.get())), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> BUDDING_REDBUD_HEDGE = HELPER.createCompatFuelBlock("quark", "budding_redbud_hedge", () -> new HedgeBlock(AbstractBlock.Properties.from(Blocks.OAK_FENCE)), 300, ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> FLOWERING_REDBUD_HEDGE = HELPER.createCompatFuelBlock("quark", "flowering_redbud_hedge", () -> new HedgeBlock(AbstractBlock.Properties.from(Blocks.OAK_FENCE)), 300, ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> FLOWERING_REDBUD_SAPLING = HELPER.createBlock("flowering_redbud_sapling", ()->new AbnormalsSaplingBlock(new FloweringRedbudTree(), Block.Properties.from(Blocks.OAK_SAPLING)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> POTTED_FLOWERING_REDBUD_SAPLING = HELPER.createBlockNoItem("potted_flowering_redbud_sapling", ()->new FlowerPotBlock(REDBUD_SAPLING.get(), Block.Properties.from(Blocks.POTTED_ALLIUM)));

    // saguaro cactus
    public static final RegistryObject<Block> SAGUARO_CACTUS = HELPER.createBlock("saguaro_cactus", ()->new SaguaroCactusBlock(Block.Properties.from(Blocks.CACTUS)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> SMALL_SAGUARO_CACTUS = HELPER.createBlock("small_saguaro_cactus", ()->new SmallSaguaroCactusBlock(AbstractBlock.Properties.from(Blocks.CACTUS)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> SAGUARO_SPROUT = HELPER.createBlockNoItem("saguaro_sprout", ()->new SaguaroSproutBlock(new SaguaroCactusTree(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING).sound(SoundType.CLOTH)));
    public static final RegistryObject<Block> SAGUARO_FLOWER = HELPER.createBlockNoItem("saguaro_flower", ()->new SaguaroFlowerBlock(AbstractBlock.Properties.from(Blocks.OXEYE_DAISY)));

    // random new flowers
    public static final RegistryObject<Block> CHICORY = HELPER.createBlock("chicory", ()->new AbnormalsFlowerBlock(()->Effects.HASTE, 5, AbstractBlock.Properties.from(Blocks.ALLIUM)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> AMARANTHUS = HELPER.createBlock("amaranthus", ()->new ThiccFlowerBlock(()->Effects.HUNGER, 6, AbstractBlock.Properties.from(Blocks.POPPY)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> NEMOPHILA = HELPER.createBlock("nemophila", ()->new NemophilaBlock(()->Effects.SPEED, 8, AbstractBlock.Properties.from(Blocks.CORNFLOWER)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> PURPLE_AFRICAN_DAISY = HELPER.createBlock("purple_african_daisy", ()->new AbnormalsFlowerBlock(()->Effects.REGENERATION, 8, AbstractBlock.Properties.from(Blocks.OXEYE_DAISY)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> YELLOW_AFRICAN_DAISY = HELPER.createBlock("yellow_african_daisy", ()->new AbnormalsFlowerBlock(()->Effects.REGENERATION, 8, AbstractBlock.Properties.from(Blocks.OXEYE_DAISY)), ItemGroup.DECORATIONS);

    // sacc
    public static final RegistryObject<Block> SUNFLOWER_SEED_SACK = HELPER.createCompatBlock("quark", "sunflower_seed_sack", ()->new Block(Block.Properties.create(Material.WOOL, MaterialColor.GRAY).hardnessAndResistance(0.5F).sound(SoundType.CLOTH)), ItemGroup.DECORATIONS);
}

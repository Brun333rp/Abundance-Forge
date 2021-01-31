package com.teamaurora.abundance.core.registry;

import com.minecraftabnormals.abnormals_core.common.blocks.AbnormalsFlowerBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.AbnormalsTallFlowerBlock;
import com.minecraftabnormals.abnormals_core.core.util.registry.BlockSubRegistryHelper;
import com.teamaurora.abundance.common.block.LavenderBlock;
import com.teamaurora.abundance.common.block.MarigoldBlock;
import com.teamaurora.abundance.core.Abundance;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Abundance.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AbundanceBlocks {
    public static final BlockSubRegistryHelper HELPER = Abundance.REGISTRY_HELPER.getBlockSubHelper();

    // flowers
    public static final RegistryObject<Block> LAVENDER = HELPER.createBlock("lavender", ()->new LavenderBlock(()->Effects.SPEED, 10, AbstractBlock.Properties.from(Blocks.ALLIUM)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> TALL_LAVENDER = HELPER.createBlockNoItem("tall_lavender", ()->new AbnormalsTallFlowerBlock(AbstractBlock.Properties.from(Blocks.ALLIUM)));

    public static final RegistryObject<Block> SUNNY_MARIGOLD = HELPER.createBlock("sunny_marigold", ()->new MarigoldBlock(()->Effects.INSTANT_HEALTH, 1, AbstractBlock.Properties.from(Blocks.DANDELION)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> SHADY_MARIGOLD = HELPER.createBlock("shady_marigold", ()->new MarigoldBlock(()->Effects.INSTANT_HEALTH, 1, AbstractBlock.Properties.from(Blocks.DANDELION)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> TALL_MARIGOLD = HELPER.createBlock("tall_marigold", ()->new AbnormalsTallFlowerBlock(AbstractBlock.Properties.from(Blocks.DANDELION)), ItemGroup.DECORATIONS);
}

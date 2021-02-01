package com.teamaurora.abundance.core.registry;

import com.minecraftabnormals.abnormals_core.core.util.registry.BlockSubRegistryHelper;
import com.minecraftabnormals.abnormals_core.core.util.registry.ItemSubRegistryHelper;
import com.teamaurora.abundance.core.Abundance;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Abundance.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AbundanceItems {
    public static final ItemSubRegistryHelper HELPER = Abundance.REGISTRY_HELPER.getItemSubHelper();

    public static final RegistryObject<Item> LAVENDER = HELPER.createItem("lavender", ()->new BlockNamedItem(AbundanceBlocks.LAVENDER.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
}

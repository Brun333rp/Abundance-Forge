package com.teamaurora.abundance.core.registry;

import com.minecraftabnormals.abnormals_core.common.items.AbnormalsSpawnEggItem;
import com.minecraftabnormals.abnormals_core.core.util.registry.BlockSubRegistryHelper;
import com.minecraftabnormals.abnormals_core.core.util.registry.ItemSubRegistryHelper;
import com.teamaurora.abundance.common.item.LavenderTeaItem;
import com.teamaurora.abundance.core.Abundance;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Abundance.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AbundanceItems {
    public static final ItemSubRegistryHelper HELPER = Abundance.REGISTRY_HELPER.getItemSubHelper();

    public static final RegistryObject<Item> LAVENDER = HELPER.createItem("lavender", () -> new BlockNamedItem(AbundanceBlocks.LAVENDER.get(), new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> LAVENDER_SALAD = HELPER.createItem("lavender_salad", () -> new SoupItem(new Item.Properties().maxStackSize(1).food(Foods.LAVENDER_SALAD).group(ItemGroup.FOOD)));
    public static final RegistryObject<Item> LAVENDER_TEA = HELPER.createItem("lavender_tea", () -> new LavenderTeaItem(new Item.Properties().food(Foods.EMPTY).maxStackSize(16).group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> JACARANDA_BOAT = HELPER.createBoatItem("jacaranda", AbundanceBlocks.JACARANDA_PLANKS);
    public static final RegistryObject<Item> REDBUD_BOAT = HELPER.createBoatItem("redbud", AbundanceBlocks.REDBUD_PLANKS);

    public static final RegistryObject<Item> PINK_BLOSSOMS = HELPER.createItem("pink_blossoms", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> SUNFLOWER_SEEDS = HELPER.createItem("sunflower_seeds", () -> new Item(new Item.Properties().group(ItemGroup.MISC).food(Foods.SUNFLOWER_SEEDS)));

    public static final RegistryObject<Item> SCREECHER_TAIL = HELPER.createItem("screecher_tail", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));

    public static final RegistryObject<AbnormalsSpawnEggItem> SCREECHER_SPAWN_EGG = HELPER.createSpawnEggItem("screecher", AbundanceEntities.SCREECHER::get, 0x74A837, 0xB76CCB);

    public static class Foods {
        public static final Food EMPTY = (new Food.Builder()).hunger(0).saturation(0.0F).setAlwaysEdible().build();
        public static final Food LAVENDER_SALAD = (new Food.Builder()).hunger(6).saturation(0.5F).build();
        public static final Food SUNFLOWER_SEEDS = (new Food.Builder()).hunger(2).saturation(0.1F).build();
    }
}

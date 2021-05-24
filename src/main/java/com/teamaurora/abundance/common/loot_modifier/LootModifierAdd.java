package com.teamaurora.abundance.common.loot_modifier;

import com.google.gson.JsonObject;
import com.mojang.serialization.JsonOps;
import com.teamaurora.abundance.core.Abundance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.Level;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * Simple loot modifier for adding an item to a loot table
 */
public class LootModifierAdd extends LootModifier {

    protected final Item itemToAdd;
    protected final int maxStackCount;
    protected final int minStackCount;
    protected final ResourceLocation targetLootTable;

    public LootModifierAdd(ILootCondition[] conditions, ResourceLocation lootTable, Item itemToAdd, int maxStackCount, int minStackCount) {
        super(conditions);
        this.itemToAdd = itemToAdd;
        this.maxStackCount = maxStackCount;
        this.minStackCount = minStackCount;
        this.targetLootTable = lootTable;

        if (this.maxStackCount < 0 || this.minStackCount > this.maxStackCount) {
            throw new IllegalArgumentException("Max stack count cannot be less than 0 and min stack count cannot be greater than specified max.");
        }
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        if (context.getQueriedLootTableId().equals(this.targetLootTable)) {
            Random random = new Random();
            int count = this.maxStackCount == 1 ? 1 : random.nextInt((this.maxStackCount - this.minStackCount) + 1) + this.minStackCount;
            ItemStack stack = new ItemStack(this.itemToAdd, count);

            generatedLoot.add(stack);
        }
        return generatedLoot;
    }

    public static class LootModifierAddSerializer extends GlobalLootModifierSerializer<LootModifierAdd> {

        @Override
        public LootModifierAdd read(ResourceLocation location, JsonObject object, ILootCondition[] lootConditions) {
            Item itemToAdd = ForgeRegistries.ITEMS.getValue(new ResourceLocation(JSONUtils.getString(object, "item")));
            int maxStackCount = JSONUtils.getInt(object, "maxCount");
            int minStackCount = JSONUtils.getInt(object, "minCount");
            ResourceLocation lootTable = new ResourceLocation(JSONUtils.getString(object, "lootTable"));

            return new LootModifierAdd(lootConditions, lootTable, itemToAdd, maxStackCount, minStackCount);
        }

        @Override
        public JsonObject write(LootModifierAdd instance) {
            final JsonObject json = this.makeConditions(instance.conditions);
            json.addProperty("item", Objects.requireNonNull(instance.itemToAdd.getRegistryName()).toString());
            json.addProperty("maxCount", instance.maxStackCount);
            json.addProperty("minCount", instance.minStackCount);
            json.add("lootTable", ResourceLocation.CODEC.encodeStart(JsonOps.INSTANCE, instance.targetLootTable)
                    .getOrThrow(false, (s) -> Abundance.LOGGER.log(Level.ERROR, s)));

            return json;
        }
    }
}
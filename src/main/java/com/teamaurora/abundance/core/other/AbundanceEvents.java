package com.teamaurora.abundance.core.other;

import com.minecraftabnormals.abnormals_core.core.util.TradeUtil;
import com.teamaurora.abundance.core.Abundance;
import com.teamaurora.abundance.core.registry.AbundanceBlocks;
import com.teamaurora.abundance.core.registry.AbundanceEffects;
import com.teamaurora.abundance.core.registry.AbundanceItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Abundance.MODID)
public class AbundanceEvents {

    @SubscribeEvent
    public static void onWandererTradesEvent(WandererTradesEvent event) {
        TradeUtil.addWandererTrades(event,
                new TradeUtil.AbnormalsTrade(1, AbundanceBlocks.SUNNY_MARIGOLD.get().asItem(), 1, 12, 1),
                new TradeUtil.AbnormalsTrade(1, AbundanceBlocks.SHADY_MARIGOLD.get().asItem(), 1, 12, 1),
                new TradeUtil.AbnormalsTrade(1, AbundanceBlocks.TALL_MARIGOLD.get().asItem(), 1, 12, 1),
                new TradeUtil.AbnormalsTrade(1, AbundanceBlocks.NEMOPHILA.get().asItem(), 1, 12, 1),
                new TradeUtil.AbnormalsTrade(1, AbundanceBlocks.CHICORY.get().asItem(), 1, 12, 1),
                new TradeUtil.AbnormalsTrade(1, AbundanceBlocks.AMARANTHUS.get().asItem(), 1, 12, 1),
                new TradeUtil.AbnormalsTrade(1, AbundanceBlocks.YELLOW_AFRICAN_DAISY.get().asItem(), 1, 12, 1),
                new TradeUtil.AbnormalsTrade(1, AbundanceBlocks.PURPLE_AFRICAN_DAISY.get().asItem(), 1, 12, 1),

                new TradeUtil.AbnormalsTrade(5, AbundanceBlocks.JACARANDA_SAPLING.get().asItem(), 1, 8, 1),
                new TradeUtil.AbnormalsTrade(5, AbundanceBlocks.REDBUD_SAPLING.get().asItem(), 1, 8, 1),
                new TradeUtil.AbnormalsTrade(5, AbundanceBlocks.FLOWERING_REDBUD_SAPLING.get().asItem(), 1, 8, 1)
        );
    }

    @SubscribeEvent
    public static void onVillagerTradesEvent(VillagerTradesEvent event) {
        if (event.getType().equals(VillagerProfession.FARMER)) {
            TradeUtil.addVillagerTrades(event, TradeUtil.NOVICE,
                    new TradeUtil.AbnormalsTrade(AbundanceItems.LAVENDER.get(), 20, 1, 16, 2, 0.05F)
            );
        }
    }
}

package com.teamaurora.abundance.core;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class AbundanceConfig {
    public static class Common {
        public final ForgeConfigSpec.ConfigValue<Integer> lavenderFieldsWeight;
        public final ForgeConfigSpec.ConfigValue<Integer> nemophilaFieldsWeight;

        Common(ForgeConfigSpec.Builder builder) {
            builder.comment("Common configurations for Abundance")
                    .push("common");

            builder.comment("Values for biome frequencies; lower = more rare. (Requires restart)")
                    .push("biome_weights");

            lavenderFieldsWeight = builder.define("Lavender Fields weight", 3);
            nemophilaFieldsWeight = builder.define("Nemophila Fields weight", 3);

            builder.pop();
            builder.pop();
        }
    }

    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;
    static {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }
}

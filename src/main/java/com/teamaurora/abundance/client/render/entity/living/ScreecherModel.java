package com.teamaurora.abundance.client.render.entity.living;

import com.google.common.collect.ImmutableList;
import com.teamaurora.abundance.common.entity.living.ScreecherEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ScreecherModel<T extends ScreecherEntity> extends SegmentedModel<T> {

    public ScreecherModel() {

    }

    @Override
    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of();
    }

    @Override
    public void setRotationAngles(T screecher, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }
}

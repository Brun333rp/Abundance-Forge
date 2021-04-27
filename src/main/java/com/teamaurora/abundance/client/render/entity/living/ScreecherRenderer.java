package com.teamaurora.abundance.client.render.entity.living;

import com.teamaurora.abundance.common.entity.living.ScreecherEntity;
import com.teamaurora.abundance.core.Abundance;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ScreecherRenderer<T extends ScreecherEntity> extends MobRenderer<T, ScreecherModel<T>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Abundance.MODID, "textures/entity/living/screecher.png");

    public ScreecherRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ScreecherModel<>(), 1.0F);
    }

    @Override
    public ResourceLocation getEntityTexture(T entity) {
        return TEXTURE;
    }
}

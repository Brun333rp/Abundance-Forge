package com.teamaurora.abundance.client.render.entity.living;

import com.minecraftabnormals.abnormals_core.core.endimator.entity.EndimatorEntityModel;
import com.minecraftabnormals.abnormals_core.core.endimator.entity.EndimatorModelRenderer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.teamaurora.abundance.common.entity.living.ScreecherEntity;
import com.teamaurora.abundance.core.Abundance;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
//
// Model author: Audako

public class ScreecherModel<T extends ScreecherEntity> extends EndimatorEntityModel<T> {

    private final EndimatorModelRenderer bone3;
    private final EndimatorModelRenderer bone;
    private final EndimatorModelRenderer tail;
    private final EndimatorModelRenderer cube_r1;
    private final EndimatorModelRenderer cube_r2;
    private final EndimatorModelRenderer head;
    private final EndimatorModelRenderer bone2;
    private final EndimatorModelRenderer propeller;
    private final EndimatorModelRenderer cube_r3;
    private final EndimatorModelRenderer rightLeg;
    private final EndimatorModelRenderer leftLeg;
    private final EndimatorModelRenderer leftArm;
    private final EndimatorModelRenderer rightArm;

    public ScreecherModel() {
        textureWidth = 80;
        textureHeight = 80;

        bone3 = new EndimatorModelRenderer(this);
        bone3.setRotationPoint(0.0F, 24.0F, 0.0F);

        bone = new EndimatorModelRenderer(this);
        bone.setRotationPoint(-0.5F, -9.0F, -8.0F);
        bone3.addChild(bone);
        bone.setTextureOffset(0, 22).addBox(-6.5F, 0.0F, 0.0F, 13.0F, 6.0F, 14.0F, 0.0F, false);

        tail = new EndimatorModelRenderer(this);
        tail.setRotationPoint(0.0F, 0.0F, 14.0F);
        bone.addChild(tail);
        setRotationAngle(tail, 0.2618F, 0.0F, 0.0F);

        cube_r1 = new EndimatorModelRenderer(this);
        cube_r1.setRotationPoint(-13.5F, -1.0681F, -2.5176F);
        tail.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 1.5708F, 0.0F);
        cube_r1.setTextureOffset(0, 42).addBox(-15.0F, 0.0F, 12.0F, 13.0F, 2.0F, 3.0F, 0.0F, false);

        cube_r2 = new EndimatorModelRenderer(this);
        cube_r2.setRotationPoint(-13.5F, -1.0681F, -2.5176F);
        tail.addChild(cube_r2);
        setRotationAngle(cube_r2, 1.5708F, 1.5708F, 0.0F);
        cube_r2.setTextureOffset(24, 61).addBox(-20.0F, 13.5681F, -6.0F, 18.0F, 0.0F, 10.0F, 0.0F, false);

        head = new EndimatorModelRenderer(this);
        head.setRotationPoint(0.0F, 0.0F, 14.0F);
        bone.addChild(head);
        head.setTextureOffset(0, 0).addBox(-7.5F, -6.9769F, -14.8345F, 15.0F, 7.0F, 15.0F, 0.0F, false);

        bone2 = new EndimatorModelRenderer(this);
        bone2.setRotationPoint(0.0F, 0.0F, -1.0F);
        head.addChild(bone2);
        bone2.setTextureOffset(0, 66).addBox(-6.5F, 0.0231F, -13.8345F, 13.0F, 0.0F, 14.0F, 0.0F, false);

        propeller = new EndimatorModelRenderer(this);
        propeller.setRotationPoint(0.0F, -7.1F, -8.0F);
        head.addChild(propeller);

        cube_r3 = new EndimatorModelRenderer(this);
        cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
        propeller.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0F, -0.3054F, 0.0F);
        cube_r3.setTextureOffset(0, 49).addBox(-8.5F, 0.0231F, -7.8345F, 17.0F, 0.0F, 17.0F, 0.0F, false);

        rightLeg = new EndimatorModelRenderer(this);
        rightLeg.setRotationPoint(-5.5F, -6.0F, 5.0F);
        bone3.addChild(rightLeg);
        rightLeg.setTextureOffset(45, 5).addBox(-2.5F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

        leftLeg = new EndimatorModelRenderer(this);
        leftLeg.setRotationPoint(4.5F, -6.0F, 5.0F);
        bone3.addChild(leftLeg);
        leftLeg.setTextureOffset(45, 5).addBox(-1.5F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, true);

        leftArm = new EndimatorModelRenderer(this);
        leftArm.setRotationPoint(-5.5F, -8.0F, -7.0F);
        bone3.addChild(leftArm);
        leftArm.setTextureOffset(40, 24).addBox(8.5F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);

        rightArm = new EndimatorModelRenderer(this);
        rightArm.setRotationPoint(-5.5F, -8.0F, -7.0F);
        bone3.addChild(rightArm);
        rightArm.setTextureOffset(40, 24).addBox(-2.5F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, true);
        this.setDefaultBoxValues();
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        super.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.bone3.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public void setRotationAngles(T screecher, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        super.setRotationAngles(screecher, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

        this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.rightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.leftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    private void setRotationAngle(ModelRenderer modelRenderer, float xRot, float yRot, float zRot) {
        modelRenderer.rotateAngleX = xRot;
        modelRenderer.rotateAngleY = yRot;
        modelRenderer.rotateAngleZ = zRot;
    }

    @Override
    public void animateModel(T screecher) {
        super.animateModel(screecher);

        if(screecher.isEndimationPlaying(ScreecherEntity.WALKING_ANIMATION)) {

        }
        else if (screecher.isEndimationPlaying(ScreecherEntity.SCREECH_ANIMATION)) {
            this.setEndimationToPlay(ScreecherEntity.SCREECH_ANIMATION);

            this.startKeyframe(5);
            this.rotate(this.head, 0.0F, 0.45F, 0.0F);
            this.endKeyframe();

            this.startKeyframe(5);
            this.rotate(this.head, 0.0F, 0.45F, 0.0F);
            this.endKeyframe();

            this.resetKeyframe(5);
        }
    }
}

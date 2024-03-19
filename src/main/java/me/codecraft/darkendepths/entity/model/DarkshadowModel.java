package me.codecraft.darkendepths.entity.model;

import me.codecraft.darkendepths.entity.animations.DarkShadowAnimations;
import me.codecraft.darkendepths.entity.custom.DarkShadowEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class DarkshadowModel <T extends DarkShadowEntity> extends SinglePartEntityModel<T> {
	private final ModelPart DarkShadowModelPart;
	private final ModelPart Head;
	public DarkshadowModel(ModelPart root) {
		this.DarkShadowModelPart = root.getChild("DarkShadow");
		this.Head = DarkShadowModelPart.getChild("Head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData DarkShadow = modelPartData.addChild("DarkShadow", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData Head = DarkShadow.addChild("Head", ModelPartBuilder.create(), ModelTransform.pivot(-0.0104F, -24.0084F, 0.0F));

		ModelPartData cube_r1 = Head.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -8.0F, -7.75F, 16.0F, 16.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -0.25F, 0.0F, 0.0F, 0.0F));

		ModelPartData Tenticals = DarkShadow.addChild("Tenticals", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -24.0F, 0.0F));

		ModelPartData Tentical = Tenticals.addChild("Tentical", ModelPartBuilder.create(), ModelTransform.pivot(-0.0104F, -16.0084F, -0.5F));

		ModelPartData cube_r2 = Tentical.addChild("cube_r2", ModelPartBuilder.create().uv(0, 53).cuboid(4.0F, -24.0F, -1.75F, 4.0F, 16.0F, 3.0F, new Dilation(0.0F))
				.uv(14, 53).cuboid(-2.0F, -24.0F, -1.75F, 4.0F, 16.0F, 3.0F, new Dilation(0.0F))
				.uv(28, 53).cuboid(-8.0F, -24.0F, -1.75F, 4.0F, 16.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 16.0F, 0.25F, 0.0F, 0.0F, 0.0F));

		ModelPartData Tentical2 = Tenticals.addChild("Tentical2", ModelPartBuilder.create(), ModelTransform.pivot(14.4896F, -0.0084F, 0.0F));

		ModelPartData cube_r3 = Tentical2.addChild("cube_r3", ModelPartBuilder.create().uv(34, 39).cuboid(8.0F, 5.0F, -1.75F, 13.0F, 3.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 46).cuboid(8.0F, -1.5F, -1.75F, 13.0F, 3.0F, 4.0F, new Dilation(0.0F))
				.uv(34, 46).cuboid(8.0F, -8.0F, -1.75F, 13.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-14.5F, 0.0F, -0.25F, 0.0F, 0.0F, 0.0F));

		ModelPartData Tentical3 = Tenticals.addChild("Tentical3", ModelPartBuilder.create(), ModelTransform.pivot(-14.5104F, -0.0084F, 0.0F));

		ModelPartData cube_r4 = Tentical3.addChild("cube_r4", ModelPartBuilder.create().uv(34, 32).cuboid(-21.0F, 5.0F, -1.75F, 13.0F, 3.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 32).cuboid(-21.0F, -1.5F, -1.75F, 13.0F, 3.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 39).cuboid(-21.0F, -8.0F, -1.75F, 13.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(14.5F, 0.0F, -0.25F, 0.0F, 0.0F, 0.0F));

		ModelPartData Tentical4 = Tenticals.addChild("Tentical4", ModelPartBuilder.create(), ModelTransform.pivot(-0.0104F, 15.9916F, -0.5F));

		ModelPartData cube_r5 = Tentical4.addChild("cube_r5", ModelPartBuilder.create().uv(42, 53).cuboid(-2.0F, 8.0F, -1.75F, 4.0F, 16.0F, 3.0F, new Dilation(0.0F))
				.uv(56, 53).cuboid(-8.0F, 8.0F, -1.75F, 4.0F, 16.0F, 3.0F, new Dilation(0.0F))
				.uv(64, 0).cuboid(4.0F, 8.0F, -1.75F, 4.0F, 16.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -16.0F, 0.25F, 0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 80, 80);
	}
	@Override
	public void setAngles(DarkShadowEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(entity, ageInTicks, netHeadYaw, headPitch);

		this.updateAnimation(DarkShadowEntity.idleAnimation, DarkShadowAnimations.idle, ageInTicks,1f);
		this.updateAnimation(DarkShadowEntity.burstAnimation, DarkShadowAnimations.Burst, ageInTicks,1f);
		this.updateAnimation(DarkShadowEntity.shieldAnimation, DarkShadowAnimations.Shield, ageInTicks,1f);

	}

	private void setHeadAngles(DarkShadowEntity entity, float ageInTicks, float netHeadYaw, float headPitch) {
		netHeadYaw = MathHelper.clamp(netHeadYaw, -30f, 30f);
		headPitch = MathHelper.clamp(headPitch, -25.0f, 45.0f);


		this.Head.pitch = headPitch * 0.017453292F;
		this.Head.yaw = netHeadYaw * 0.017453292F;
	}	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		DarkShadowModelPart.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return this.DarkShadowModelPart;
	}


}
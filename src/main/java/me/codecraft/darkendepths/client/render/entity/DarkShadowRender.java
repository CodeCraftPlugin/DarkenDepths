package me.codecraft.darkendepths.client.render.entity;

import me.codecraft.darkendepths.DarkenDepths;
import me.codecraft.darkendepths.entity.custom.DarkShadowEntity;
import me.codecraft.darkendepths.entity.layers.DarkenDepthsModelLayers;
import me.codecraft.darkendepths.entity.model.DarkshadowModel;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class DarkShadowRender extends LivingEntityRenderer<DarkShadowEntity, DarkshadowModel<DarkShadowEntity>> {



    public DarkShadowRender(EntityRendererFactory.Context ctx) {
        super(ctx, new DarkshadowModel(ctx.getPart(DarkenDepthsModelLayers.DARKSHADOW)), 0.5f);
    }

    @Override
    public Identifier getTexture(DarkShadowEntity entity) {
        return new Identifier(DarkenDepths.MOD_ID, "textures/entity/darkshadow/darkshadow.png");
    }

    @Override
    public void render(DarkShadowEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}

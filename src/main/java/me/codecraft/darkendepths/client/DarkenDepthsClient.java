package me.codecraft.darkendepths.client;

import me.codecraft.darkendepths.client.render.entity.DarkShadowRender;
import me.codecraft.darkendepths.entity.DarkenDepthsEntities;
import me.codecraft.darkendepths.entity.layers.DarkenDepthsModelLayers;
import me.codecraft.darkendepths.entity.model.DarkshadowModel;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class DarkenDepthsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("Hello Fabric world! (Client)");

        EntityModelLayerRegistry.registerModelLayer(DarkenDepthsModelLayers.DARKSHADOW, DarkshadowModel::getTexturedModelData);
        EntityRendererRegistry.register(DarkenDepthsEntities.DARK_SHADOW,DarkShadowRender::new);
        
    }
}

package me.codecraft.darkendepths.entity.layers;

import me.codecraft.darkendepths.DarkenDepths;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class DarkenDepthsModelLayers {
    public static final EntityModelLayer DARKSHADOW =
            new EntityModelLayer(new Identifier(DarkenDepths.MOD_ID, "darkshadow"), "main");
}

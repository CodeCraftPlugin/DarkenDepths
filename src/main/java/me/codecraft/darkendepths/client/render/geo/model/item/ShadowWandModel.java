package me.codecraft.darkendepths.client.render.geo.model.item;

import me.codecraft.darkendepths.DarkenDepths;
import me.codecraft.darkendepths.item.DarkenDepthsItems;
import me.codecraft.darkendepths.item.custom.KnockBackItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class ShadowWandModel extends GeoModel<KnockBackItem> {
    @Override
    public Identifier getModelResource(KnockBackItem animatable) {
        return new Identifier(DarkenDepths.MOD_ID, "geo/item/shadow_wand.geo.json");
    }

    @Override
    public Identifier getTextureResource(KnockBackItem animatable) {
        return new Identifier(DarkenDepths.MOD_ID, "textures/item/shadow_wand.png");
    }

    @Override
    public Identifier getAnimationResource(KnockBackItem animatable) {
        return new Identifier(DarkenDepths.MOD_ID, "animations/item/shadow_wand.animation.json");
    }
}

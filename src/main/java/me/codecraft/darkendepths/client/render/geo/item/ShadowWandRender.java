package me.codecraft.darkendepths.client.render.geo.item;

import me.codecraft.darkendepths.client.render.geo.model.item.ShadowWandModel;
import me.codecraft.darkendepths.item.custom.KnockBackItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class ShadowWandRender extends GeoItemRenderer<KnockBackItem> {
    public ShadowWandRender() {
        super(new ShadowWandModel());
    }
}

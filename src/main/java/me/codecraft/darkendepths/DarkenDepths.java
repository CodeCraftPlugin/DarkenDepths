package me.codecraft.darkendepths;

import me.codecraft.darkendepths.item.GroupItems;
import me.codecraft.darkendepths.item.Items;
import net.fabricmc.api.ModInitializer;

public class DarkenDepths implements ModInitializer {

    public static final String MOD_ID = "darkendepths";
    @Override
    public void onInitialize() {
        Items.Itemsinit();
        GroupItems.GroupItemsinit();
    }
}

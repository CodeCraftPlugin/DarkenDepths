package me.codecraft.darkendepths;

import me.codecraft.darkendepths.blocks.DarkenDepthsBlocks;
import me.codecraft.darkendepths.item.DarkenDepthsGroupItems;
import me.codecraft.darkendepths.item.DarkenDepthsItems;
import me.codecraft.darkendepths.world.gen.DarkenDepthsWorldGeneration;
import net.fabricmc.api.ModInitializer;

public class DarkenDepths implements ModInitializer {

    public static final String MOD_ID = "darkendepths";
    @Override
    public void onInitialize() {
        DarkenDepthsItems.Itemsinit();
        DarkenDepthsBlocks.init();
        DarkenDepthsGroupItems.GroupItemsinit();
        DarkenDepthsWorldGeneration.generateWorldGen();

    }
}

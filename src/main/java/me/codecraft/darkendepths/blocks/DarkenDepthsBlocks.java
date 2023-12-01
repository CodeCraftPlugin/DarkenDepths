package me.codecraft.darkendepths.blocks;

import io.github.codecraftplugin.registrylib.utils.Registry;
import me.codecraft.darkendepths.DarkenDepths;
import me.codecraft.darkendepths.item.DarkenDepthsGroupItems;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;

public class DarkenDepthsBlocks {

    public static final Block DARKENED_STONE_ORE = Registry.registerBlocks("darkened_stone_ore", DarkenDepths.MOD_ID,
            new Block(FabricBlockSettings.create().solid().strength(1.5f, 6.0f).requiresTool()), DarkenDepthsGroupItems.DARKEN_DEPTHS_GROUP);
    public static final Block DEEPSLATE_DARKENED_STONE_ORE = Registry.registerBlocks("deepslate_darkened_stone_ore", DarkenDepths.MOD_ID,
            new Block(FabricBlockSettings.create().strength(2.5f, 8.0f).requiresTool().solid()),DarkenDepthsGroupItems.DARKEN_DEPTHS_GROUP);



    public static void init() {
    }
}

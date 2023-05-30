package me.codecraft.darkendepths.item;

import io.github.codecraftplugin.registrylib.utils.Registry;
import me.codecraft.darkendepths.DarkenDepths;
import me.codecraft.darkendepths.item.custom.ShadowStoneItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;

public class Items {
    public static final Item DARK_ESSENCE  = Registry.registerItems("dark_essence", DarkenDepths.MOD_ID,new Item(new FabricItemSettings()), GroupItems.DARKEN_DEPTHS_GROUP);
    public static final Item SHADOW_STONE  = Registry.registerItems("shadow_stone", DarkenDepths.MOD_ID,new ShadowStoneItem(new FabricItemSettings()),GroupItems.DARKEN_DEPTHS_GROUP);
    public static final Item DARK_SWORD  = Registry.registerItems("dark_sword", DarkenDepths.MOD_ID,new SwordItem(ToolMaterials.DARKNESS,10,5.0f,new FabricItemSettings()),GroupItems.DARKEN_DEPTHS_GROUP);
    public static final Item DARK_AXE  = Registry.registerItems("dark_axe", DarkenDepths.MOD_ID,new AxeItem(ToolMaterials.DARKNESS,10,5.0f,new FabricItemSettings()),GroupItems.DARKEN_DEPTHS_GROUP);
    public static final Item DARK_PICKAXE  = Registry.registerItems("dark_pickaxe", DarkenDepths.MOD_ID,new PickaxeItem(ToolMaterials.DARKNESS,10,5.0f,new FabricItemSettings()),GroupItems.DARKEN_DEPTHS_GROUP);
    public static final Item DARK_SHOVEL  = Registry.registerItems("dark_shovel", DarkenDepths.MOD_ID,new ShovelItem(ToolMaterials.DARKNESS,10,5.0f,new FabricItemSettings()),GroupItems.DARKEN_DEPTHS_GROUP);
    public static final Item DARK_HOE  = Registry.registerItems("dark_hoe", DarkenDepths.MOD_ID,new HoeItem(ToolMaterials.DARKNESS,10,5.0f,new FabricItemSettings()),GroupItems.DARKEN_DEPTHS_GROUP);

    public static void Itemsinit() {
        // This is a static class, so we need to call the init() method ourselves
    }
}

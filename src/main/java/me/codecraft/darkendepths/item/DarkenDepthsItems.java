package me.codecraft.darkendepths.item;

import io.github.codecraftplugin.registrylib.utils.Registry;
import me.codecraft.darkendepths.DarkenDepths;
import me.codecraft.darkendepths.item.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;

public class DarkenDepthsItems {
    public static final Item DARK_ESSENCE  = Registry.registerItems("dark_essence", DarkenDepths.MOD_ID,new Item(new FabricItemSettings()), DarkenDepthsGroupItems.DARKEN_DEPTHS_GROUP);
    public static final Item DARKSHADOW_CORE  = Registry.registerItems("darkshadow_core", DarkenDepths.MOD_ID,new Item(new FabricItemSettings()), DarkenDepthsGroupItems.DARKEN_DEPTHS_GROUP);
    public static final Item SHADOWS_WAND  = Registry.registerItems("shadow_wand", DarkenDepths.MOD_ID,new KnockBackItem(new FabricItemSettings()), DarkenDepthsGroupItems.DARKEN_DEPTHS_GROUP);
    public static final Item SHADOW_STONE  = Registry.registerItems("shadow_stone", DarkenDepths.MOD_ID,new ShadowStoneItem(new FabricItemSettings()), DarkenDepthsGroupItems.DARKEN_DEPTHS_GROUP);
    public static final Item DARK_SWORD  = Registry.registerItems("dark_sword", DarkenDepths.MOD_ID,new SwordItem(DarkenDepthsToolMaterials.DARKNESS,10,5.0f,new FabricItemSettings()), DarkenDepthsGroupItems.DARKEN_DEPTHS_GROUP);
    public static final Item DARK_AXE  = Registry.registerItems("dark_axe", DarkenDepths.MOD_ID,new AxeItem(DarkenDepthsToolMaterials.DARKNESS,10,5.0f,new FabricItemSettings()), DarkenDepthsGroupItems.DARKEN_DEPTHS_GROUP);
    public static final Item DARK_PICKAXE  = Registry.registerItems("dark_pickaxe", DarkenDepths.MOD_ID,new PickaxeItem(DarkenDepthsToolMaterials.DARKNESS,10,5.0f,new FabricItemSettings()), DarkenDepthsGroupItems.DARKEN_DEPTHS_GROUP);
    public static final Item DARK_SHOVEL  = Registry.registerItems("dark_shovel", DarkenDepths.MOD_ID,new ShovelItem(DarkenDepthsToolMaterials.DARKNESS,10,5.0f,new FabricItemSettings()), DarkenDepthsGroupItems.DARKEN_DEPTHS_GROUP);
    public static final Item DARK_HOE  = Registry.registerItems("dark_hoe", DarkenDepths.MOD_ID,new HoeItem(DarkenDepthsToolMaterials.DARKNESS,10,5.0f,new FabricItemSettings()), DarkenDepthsGroupItems.DARKEN_DEPTHS_GROUP);
    public static final Item DARK_HELMET  = Registry.registerItems("dark_helmet", DarkenDepths.MOD_ID,new ArmorItem(DarkenDepthsArmorMaterials.DARKNESS, ArmorItem.Type.HELMET,new FabricItemSettings()), DarkenDepthsGroupItems.DARKEN_DEPTHS_GROUP);
    public static final Item DARK_CHESTPLATE  = Registry.registerItems("dark_chestplate", DarkenDepths.MOD_ID,new ArmorItem(DarkenDepthsArmorMaterials.DARKNESS, ArmorItem.Type.CHESTPLATE,new FabricItemSettings()), DarkenDepthsGroupItems.DARKEN_DEPTHS_GROUP);
    public static final Item DARK_LEGGINGS  = Registry.registerItems("dark_leggings", DarkenDepths.MOD_ID,new ArmorItem(DarkenDepthsArmorMaterials.DARKNESS, ArmorItem.Type.LEGGINGS,new FabricItemSettings()), DarkenDepthsGroupItems.DARKEN_DEPTHS_GROUP);
    public static final Item DARK_BOOTS  = Registry.registerItems("dark_boots", DarkenDepths.MOD_ID,new ArmorItem(DarkenDepthsArmorMaterials.DARKNESS, ArmorItem.Type.BOOTS,new FabricItemSettings()), DarkenDepthsGroupItems.DARKEN_DEPTHS_GROUP);

    public static void Itemsinit() {
        // This is a static class, so we need to call the init() method ourselves
    }
}

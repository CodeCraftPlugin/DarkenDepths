package me.codecraft.darkendepths.datagen;

import me.codecraft.darkendepths.DarkenDepths;
import me.codecraft.darkendepths.item.DarkenDepthsItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class DarkenDepthsLangGenrator extends FabricLanguageProvider {
    public DarkenDepthsLangGenrator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(DarkenDepthsItems.SHADOW_STONE, "Shadow Stone");
        translationBuilder.add(DarkenDepthsItems.DARK_ESSENCE, "Dark Essence");
        translationBuilder.add(DarkenDepthsItems.DARK_SWORD, "Darkened Sword");
        translationBuilder.add(DarkenDepthsItems.DARK_AXE, "Darkened Axe");
        translationBuilder.add(DarkenDepthsItems.DARK_SHOVEL, "Darkened Shovel");
        translationBuilder.add(DarkenDepthsItems.DARK_PICKAXE, "Darkened Pickaxe");
        translationBuilder.add(DarkenDepthsItems.DARK_HOE, "Darkened Hoe");
        translationBuilder.add(DarkenDepthsItems.DARK_HELMET, "Darkened Helmet");
        translationBuilder.add(DarkenDepthsItems.DARK_CHESTPLATE, "Darkened Chestplate");
        translationBuilder.add(DarkenDepthsItems.DARK_LEGGINGS, "Darkened Leggings");
        translationBuilder.add(DarkenDepthsItems.DARK_BOOTS, "Darkened Boots");
        translationBuilder.add(DarkenDepths.MOD_ID+".advancement.get_darkness_armor", "Get Full Darkened Armor");
    }
}


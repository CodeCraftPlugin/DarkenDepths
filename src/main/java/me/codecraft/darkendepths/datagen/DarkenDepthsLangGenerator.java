package me.codecraft.darkendepths.datagen;

import me.codecraft.darkendepths.DarkenDepths;
import me.codecraft.darkendepths.blocks.DarkenDepthsBlocks;
import me.codecraft.darkendepths.item.DarkenDepthsItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class DarkenDepthsLangGenerator extends FabricLanguageProvider {
    public DarkenDepthsLangGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(DarkenDepthsItems.SHADOW_STONE, "Shadow Stone");
        translationBuilder.add(DarkenDepthsBlocks.DARKENED_STONE_ORE, "§5Darkened Stone Ore");
        translationBuilder.add(DarkenDepthsBlocks.DEEPSLATE_DARKENED_STONE_ORE, "§5Deepslate Darkened Stone Ore");
        translationBuilder.add(DarkenDepthsItems.DARK_ESSENCE, "§5§lDark Essence");
        translationBuilder.add(DarkenDepthsItems.DARK_SWORD, "§5§lDarkened Sword");
        translationBuilder.add(DarkenDepthsItems.DARK_AXE, "§5§lDarkened Axe");
        translationBuilder.add(DarkenDepthsItems.DARK_SHOVEL, "§5§lDarkened Shovel");
        translationBuilder.add(DarkenDepthsItems.DARK_PICKAXE, "§5§lDarkened Pickaxe");
        translationBuilder.add(DarkenDepthsItems.DARK_HOE, "§5§lDarkened Hoe");
        translationBuilder.add(DarkenDepthsItems.DARK_HELMET, "§5§lDarkened Helmet");
        translationBuilder.add(DarkenDepthsItems.DARK_CHESTPLATE, "§5§lDarkened Chestplate");
        translationBuilder.add(DarkenDepthsItems.DARK_LEGGINGS, "§5§lDarkened Leggings");
        translationBuilder.add(DarkenDepthsItems.DARK_BOOTS, "§5§lDarkened Boots");
        translationBuilder.add(DarkenDepths.MOD_ID+".advancement.get_darkness_armor", "Get Full Darkened Armor");
    }
}


package me.codecraft.darkendepths.datagen;

import me.codecraft.darkendepths.item.Items;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class DarkenDepthsLangGenrator extends FabricLanguageProvider {
    public DarkenDepthsLangGenrator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(Items.SHADOW_STONE, "Shadow Stone");
        translationBuilder.add(Items.DARK_ESSENCE, "Dark Essence");
        translationBuilder.add(Items.DARK_SWORD, "Dark Sword");
        translationBuilder.add(Items.DARK_AXE, "Dark Axe");
        translationBuilder.add(Items.DARK_SHOVEL, "Dark Shovel");
        translationBuilder.add(Items.DARK_PICKAXE, "Dark Pickaxe");
        translationBuilder.add(Items.DARK_HOE, "Dark Hoe");
        translationBuilder.add(Items.DARK_HELMET, "Dark Helmet");
        translationBuilder.add(Items.DARK_CHESTPLATE, "Dark Chestplate");
        translationBuilder.add(Items.DARK_LEGGINGS, "Dark Leggings");
        translationBuilder.add(Items.DARK_BOOTS, "Dark Boots");
    }
}


package me.codecraft.darkendepths;

import me.codecraft.darkendepths.datagen.DarkenDepthsAdvancementGenerator;
import me.codecraft.darkendepths.datagen.DarkenDepthsLangGenrator;
import me.codecraft.darkendepths.datagen.DarkenDepthsModelsDatagen;
import me.codecraft.darkendepths.datagen.DarkenDepthsRecipesGenrator;
import me.codecraft.darkendepths.datagen.loottables.DarkenDepthsBlockLootTablesGenerator;
import me.codecraft.darkendepths.datagen.tags.DarkenDepthsBlockMiningLevelGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DarkenDepthsDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(DarkenDepthsModelsDatagen::new);
        pack.addProvider(DarkenDepthsLangGenrator::new);
        pack.addProvider(DarkenDepthsRecipesGenrator::new);
        pack.addProvider(DarkenDepthsAdvancementGenerator::new);
        pack.addProvider(DarkenDepthsBlockLootTablesGenerator::new);
        pack.addProvider(DarkenDepthsBlockMiningLevelGenerator::new);
    }
}

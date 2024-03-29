package me.codecraft.darkendepths;

import me.codecraft.darkendepths.datagen.*;
import me.codecraft.darkendepths.datagen.loottables.DarkenDepthsBlockLootTablesGenerator;
import me.codecraft.darkendepths.datagen.tags.DarkenDepthsBlockTag;
import me.codecraft.darkendepths.datagen.tags.DarkenDepthsItemTag;
import me.codecraft.darkendepths.world.DarkenDepthsConfiguredFeatures;
import me.codecraft.darkendepths.world.DarkenDepthsPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.feature.OrePlacedFeatures;
import org.jetbrains.annotations.Nullable;

public class DarkenDepthsDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(DarkenDepthsModelsGenerator::new);
        pack.addProvider(DarkenDepthsLangGenerator::new);
        pack.addProvider(DarkenDepthsRecipesGenerator::new);
        pack.addProvider(DarkenDepthsAdvancementGenerator::new);
        pack.addProvider(DarkenDepthsBlockLootTablesGenerator::new);
        pack.addProvider(DarkenDepthsBlockTag::new);
        pack.addProvider(DarkenDepthsItemTag::new);
        pack.addProvider(DarkenDepthsWorldGenerator::new);
//        pack.addProvider(DarkenDepthsBiomesGenerator::new);
    }
    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, DarkenDepthsConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, DarkenDepthsPlacedFeatures::bootstrap);
//        OrePlacedFeatures.
    }

    @Override
    public @Nullable String getEffectiveModId() {
        return DarkenDepths.MOD_ID;
    }
}

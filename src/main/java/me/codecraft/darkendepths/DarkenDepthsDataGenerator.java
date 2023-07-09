package me.codecraft.darkendepths;

import me.codecraft.darkendepths.datagen.*;
import me.codecraft.darkendepths.datagen.loottables.DarkenDepthsBlockLootTablesGenerator;
import me.codecraft.darkendepths.datagen.tags.DarkenDepthsBlockMiningLevelGenerator;
import me.codecraft.darkendepths.world.DarkenDepthsBiomesBootStrap;
import me.codecraft.darkendepths.world.DarkenDepthsConfiguredFeatures;
import me.codecraft.darkendepths.world.DarkenDepthsPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
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
        pack.addProvider(DarkenDepthsBlockMiningLevelGenerator::new);
        pack.addProvider(DarkenDepthsWorldGenerator::new);
        pack.addProvider(DarkenDepthsBiomesGenerator::new);
    }
    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, DarkenDepthsConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, DarkenDepthsPlacedFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.BIOME, DarkenDepthsBiomesBootStrap::bootstrap);
    }

    @Override
    public @Nullable String getEffectiveModId() {
        return DarkenDepths.MOD_ID;
    }
}

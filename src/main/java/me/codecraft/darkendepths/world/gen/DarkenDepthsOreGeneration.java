package me.codecraft.darkendepths.world.gen;

import me.codecraft.darkendepths.world.DarkenDepthsPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class DarkenDepthsOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, DarkenDepthsPlacedFeatures.DARKENED_STONE_ORE_PLACED_KEY);


    }

}

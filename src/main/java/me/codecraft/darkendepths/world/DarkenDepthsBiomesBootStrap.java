package me.codecraft.darkendepths.world;

import me.codecraft.darkendepths.DarkenDepths;
import me.codecraft.darkendepths.world.biome.custom.DarkenDepthsBiomes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.*;

public class DarkenDepthsBiomesBootStrap {



    public static void bootstrap(Registerable<Biome> context) {
        RegistryEntryLookup<PlacedFeature> placedFeatureLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        RegistryEntryLookup<ConfiguredCarver<?>> configuredCarverLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);
        register(context,DarkenDepthsBiomes.DARKENED_DEPTHS_KEY, DarkenDepthsBiomes.createDarkenDepths(placedFeatureLookup,configuredCarverLookup));

    }

    public static RegistryKey<Biome> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.BIOME, new Identifier(DarkenDepths.MOD_ID, name));
    }

    private static void register(Registerable<Biome> context, RegistryKey<Biome> key, Biome biome) {
        context.register(key, biome);
    }


}
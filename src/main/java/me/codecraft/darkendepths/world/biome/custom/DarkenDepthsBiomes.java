package me.codecraft.darkendepths.world.biome.custom;

import me.codecraft.darkendepths.world.DarkenDepthsPlacedFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.OrePlacedFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.UndergroundPlacedFeatures;

import static me.codecraft.darkendepths.world.DarkenDepthsBiomesBootStrap.registerKey;

public class DarkenDepthsBiomes {
    public static final RegistryKey<Biome> DARKENED_DEPTHS = registerKey("darkened_depths");

    public static Biome createDarkenDepths(RegistryEntryLookup<PlacedFeature> placedFeatureLookup, RegistryEntryLookup<ConfiguredCarver<?>> configuredCarverLookup) {
        return new Biome.Builder()
                // if it rains, snows or nothing falls, like in a desert
                .precipitation(true)
                // temperature, between 0f and 1f. Lower is hotter (?), don't have 0.15f or lower if precipitation is not NONE
                .temperature(0.5f)
                // frozen is only other option, maybe use that for cold biomes
                .temperatureModifier(Biome.TemperatureModifier.NONE)
                // downfall, affects grass and foliage color. Between 0f and 1f, > 0.85f makes fire go out quicker, for wet biomes
                .downfall(0.8f).effects(new BiomeEffects.Builder().
                        // color of fog over land in the distance
                                fogColor(0x1D8CB3).skyColor(0x23BAEE).waterColor(0x5D8ADC).
                        // color of fog in water in the distance
                                waterFogColor(0x9A9AD2).
                        // optional
                                grassColor(0x508E4A).
                        // optional
                                foliageColor(0x9FD29A).
                        // optional, this is the default
                                grassColorModifier(BiomeEffects.GrassColorModifier.NONE).
                        // biome particles (optional) also go here
                        //particleConfig(...).
                        // sound stuff is also optional, but goes here too
                        //moodSound(...)
                                build()).generationSettings(new GenerationSettings.LookupBackedBuilder(placedFeatureLookup, configuredCarverLookup).
                        // same carvers as in plains biome
                                carver(GenerationStep.Carver.AIR, ConfiguredCarvers.CAVE).carver(GenerationStep.Carver.AIR, ConfiguredCarvers.CAVE_EXTRA_UNDERGROUND).carver(GenerationStep.Carver.AIR, ConfiguredCarvers.CANYON).
                        // Since we don't change existing biomes, we can simply register our own features here.
                        // for floating islands
                        //feature(GenerationStep.Feature.RAW_GENERATION, ...).
                        // for stuff like lava lakes
                        // feature(GenerationStep.Feature.LAKES, ExampleMod.MY_LAKE_PF).
                        // for stuff like geodes and icebergs
                        feature(GenerationStep.Feature.LOCAL_MODIFICATIONS, UndergroundPlacedFeatures.AMETHYST_GEODE).
                        // for stuff like dungeons or underground fossils
                        feature(GenerationStep.Feature.UNDERGROUND_STRUCTURES, UndergroundPlacedFeatures.MONSTER_ROOM).
                        feature(GenerationStep.Feature.UNDERGROUND_STRUCTURES, UndergroundPlacedFeatures.MONSTER_ROOM_DEEP).
                        // for surface structures like desert wells (NOT trees!)
                        // feature(GenerationStep.Feature.SURFACE_STRUCTURES, MiscPlacedFeatures.DESERT_WELL).
                        // for ore blobs, including gravel/dirt/tuff blobs, and disks of clay etc
                        feature(GenerationStep.Feature.UNDERGROUND_ORES, OrePlacedFeatures.ORE_DIRT).
                        feature(GenerationStep.Feature.UNDERGROUND_ORES, OrePlacedFeatures.ORE_GRAVEL).
                        feature(GenerationStep.Feature.UNDERGROUND_ORES, OrePlacedFeatures.ORE_GRANITE_UPPER).
                        feature(GenerationStep.Feature.UNDERGROUND_ORES, OrePlacedFeatures.ORE_GRANITE_LOWER).
                        feature(GenerationStep.Feature.UNDERGROUND_ORES, OrePlacedFeatures.ORE_DIORITE_UPPER).
                        feature(GenerationStep.Feature.UNDERGROUND_ORES, OrePlacedFeatures.ORE_DIORITE_LOWER).
                        feature(GenerationStep.Feature.UNDERGROUND_ORES, OrePlacedFeatures.ORE_ANDESITE_LOWER).
                        feature(GenerationStep.Feature.UNDERGROUND_ORES, OrePlacedFeatures.ORE_ANDESITE_UPPER).
//                        feature(GenerationStep.Feature.UNDERGROUND_ORES, ).
                        // this one is used for nether ore blobs for whatever reason
                        feature(GenerationStep.Feature.UNDERGROUND_DECORATION, DarkenDepthsPlacedFeatures.DARKENED_STONE_ORE_PLACED_KEY).
                        // for surface lakes I think
                        //feature(GenerationStep.Feature.FLUID_SPRINGS, ...).
                        // trees as well as the small stuff like flowers, vines etc
                        // feature(GenerationStep.Feature.VEGETAL_DECORATION, TreePlacedFeatures.JUNGLE_BUSH)
                        // feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_BERRY_COMMON).
                        // be careful to NOT add features here AND so in biome modifications that it applies to this biome
                        // that can lead to confusing feature cycle order exceptions
                        build()).spawnSettings(new SpawnSettings.Builder().
                        // AMBIENT is for bats, rarely spawn one to two
                        spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.BAT, 1, 1, 2)).
                        // no axolotls in our biome
                        //spawn(SpawnGroup.AXOLOTL, ...).
                        // CREATURE is for peaceful land mobs / animals; polar bears and striders are included here
                        //                       spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.PIG, 10, 3, 5)).
                        //                        spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.SHEEP, 10, 3, 5)).
                        //                        spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.FOX, 10, 1, 2)).
                        // no idea what this is for
                        //spawn(SpawnGroup.MISC, ...).
                        // MONSTER for neutral and hostile monsters
                        spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIE, 10, 4, 4)).
                        // UNDERGROUND_WATER_CREATURE is for glow squids
                        //spawn(SpawnGroup.UNDERGROUND_WATER_CREATURE, ...).
                        // WATER_AMBIENT is for fish
                        spawn(SpawnGroup.WATER_AMBIENT, new SpawnSettings.SpawnEntry(EntityType.SALMON, 5, 5, 5)).
                        // WATER_CREATURE is for squids and dolphins
                        //spawn(SpawnGroup.WATER_CREATURE, new SpawnSettings.SpawnEntry(EntityType.SQUID), 10, 5, 5).
                        build()).build();
    }
}

package me.codecraft.darkendepths.world;

import me.codecraft.darkendepths.DarkenDepths;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class DarkenDepthsPlacedFeatures {

    public static final RegistryKey<PlacedFeature> DARKENED_STONE_ORE_PLACED_KEY = registerKey("darkened_stone_ore_placed");
    public static final RegistryKey<PlacedFeature> SMALL_DARKENED_STONE_ORE_PLACED_KEY = registerKey("small_darkened_stone_ore_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, DARKENED_STONE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(DarkenDepthsConfiguredFeatures.DARKENED_STONE_ORE_KEY),
                DarkenDepthsOrePlacement.modifiersWithCount(20, // Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));

        register(context, SMALL_DARKENED_STONE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(DarkenDepthsConfiguredFeatures.DARKENED_STONE_ORE_KEY),
                DarkenDepthsOrePlacement.modifiersWithCount(12, // Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));
    }



    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(DarkenDepths.MOD_ID, name));
    }
    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }

}

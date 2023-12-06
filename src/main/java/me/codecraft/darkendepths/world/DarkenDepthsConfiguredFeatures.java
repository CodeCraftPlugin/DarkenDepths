package me.codecraft.darkendepths.world;

import me.codecraft.darkendepths.DarkenDepths;
import me.codecraft.darkendepths.blocks.DarkenDepthsBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class DarkenDepthsConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> DARKENED_STONE_ORE_KEY = registerKey("darkened_stone_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DARKEN_DEPTHS_VEIN = registerKey("darken_depths_vein");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);


        List<OreFeatureConfig.Target> overworldDarkenedStoneOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, DarkenDepthsBlocks.DARKENED_STONE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, DarkenDepthsBlocks.DEEPSLATE_DARKENED_STONE_ORE.getDefaultState()));


        register(context, DARKENED_STONE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldDarkenedStoneOres, 16));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(DarkenDepths.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                    RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

package me.codecraft.darkendepths.datagen;

import me.codecraft.darkendepths.blocks.DarkenDepthsBlocks;
import me.codecraft.darkendepths.item.DarkenDepthsItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class DarkenDepthsModelsGenerator extends FabricModelProvider {
    public DarkenDepthsModelsGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(DarkenDepthsBlocks.DARKENED_STONE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(DarkenDepthsBlocks.DEEPSLATE_DARKENED_STONE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(DarkenDepthsItems.SHADOW_STONE, Models.GENERATED);
        itemModelGenerator.register(DarkenDepthsItems.DARK_ESSENCE, Models.GENERATED);
        itemModelGenerator.register(DarkenDepthsItems.DARK_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(DarkenDepthsItems.DARK_SWORD, Models.HANDHELD);
        itemModelGenerator.register(DarkenDepthsItems.DARK_AXE, Models.HANDHELD);
        itemModelGenerator.register(DarkenDepthsItems.DARK_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(DarkenDepthsItems.DARK_HOE, Models.HANDHELD);
        itemModelGenerator.register(DarkenDepthsItems.DARK_HELMET, Models.GENERATED);
        itemModelGenerator.register(DarkenDepthsItems.DARK_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(DarkenDepthsItems.DARK_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(DarkenDepthsItems.DARK_BOOTS, Models.GENERATED);
    }
}

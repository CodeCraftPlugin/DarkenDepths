package me.codecraft.darkendepths.datagen;

import me.codecraft.darkendepths.item.Items;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class DarkenDepthsModelsDatagen extends FabricModelProvider {
    public DarkenDepthsModelsDatagen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(Items.SHADOW_STONE, Models.GENERATED);
        itemModelGenerator.register(Items.DARK_ESSENCE, Models.GENERATED);
        itemModelGenerator.register(Items.DARK_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(Items.DARK_SWORD, Models.HANDHELD);
        itemModelGenerator.register(Items.DARK_AXE, Models.HANDHELD);
        itemModelGenerator.register(Items.DARK_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(Items.DARK_HOE, Models.HANDHELD);
        itemModelGenerator.register(Items.DARK_HELMET, Models.GENERATED);
        itemModelGenerator.register(Items.DARK_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(Items.DARK_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(Items.DARK_BOOTS, Models.GENERATED);
    }
}

package me.codecraft.darkendepths.datagen.loottables;

import me.codecraft.darkendepths.blocks.DarkenDepthsBlocks;
import me.codecraft.darkendepths.item.DarkenDepthsItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class DarkenDepthsBlockLootTablesGenerator extends FabricBlockLootTableProvider{
    public DarkenDepthsBlockLootTablesGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(DarkenDepthsBlocks.DARKENED_STONE_ORE,oreDrops(DarkenDepthsBlocks.DARKENED_STONE_ORE,DarkenDepthsItems.DARK_ESSENCE));
        addDrop(DarkenDepthsBlocks.DEEPSLATE_DARKENED_STONE_ORE,oreDrops(DarkenDepthsBlocks.DEEPSLATE_DARKENED_STONE_ORE,DarkenDepthsItems.DARK_ESSENCE));


    }

}

package me.codecraft.darkendepths.datagen.tags;

import me.codecraft.darkendepths.blocks.DarkenDepthsBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class DarkenDepthsBlockTag extends FabricTagProvider.BlockTagProvider {

    private static final TagKey<Block> MINEABLE_PICKAXE = TagKey.of(RegistryKey.ofRegistry(new Identifier("minecraft:mineable/pickaxe")), new Identifier("minecraft:mineable/pickaxe"));
    private static final TagKey<Block>  NEED_TOOL_LEVEL_3= TagKey.of(RegistryKey.ofRegistry(new Identifier("fabric:needs_tool_level_3")), new Identifier("fabric:needs_tool_level_3"));

    public DarkenDepthsBlockTag(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(MINEABLE_PICKAXE).add(DarkenDepthsBlocks.DARKENED_STONE_ORE);
        getOrCreateTagBuilder(MINEABLE_PICKAXE).add(DarkenDepthsBlocks.DEEPSLATE_DARKENED_STONE_ORE);
        getOrCreateTagBuilder(NEED_TOOL_LEVEL_3).add(DarkenDepthsBlocks.DARKENED_STONE_ORE);
        getOrCreateTagBuilder(NEED_TOOL_LEVEL_3).add(DarkenDepthsBlocks.DEEPSLATE_DARKENED_STONE_ORE);
    }
}

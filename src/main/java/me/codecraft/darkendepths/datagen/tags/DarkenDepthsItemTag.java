package me.codecraft.darkendepths.datagen.tags;

import me.codecraft.darkendepths.DarkenDepths;
import me.codecraft.darkendepths.inventory.ShadowStoneInventory;
import me.codecraft.darkendepths.item.DarkenDepthsItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class DarkenDepthsItemTag extends FabricTagProvider.ItemTagProvider  {

    public static final TagKey<Item> SHADOW_PROTECTION = TagKey.of(RegistryKey.ofRegistry(new Identifier(DarkenDepths.MOD_ID,"shadows_protection")), new Identifier(DarkenDepths.MOD_ID,"shadows_protection"));
    public DarkenDepthsItemTag(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(SHADOW_PROTECTION).add(DarkenDepthsItems.DARK_PICKAXE,DarkenDepthsItems.DARK_AXE,DarkenDepthsItems.DARK_SWORD,DarkenDepthsItems.DARKSHADOW_CORE);

    }
}

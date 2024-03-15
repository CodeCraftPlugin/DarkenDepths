package me.codecraft.darkendepths.datagen;

import io.github.codecraftplugin.registrylib.utils.RegistryRecipeProvider;
import me.codecraft.darkendepths.DarkenDepths;
import me.codecraft.darkendepths.item.DarkenDepthsItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.function.Consumer;

public class DarkenDepthsRecipesGenerator extends FabricRecipeProvider {



    public DarkenDepthsRecipesGenerator(FabricDataOutput output) {
        super(output);
    }



    @Override
    public void generate(RecipeExporter exporter) {
        RegistryRecipeProvider.offerAxeRecipe(exporter, DarkenDepthsItems.DARK_AXE, DarkenDepthsItems.DARK_ESSENCE);
        RegistryRecipeProvider.offerHoeRecipe(exporter, DarkenDepthsItems.DARK_HOE, DarkenDepthsItems.DARK_ESSENCE);
        RegistryRecipeProvider.offerPickaxeRecipe(exporter, DarkenDepthsItems.DARK_PICKAXE, DarkenDepthsItems.DARK_ESSENCE);
        RegistryRecipeProvider.offerShovelRecipe(exporter, DarkenDepthsItems.DARK_SHOVEL, DarkenDepthsItems.DARK_ESSENCE);
        RegistryRecipeProvider.offerSwordRecipe(exporter, DarkenDepthsItems.DARK_SWORD, DarkenDepthsItems.DARK_ESSENCE);
        RegistryRecipeProvider.offerHelmetRecipe(exporter, DarkenDepthsItems.DARK_HELMET, DarkenDepthsItems.DARK_ESSENCE);
        RegistryRecipeProvider.offerChestplateRecipe(exporter, DarkenDepthsItems.DARK_CHESTPLATE, DarkenDepthsItems.DARK_ESSENCE);
        RegistryRecipeProvider.offerLeggingsRecipe(exporter, DarkenDepthsItems.DARK_LEGGINGS, DarkenDepthsItems.DARK_ESSENCE);
        RegistryRecipeProvider.offerBootsRecipe(exporter, DarkenDepthsItems.DARK_BOOTS, DarkenDepthsItems.DARK_ESSENCE);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, DarkenDepthsItems.SHADOWS_WAND)
                .input(Character.valueOf('C'), DarkenDepthsItems.DARKSHADOW_CORE)
                .input('S', Items.STICK).input('E',DarkenDepthsItems.DARK_ESSENCE)
                .pattern("EEC")
                .pattern("ESE")
                .pattern("SEE")
                .group("wand")
                .criterion(FabricRecipeProvider.hasItem(DarkenDepthsItems.DARKSHADOW_CORE),
                        FabricRecipeProvider.conditionsFromItem(DarkenDepthsItems.DARKSHADOW_CORE))
                .criterion(FabricRecipeProvider.hasItem(DarkenDepthsItems.DARK_ESSENCE),
                        FabricRecipeProvider.conditionsFromItem(DarkenDepthsItems.DARK_ESSENCE))
                .offerTo(exporter);
    }
}

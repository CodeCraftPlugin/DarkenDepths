package me.codecraft.darkendepths.datagen;

import io.github.codecraftplugin.registrylib.utils.RegistryRecipeProvider;
import me.codecraft.darkendepths.item.DarkenDepthsItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeJsonProvider;

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
    }
}

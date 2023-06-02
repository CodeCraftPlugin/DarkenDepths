package me.codecraft.darkendepths.datagen;

import com.google.common.collect.Lists;
import io.github.codecraftplugin.registrylib.utils.RegistryRecipeProvider;
import me.codecraft.darkendepths.item.Items;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.Util;

import java.util.List;
import java.util.function.Consumer;

public class DarkenDepthsRecipesGenrator extends FabricRecipeProvider {



    public DarkenDepthsRecipesGenrator(FabricDataOutput output) {
        super(output);
    }
    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        RegistryRecipeProvider.offerAxeRecipe(exporter, Items.DARK_AXE, Items.DARK_ESSENCE);
        RegistryRecipeProvider.offerHoeRecipe(exporter, Items.DARK_HOE, Items.DARK_ESSENCE);
        RegistryRecipeProvider.offerPickaxeRecipe(exporter, Items.DARK_PICKAXE, Items.DARK_ESSENCE);
        RegistryRecipeProvider.offerShovelRecipe(exporter, Items.DARK_SHOVEL, Items.DARK_ESSENCE);
        RegistryRecipeProvider.offerSwordRecipe(exporter, Items.DARK_SWORD, Items.DARK_ESSENCE);
        RegistryRecipeProvider.offerHelmetRecipe(exporter, Items.DARK_HELMET, Items.DARK_ESSENCE);
        RegistryRecipeProvider.offerChestplateRecipe(exporter, Items.DARK_CHESTPLATE, Items.DARK_ESSENCE);
        RegistryRecipeProvider.offerLeggingsRecipe(exporter, Items.DARK_LEGGINGS, Items.DARK_ESSENCE);
        RegistryRecipeProvider.offerBootsRecipe(exporter, Items.DARK_BOOTS, Items.DARK_ESSENCE);

    }
}

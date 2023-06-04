package me.codecraft.darkendepths.datagen;

import me.codecraft.darkendepths.advancements.DarkenDepthsAdvancement;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;

import java.util.function.Consumer;

public class DarkenDepthsAdvancementGenerator extends FabricAdvancementProvider {
    public DarkenDepthsAdvancementGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        new DarkenDepthsAdvancement().accept(consumer);
    }
}

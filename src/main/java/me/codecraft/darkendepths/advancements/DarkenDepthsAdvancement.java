package me.codecraft.darkendepths.advancements;

import me.codecraft.darkendepths.DarkenDepths;
import me.codecraft.darkendepths.item.DarkenDepthsItems;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class DarkenDepthsAdvancement {
    public AdvancementEntry root;

    public void accept(Consumer<AdvancementEntry> advancementConsumer) {

        root = Advancement.Builder.create().display(
                        DarkenDepthsItems.DARK_ESSENCE, // The display icon
                        Text.literal("DarkenDepths"), // The title
                        Text.literal("DarkenDepths"),// The description
                        new Identifier("textures/gui/advancements/backgrounds/adventure.png"),// Background image used
                        AdvancementFrame.GOAL,
                        false,
                        false,
                        false
                ).criterion("has_dark_essence", InventoryChangedCriterion.Conditions.items(DarkenDepthsItems.DARK_ESSENCE))
                .build(advancementConsumer, DarkenDepths.MOD_ID+":root");
        AdvancementEntry got_full_armor = Advancement.Builder.create()
                .display(
                        DarkenDepthsItems.DARK_CHESTPLATE, // The display icon
                        Text.literal("Cover me With Darkness"), // The title
                        Text.translatable(DarkenDepths.MOD_ID+".advancement.get_darkness_armor"), // The description
                        new Identifier("textures/gui/advancements/backgrounds/adventure.png"), // Background image used
                        AdvancementFrame.CHALLENGE, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("got_full_armor", InventoryChangedCriterion.Conditions
                        .items(DarkenDepthsItems.DARK_HELMET, DarkenDepthsItems.DARK_CHESTPLATE, DarkenDepthsItems.DARK_LEGGINGS, DarkenDepthsItems.DARK_BOOTS)).rewards(AdvancementRewards.Builder.experience(200))
                .parent(root)
                .build(advancementConsumer, DarkenDepths.MOD_ID+":"+"tools/full_armor");
    }
}

package me.codecraft.darkendepths.item;

import io.github.codecraftplugin.registrylib.utils.Registry;
import me.codecraft.darkendepths.DarkenDepths;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class GroupItems {

    public static ItemGroup DARKEN_DEPTHS_GROUP = Registry.registerItemGroup("darkendepths", DarkenDepths.MOD_ID, () -> new ItemStack(Items.DARK_ESSENCE));
    public static void GroupItemsinit() {
        // This is a static class, so we need to call the init() method ourselves
    }
}

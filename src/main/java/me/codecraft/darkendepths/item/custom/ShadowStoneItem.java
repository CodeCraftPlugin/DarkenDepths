package me.codecraft.darkendepths.item.custom;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ShadowStoneItem extends Item {
    public ShadowStoneItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if(!world.isClient){
            if (user!=null&&!user.getInventory().armor.isEmpty()) {
                System.out.println(user.getInventory().getArmorStack(0));
                ItemStack boots = user.getInventory().getArmorStack(0).copy();
                ItemStack leggings = user.getInventory().getArmorStack(0).copy();
                ItemStack chestplate = user.getInventory().getArmorStack(0).copy();
                ItemStack helemt = user.getInventory().getArmorStack(0).copy();
                user.getInventory().armor.remove(2);
                user.getInventory().armor.remove(3);
                user.getInventory().armor.remove(4);
                user.getInventory().armor.remove(0);
            }
        }
        return super.use(world, user, hand);
    }
}

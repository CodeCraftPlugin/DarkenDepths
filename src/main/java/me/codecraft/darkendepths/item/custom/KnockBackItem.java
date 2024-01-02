package me.codecraft.darkendepths.item.custom;

import me.codecraft.darkendepths.DarkenDepths;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class KnockBackItem extends Item {
    public KnockBackItem(Settings settings) {
        super(settings);
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) { // Make sure this runs on the server side

            // Create a bounding box around the player
            Box box = user.getBoundingBox().expand(5.0, 5.0, 5.0); // Expand method grows the box in every direction by the specified amount

            List<Entity> entities = world.getOtherEntities(user, box); // getOtherEntities excludes the specified entity (in this case, player)

            for(Entity entity : entities){
                if(entity instanceof LivingEntity) {   // Knockback is only applicable to Living entities
                    Vec3d vec = entity.getPos().subtract(user.getPos()).normalize();
                    ((LivingEntity) entity).takeKnockback(2, vec.x+entity.getPos().x, vec.z+entity.getPos().z);   // apply knockback effect
                }
                System.out.println("Entity name: " + entity.getEntityName());
                System.out.println("Entity position: " + entity.getBlockPos().toString());
            }
        }
        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

        tooltip.add(Text.translatable("tooltip."+ DarkenDepths.MOD_ID+".knockback.tooltip.1"));
        tooltip.add(Text.translatable("tooltip."+ DarkenDepths.MOD_ID+".knockback.tooltip.2"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}

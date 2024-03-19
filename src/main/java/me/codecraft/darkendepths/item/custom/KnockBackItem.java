package me.codecraft.darkendepths.item.custom;

import me.codecraft.darkendepths.DarkenDepths;
import me.codecraft.darkendepths.client.render.geo.item.ShadowWandRender;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
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
import software.bernie.geckolib.GeckoLib;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.RenderProvider;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.util.RenderUtils;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class KnockBackItem extends Item implements GeoItem {
//    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);



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
                    ((LivingEntity) entity).takeKnockback(5.5D, vec.x+entity.getPos().x, vec.z+entity.getPos().z);   // apply knockback effect
                }
                System.out.println("Entity name: " + entity.getDisplayName().toString());
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

    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {

            private final ShadowWandRender render = new ShadowWandRender();
            @Override
            public BuiltinModelItemRenderer getCustomRenderer() {
                return this.render;
            }
        });
    }

    @Override
    public double getTick(Object itemStack) {
        return RenderUtils.getCurrentTick();
    }

    @Override
    public Supplier<Object> getRenderProvider() {
        return renderProvider;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<GeoAnimatable>(this,"contorler",0,this::predicate));

    }

    private PlayState predicate(AnimationState<GeoAnimatable> geoAnimatableAnimationState) {

        geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("main", Animation.LoopType.LOOP));
     return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}

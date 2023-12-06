package me.codecraft.darkendepths.mixin;


import me.codecraft.darkendepths.item.DarkenDepthsItems;
import me.codecraft.darkendepths.status_effects.DarkenDepthsStatusEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {


    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At("HEAD"), method = "tick")
    private void tick(CallbackInfo info) {
        PlayerEntity player = (PlayerEntity)(Object) this;
        CheckArmor(player);

    }
    @ModifyVariable(method = "damage", at = @At("HEAD"), argsOnly = true)
    private float modifyDamage(float amount, DamageSource source) {
        PlayerEntity player = (PlayerEntity)(Object) this;
        if (player.hasStatusEffect(DarkenDepthsStatusEffects.SHADOW_PROTECTION) && !player.getWorld().isDay()) {
            return 0.0F;
        }
        return amount;
    }
    private void CheckArmor(PlayerEntity player){
        System.out.println(player.getArmorItems().iterator().next().getItem());

        if(player.getEquippedStack(EquipmentSlot.HEAD).getItem() != DarkenDepthsItems.DARK_HELMET){
            resetArmorEffect(player);

            return;
        }
        if(player.getEquippedStack(EquipmentSlot.CHEST).getItem() != DarkenDepthsItems.DARK_CHESTPLATE){
            resetArmorEffect(player);
            return;
        }
        if(player.getEquippedStack(EquipmentSlot.LEGS).getItem() != DarkenDepthsItems.DARK_LEGGINGS){
            resetArmorEffect(player);
            return;
        }if(player.getEquippedStack(EquipmentSlot.FEET).getItem() != DarkenDepthsItems.DARK_BOOTS){
            resetArmorEffect(player);
            return;
        }
        if(player.hasStatusEffect(StatusEffects.NIGHT_VISION)){
            return;
        }
        if(player.hasStatusEffect(StatusEffects.FIRE_RESISTANCE)){
            return;
        }if(player.hasStatusEffect(StatusEffects.HASTE)){
            return;
        }
        if (player.hasStatusEffect(DarkenDepthsStatusEffects.SHADOW_PROTECTION)){
            return;
        }
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 100*20, 2, false, false));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 100*20, 2, false, false));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 100*20, 2, false, false));
        player.addStatusEffect(new StatusEffectInstance(DarkenDepthsStatusEffects.SHADOW_PROTECTION, 100*20, 2, false, false));

    }

    private static void resetArmorEffect(PlayerEntity player) {
        player.removeStatusEffect(StatusEffects.HASTE);
        player.removeStatusEffect(StatusEffects.FIRE_RESISTANCE);
        player.removeStatusEffect(StatusEffects.NIGHT_VISION);
        player.removeStatusEffect(DarkenDepthsStatusEffects.SHADOW_PROTECTION);
    }

}


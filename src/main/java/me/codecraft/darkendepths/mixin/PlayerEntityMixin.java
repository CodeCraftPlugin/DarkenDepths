package me.codecraft.darkendepths.mixin;


import me.codecraft.darkendepths.datagen.tags.DarkenDepthsItemTag;
import me.codecraft.darkendepths.inventory.ShadowStoneInventory;
import me.codecraft.darkendepths.item.DarkenDepthsItems;
import me.codecraft.darkendepths.mixinInterface.IPlayerInventroyMixin;
import me.codecraft.darkendepths.status_effects.DarkenDepthsStatusEffects;
import net.fabricmc.fabric.mixin.item.ItemStackMixin;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity implements IPlayerInventroyMixin {


    ShadowStoneInventory shadowStoneInventory = new ShadowStoneInventory();

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public ShadowStoneInventory getShadowStoneInventory() {
        return shadowStoneInventory;
    }
    //Injecting

    @Inject(at = @At("HEAD"), method = "tick")
    private void tick(CallbackInfo info) {
        PlayerEntity player = (PlayerEntity)(Object) this;
        CheckArmor(player);

    }

    @Inject(at= @At("TAIL"),method = "readCustomDataFromNbt")
    public void readNbt(NbtCompound nbt, CallbackInfo ci){
        if (nbt.contains("ShadowItems", NbtElement.LIST_TYPE)) {
            shadowStoneInventory.readNbtList(nbt.getList("ShadowItems", NbtElement.COMPOUND_TYPE));
        }

    }
    @Inject(at= @At("TAIL"),method = "writeCustomDataToNbt")
    private void writeNbt(NbtCompound nbt, CallbackInfo ci){
        nbt.put("ShadowItems", shadowStoneInventory.toNbtList());

    }
    //Modifying Variable
    @ModifyVariable(method = "damage", at = @At("HEAD"), argsOnly = true)
    private float modifyDamage(float amount, DamageSource source) {
        PlayerEntity player = (PlayerEntity)(Object) this;
        if (player.getAttacker() != null) {
            ItemStack attackerItem  = player.getAttacker().getStackInHand(Hand.MAIN_HAND).getItem().getDefaultStack();
            List<Item> yourItemList = Arrays.asList(DarkenDepthsItems.DARK_PICKAXE,DarkenDepthsItems.DARK_AXE,DarkenDepthsItems.DARK_SWORD,DarkenDepthsItems.DARKSHADOW_CORE);
            if (player.hasStatusEffect(DarkenDepthsStatusEffects.SHADOW_PROTECTION) && !(player.getWorld().isDay() )&& (player.getHealth()<1)&& !(yourItemList.contains(attackerItem))) {
                return 0.0F;
            }
        }
        return amount;
    }

    private void CheckArmor(PlayerEntity player){
//
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


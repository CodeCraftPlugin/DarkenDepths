package me.codecraft.darkendepths.status_effects;

import io.github.codecraftplugin.registrylib.utils.Registry;
import me.codecraft.darkendepths.DarkenDepths;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;

public class DarkenDepthsStatusEffects {


    public static final StatusEffect SHADOW_PROTECTION = Registry.registerStatusEffects("shadow_protection", DarkenDepths.MOD_ID,new DarkenDepthsStatusEffect(StatusEffectCategory.BENEFICIAL, 0x22203b));
    public static void StatusEffectsInit() {
        DarkenDepths.logger.debug("Darken Depths Status Effects Initialized");
    }
}

package me.codecraft.darkendepths;

import me.codecraft.darkendepths.blocks.DarkenDepthsBlocks;
import me.codecraft.darkendepths.item.DarkenDepthsGroupItems;
import me.codecraft.darkendepths.item.DarkenDepthsItems;
import me.codecraft.darkendepths.status_effects.DarkenDepthsStatusEffect;
import me.codecraft.darkendepths.status_effects.DarkenDepthsStatusEffects;
import me.codecraft.darkendepths.world.gen.DarkenDepthsWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.minecraft.registry.BuiltinRegistries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.logging.ILogger;

public class DarkenDepths implements ModInitializer {

    public static final String MOD_ID = "darkendepths";
    public static Logger  logger = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        DarkenDepthsItems.Itemsinit();
        DarkenDepthsBlocks.init();
        DarkenDepthsGroupItems.GroupItemsinit();
        DarkenDepthsWorldGeneration.generateWorldGen();
        DarkenDepthsStatusEffects.StatusEffectsInit();


    }
}

package me.codecraft.darkendepths.entity;

import io.github.codecraftplugin.registrylib.utils.Registry;
import me.codecraft.darkendepths.DarkenDepths;
import me.codecraft.darkendepths.entity.custom.DarkShadowEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;



public class DarkenDepthsEntities {
    public static final EntityType<DarkShadowEntity> DARK_SHADOW = Registry.registerEntity("darkshadow", DarkenDepths.MOD_ID,
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, DarkShadowEntity::new).dimensions(EntityDimensions.changing(2.0f,2.0f)).build());


    public static void init() {
        DarkenDepths.logger.info("Loading Entities");
        AddAttribute();
    }

    private static void AddAttribute(){
        FabricDefaultAttributeRegistry.register(DARK_SHADOW, DarkShadowEntity.createDarkShadowAttributes());
    }



}

package me.codecraft.darkendepths.world;

import me.codecraft.darkendepths.DarkenDepths;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;

public class DarkenDepthsBiomes {
    public static final RegistryKey<Biome> DARKENED_DEPTHS_KEY = registerKey("darkened_depths");
    public static final Biome DARKENED_DEPTHS_BIOME  = new Biome.Builder()
            .precipitation(true)
                .temperature(0.8f)
                .downfall(0.4f)
                .effects(new BiomeEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7907327).build())
            .generationSettings(new GenerationSettings.Builder().carver(GenerationStep.Carver.AIR,null).build())
            .spawnSettings(new SpawnSettings.Builder()
                        .spawn(SpawnGroup.MONSTER,
                                new SpawnSettings.SpawnEntry(EntityType.CAVE_SPIDER,3,5,8))
            .build())
            .build();


    public static void bootstrap(Registerable<Biome> context) {
        register(context, DARKENED_DEPTHS_KEY,DARKENED_DEPTHS_BIOME); //new Biome

    }

    public static RegistryKey<Biome> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.BIOME, new Identifier(DarkenDepths.MOD_ID, name));
    }

    private static void register(Registerable<Biome> context,RegistryKey<Biome> key ,Biome biome) {
        context.register(key,biome);
    }
}

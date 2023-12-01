package me.codecraft.darkendepths;

import me.codecraft.darkendepths.world.biome.custom.DarkenDepthRegion;
import me.codecraft.darkendepths.world.biome.custom.DarkenDepthSurfaceRuleData;
import me.codecraft.darkendepths.world.biome.custom.TestRegion1;
import me.codecraft.darkendepths.world.biome.custom.TestRegion2;
import net.minecraft.util.Identifier;
import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

import static me.codecraft.darkendepths.DarkenDepths.MOD_ID;

public class DarkenDepthsTerrablenderApi implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        System.out.println("Darken Depths TerraBlender API initialized");
            // Weights are kept intentionally low as we add minimal biomes
            Regions.register(new TestRegion1(new Identifier(MOD_ID, "overworld_1"), 10));
            Regions.register(new TestRegion2(new Identifier(MOD_ID, "overworld_2"), 12));
            Regions.register(new DarkenDepthRegion(new Identifier(MOD_ID, "overworld_3"), RegionType.OVERWORLD, 2));

            // Register our surface rules
//            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, DarkenDepthSurfaceRuleData.makeRules());
    }
}
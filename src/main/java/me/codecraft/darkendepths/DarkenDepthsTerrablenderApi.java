package me.codecraft.darkendepths;

import terrablender.api.TerraBlenderApi;

public class DarkenDepthsTerrablenderApi implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        System.out.println("Darken Depths TerraBlender API initialized");
    }
}

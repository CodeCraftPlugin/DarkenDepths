package me.codecraft.darkendepths.client;

import net.fabricmc.api.ClientModInitializer;

public class DarkenDepthsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("Hello Fabric world! (Client)");
    }
}

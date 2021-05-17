package io.github.fallOut015.teleporters.client.renderer;

import io.github.fallOut015.teleporters.block.BlocksTeleporters;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class RenderTypeLookupTeleporters {
    public static void doClientStuff(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(BlocksTeleporters.TELEPORTER.get(), RenderType.translucent());
    }
}
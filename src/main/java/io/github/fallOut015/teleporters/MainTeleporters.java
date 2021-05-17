package io.github.fallOut015.teleporters;

import io.github.fallOut015.teleporters.block.BlocksTeleporters;
import io.github.fallOut015.teleporters.client.renderer.RenderTypeLookupTeleporters;
import io.github.fallOut015.teleporters.item.ItemsTeleporters;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.system.CallbackI;

import java.util.stream.Collectors;

@Mod(MainTeleporters.MODID)
public class MainTeleporters {
    public static final String MODID = "teleporters";

    public MainTeleporters() {
        BlocksTeleporters.register(FMLJavaModLoadingContext.get().getModEventBus());
        ItemsTeleporters.register(FMLJavaModLoadingContext.get().getModEventBus());

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderTypeLookupTeleporters.doClientStuff(event);
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
    }

    private void processIMC(final InterModProcessEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber
    public static class Events {
        @SubscribeEvent
        @OnlyIn(Dist.CLIENT)
        public static void onItemTooltip(final ItemTooltipEvent itemTooltipEvent) {
            if(itemTooltipEvent.getItemStack().getItem() == Items.ENDER_EYE) {
                if(itemTooltipEvent.getItemStack().hasTag()) {
                    if(itemTooltipEvent.getItemStack().getTag().contains("pos")) {
                        BlockPos pos = BlockPos.of(itemTooltipEvent.getItemStack().getTag().getLong("pos"));
                        itemTooltipEvent.getToolTip().add(new TranslationTextComponent("item.minecraft.ender_eye.pos").withStyle(TextFormatting.ITALIC, TextFormatting.YELLOW).append(new StringTextComponent("(" + pos.getX() + ", " + pos.getY() + ", " + pos.getZ() + ")"))); // attuned ender eyes found in chests and stuff will have obfuscated names
                    }
                }
            }
        }
    }
}
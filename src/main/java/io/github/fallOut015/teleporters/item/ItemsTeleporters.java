package io.github.fallOut015.teleporters.item;

import io.github.fallOut015.teleporters.MainTeleporters;
import io.github.fallOut015.teleporters.block.BlocksTeleporters;
import io.github.fallOut015.teleporters.block.TeleporterBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemsTeleporters {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MainTeleporters.MODID);



    public static final RegistryObject<Item> TELEPORTER = ITEMS.register("teleporter", () -> new BlockItem(BlocksTeleporters.TELEPORTER.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));



    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}

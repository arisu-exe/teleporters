package io.github.fallOut015.teleporters.block;

import io.github.fallOut015.teleporters.MainTeleporters;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlocksTeleporters {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MainTeleporters.MODID);



    public static final RegistryObject<Block> TELEPORTER = BLOCKS.register("teleporter", () -> new TeleporterBlock(Block.Properties.of(Material.STONE)));



    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}

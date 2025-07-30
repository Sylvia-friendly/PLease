package com.example.selma;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SelmaBlockMod implements ModInitializer {
    public static final Block CORRUPTED_SELMA_BLOCK = new CorruptedSelmaBlock();

    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, Utils.id("corrupted_selma_block"), CORRUPTED_SELMA_BLOCK);
        Registry.register(Registry.ITEM, Utils.id("corrupted_selma_block"),
            new BlockItem(CORRUPTED_SELMA_BLOCK, new Item.Settings()));
        // You may want to hook up SelmaCorruption.tickSpread to a world tick event for mob spreading!
    }
}

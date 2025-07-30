package com.example.selma;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.AbstractBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import java.util.Random;

public class CorruptedSelmaBlock extends Block {
    public CorruptedSelmaBlock() {
        super(AbstractBlock.Settings.of(Material.SCULK).strength(3.0f).luminance(state -> 10).ticksRandomly());
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        // Spread to a random nearby block
        BlockPos target = pos.add(random.nextInt(7) - 3, random.nextInt(3) - 1, random.nextInt(7) - 3);
        BlockState targetState = world.getBlockState(target);
        if (targetState.isAir() || targetState.getMaterial().isReplaceable()) {
            world.setBlockState(target, SelmaBlockMod.CORRUPTED_SELMA_BLOCK.getDefaultState(), 3);
        }

        // Corrupt nearby entities
        world.getEntitiesByClass(LivingEntity.class, new net.minecraft.util.math.Box(pos).expand(1.5), e -> !SelmaCorruption.isCorrupted(e))
            .forEach(entity -> SelmaCorruption.corruptEntity(world, entity));
    }
}

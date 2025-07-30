package com.example.selma;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.particle.ParticleTypes;

public class SelmaCorruption {
    public static boolean isCorrupted(LivingEntity entity) {
        return entity.getScoreboardTags().contains("selma_corrupted");
    }

    public static void corruptEntity(ServerWorld world, LivingEntity entity) {
        entity.addScoreboardTag("selma_corrupted");
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 20 * 60, 1));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 60, 0));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20 * 60, 0));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 20, 1));
        world.spawnParticles(ParticleTypes.PORTAL, entity.getX(), entity.getY() + 1, entity.getZ(), 32, 0.6, 1, 0.6, 0.04);
    }

    // Call this once per tick in a world tick event!
    public static void tickSpread(ServerWorld world) {
        for (LivingEntity entity : world.getEntitiesByClass(LivingEntity.class, entity -> isCorrupted(entity))) {
            BlockPos under = entity.getBlockPos().down();
            if (!world.getBlockState(under).isOf(SelmaBlockMod.CORRUPTED_SELMA_BLOCK)) {
                world.setBlockState(under, SelmaBlockMod.CORRUPTED_SELMA_BLOCK.getDefaultState());
            }
            world.spawnParticles(ParticleTypes.END_ROD, entity.getX(), entity.getY() + 1, entity.getZ(), 2, 0.2, 0.3, 0.2, 0.01);
        }
    }
}

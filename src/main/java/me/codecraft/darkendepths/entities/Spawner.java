package me.codecraft.darkendepths.entities;

import me.codecraft.darkendepths.DarkenDepths;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.SpawnHelper;

public class Spawner implements net.minecraft.world.spawner.Spawner {
    @Override
    public int spawn(ServerWorld world, boolean spawnMonsters, boolean spawnAnimals) {

        int count = 0;

        for (int i = 0; i < 2; i++) {
            int x = world.random.nextInt(16) + 8;
            int z = world.random.nextInt(16) + 8;
            int y = world.getTopY(Heightmap.Type.WORLD_SURFACE, x, z) - world.random.nextInt(200);

            DarkenDepths.logger.debug("spawnin' a cloud");
            BlockPos pos = new BlockPos(x, y, z);

            if (SpawnHelper.isClearForSpawn(world, pos, world.getBlockState(pos), world.getFluidState(pos), EntityType.WOLF)) {
                WolfEntity cloudEntity = new WolfEntity(EntityType.WOLF, world);
                cloudEntity.refreshPositionAndAngles(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, world.random.nextFloat() * 360.0F, 0.0F);
                world.spawnEntity(cloudEntity);
                count++;
            }
        }


        return count;
    }
}

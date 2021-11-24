package net.anonymousrand.setseedvideos.util;

import net.minecraft.client.util.math.Vector3d;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public abstract class SpawnEntity {
    public static void spawnEntity(World world, Entity firstEntityToSpawn, int numberToSpawn, double x, double y, double z) {
        for (int i = 0; i < numberToSpawn; i++) {
            if (i > 0) {
                firstEntityToSpawn = firstEntityToSpawn.getType().create(world);
            }

            if (firstEntityToSpawn != null) {
                firstEntityToSpawn.teleport(x, y, z);
                world.spawnEntity(firstEntityToSpawn);
            }
        }
    }
}

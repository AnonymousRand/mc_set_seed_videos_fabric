package net.anonymousrand.setseedvideos.mixin;

import net.anonymousrand.setseedvideos.util.SpawnEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class MixinPlayer {

    private PlayerEntity player = ((PlayerEntity)(Object)this);
    private boolean e1, e2, p1, b1;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void initBools(CallbackInfo info) {
        this.e1 = false;
        this.e2 = false;
        this.p1 = false;
        this.b1 = false;
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void spawnEntities(CallbackInfo info) {
        if (this.player.getEntityWorld().getDimensionRegistryKey() == DimensionType.THE_NETHER_REGISTRY_KEY) { /**spawn these mobs when player gets to a specific location*/
            if (Math.abs(this.player.getX() - 2.0) < 6.0 && Math.abs(this.player.getZ() - 3.0) < 6.0 && !this.e1) {
                this.e1 = true;
                SpawnEntity.spawnEntity(this.player.getEntityWorld(), new EndermanEntity(EntityType.ENDERMAN, this.player.getEntityWorld()), 2, 13.0, 56.0, 3.0);
            }

            if (Math.abs(this.player.getX() - 51.0) < 8.0 && Math.abs(this.player.getZ() - 23.0) < 8.0 && !this.e2) {
                this.e2 = true;
                SpawnEntity.spawnEntity(this.player.getEntityWorld(), new EndermanEntity(EntityType.ENDERMAN, this.player.getEntityWorld()), 2, 74.0, 51.0, 26.0);
            }

            if (Math.abs(this.player.getX() - 214.0) < 6.0 && Math.abs(this.player.getZ() - 104.0) < 6.0 && !this.p1) {
                this.p1 = true;
                SpawnEntity.spawnEntity(this.player.getEntityWorld(), new PiglinEntity(EntityType.PIGLIN, this.player.getEntityWorld()), 3, 194.0, 72.0, 140.0);
                SpawnEntity.spawnEntity(this.player.getEntityWorld(), new PiglinEntity(EntityType.PIGLIN, this.player.getEntityWorld()), 3, 205.0, 77.0, 132.0);
            }

            if (Math.abs(this.player.getX() - -26.0) < 8.0 && Math.abs(this.player.getY() - 71.0) < 6.0 && Math.abs(this.player.getZ() - 82.0) < 8.0 && !this.b1) {
                this.b1 = true;
                SpawnEntity.spawnEntity(this.player.getEntityWorld(), new BlazeEntity(EntityType.BLAZE, this.player.getEntityWorld()), 3, -41.0, 74.0, 98.0);
                SpawnEntity.spawnEntity(this.player.getEntityWorld(), new BlazeEntity(EntityType.BLAZE, this.player.getEntityWorld()), 3, -41.0, 74.0, 123.0);
            }
        }
    }
}

package net.anonymousrand.setseedvideos.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.boss.dragon.phase.PhaseType;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EnderDragonEntity.class)
public abstract class MixinEnderDragon {

    private EnderDragonEntity dragon = ((EnderDragonEntity)(Object)this);
    private int nonPerchTicks;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void initNonPerchTicks(CallbackInfo info) {
        this.nonPerchTicks = 0;
    }

    @Inject(method = "tickMovement", at = @At("TAIL"))
    private void forcePerch(CallbackInfo info) {
        this.nonPerchTicks++;

        if (this.nonPerchTicks % 1000 == 0 && this.nonPerchTicks > 0) { /**draogn always perches at 50 seconds*/
            this.nonPerchTicks = -1000;
            this.dragon.getPhaseManager().setPhase(PhaseType.LANDING_APPROACH);
        }
    }
}

package net.anonymousrand.setseedvideos.mixin;

import net.minecraft.entity.mob.HoglinEntity;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ZombifiedPiglinEntity.class)
public abstract class MixinZombifiedPiglin {

    private ZombifiedPiglinEntity zombiePiglin = ((ZombifiedPiglinEntity)(Object)this);

    @Inject(method = "mobTick", at = @At("HEAD"))
    private void killIf(CallbackInfo info) { /**zombified piglins can't exist in this area*/
        if (Math.abs(this.zombiePiglin.getX() - 202.0) < 15.0 && Math.abs(this.zombiePiglin.getZ() - 140.0) < 15.0) {
            ((AccessorEntityMembers)this.zombiePiglin).callRemove();
        }

        if (Math.abs(this.zombiePiglin.getX() - 170.0) < 35.0 && Math.abs(this.zombiePiglin.getZ() - 139.0) < 35.0) {
            ((AccessorEntityMembers)this.zombiePiglin).callRemove();
        }
    }
}

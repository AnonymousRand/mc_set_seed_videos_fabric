package net.anonymousrand.setseedvideos.mixin;

import net.minecraft.entity.mob.WitherSkeletonEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WitherSkeletonEntity.class)
public abstract class MixinWitherSkeleton {

    private WitherSkeletonEntity witherSkeleton = ((WitherSkeletonEntity)(Object)this);

    @Inject(method = "<init>", at = @At("TAIL"))
    private void kill(CallbackInfo info) { /**wither skeletons can't exist*/
        ((AccessorEntityMembers)this.witherSkeleton).callRemove();
    }
}

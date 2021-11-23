package net.anonymousrand.setseedvideos.mixin;

import net.minecraft.entity.mob.SkeletonEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SkeletonEntity.class)
public abstract class MixinSkeleton {

    private SkeletonEntity skeleton = ((SkeletonEntity)(Object)this);

    @Inject(method = "<init>", at = @At("TAIL"))
    private void kill(CallbackInfo info) { /**skeletons can't exist*/
        ((AccessorEntityMembers)this.skeleton).callRemove();
    }
}

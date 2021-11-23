package net.anonymousrand.setseedvideos.mixin;

import net.minecraft.entity.mob.MagmaCubeEntity;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MagmaCubeEntity.class)
public abstract class MixinMagmaCube {

    private MagmaCubeEntity magmaCube = ((MagmaCubeEntity)(Object)this);

    @Inject(method = "<init>", at = @At("TAIL"))
    private void kill(CallbackInfo info) { /**magma cubes can't exist*/
        ((AccessorEntityMembers)this.magmaCube).callRemove();
    }
}

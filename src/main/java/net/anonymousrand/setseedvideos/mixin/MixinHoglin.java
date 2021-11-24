package net.anonymousrand.setseedvideos.mixin;

import net.minecraft.entity.mob.HoglinEntity;
import net.minecraft.entity.mob.MagmaCubeEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HoglinEntity.class)
public abstract class MixinHoglin {

    @Shadow
    private int timeInOverworld;

    private HoglinEntity hoglin = ((HoglinEntity)(Object)this);

    @Inject(method = "mobTick", at = @At("HEAD"))
    private void killIf(CallbackInfo info) {
        if (this.timeInOverworld == 0) { /**hoglins can't exist in these areas in the nether*/
            if (Math.abs(this.hoglin.getX()) < 30.0 && Math.abs(this.hoglin.getZ() - 10.0) < 30.0) {
                ((AccessorEntityMembers)this.hoglin).callRemove();
            }

            if (Math.abs(this.hoglin.getX() - 50.0) < 40.0 && Math.abs(this.hoglin.getZ() - 21.0) < 20.0) {
                ((AccessorEntityMembers)this.hoglin).callRemove();
            }

            if (Math.abs(this.hoglin.getX() - 209.0) < 15.0 && Math.abs(this.hoglin.getZ() - 127.0) < 30.0) {
                ((AccessorEntityMembers)this.hoglin).callRemove();
            }
        }
    }
}

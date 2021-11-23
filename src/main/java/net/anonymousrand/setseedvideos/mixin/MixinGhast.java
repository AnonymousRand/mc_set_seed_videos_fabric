package net.anonymousrand.setseedvideos.mixin;

import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.mob.GhastEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GhastEntity.class)
public abstract class MixinGhast {

    private GhastEntity ghast = ((GhastEntity)(Object)this);

    @Inject(method = "<init>", at = @At("TAIL"))
    private void kill(CallbackInfo info) { /**ghasts can't exist*/
        ((AccessorEntityMembers)this.ghast).callRemove();
    }
}

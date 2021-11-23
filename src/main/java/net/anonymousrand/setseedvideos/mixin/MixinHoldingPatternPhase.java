package net.anonymousrand.setseedvideos.mixin;

import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.boss.dragon.phase.AbstractPhase;
import net.minecraft.entity.boss.dragon.phase.HoldingPatternPhase;
import net.minecraft.entity.boss.dragon.phase.PhaseType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HoldingPatternPhase.class)
public abstract class MixinHoldingPatternPhase implements AccessorAbstractPhase {

    private AbstractPhase phase = ((AbstractPhase)(Object)this);
    private EnderDragonEntity dragon;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void initDragon(CallbackInfo info) {
        this.dragon = ((AccessorAbstractPhase)this.phase).getDragon(); //usage of accessor interfaces
    }

    @Inject(method = "method_6841", at = @At("RETURN"))
    private void noInstaperch(CallbackInfo info) {
        if (this.dragon.getPhaseManager().getCurrent().getType() == PhaseType.LANDING_APPROACH && this.dragon.age < 1000) { /**draogn can't perch before 50 seconds*/
            this.dragon.getPhaseManager().setPhase(PhaseType.HOLDING_PATTERN);
        }
    }
}

package net.anonymousrand.setseedvideos.mixin;

import net.minecraft.world.MobSpawnerLogic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobSpawnerLogic.class)
public abstract class MixinMobSpawnerLogic {

    @Shadow //can use shadow here instead of accessor interfaces like with holdingpatternphase because we target the class that directly has this field, not like the holdingpatternphase which inherits the dragon field from abstractphase.class.
    private int maxSpawnDelay;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void initNonPerchTicks(CallbackInfo info) { /**spawners always take only 10-15 seconds to spawn a mob*/
        this.maxSpawnDelay = 300;
    }
}

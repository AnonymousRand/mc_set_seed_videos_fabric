package net.anonymousrand.setseedvideos.mixin;

import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.boss.dragon.phase.AbstractPhase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(AbstractPhase.class)
public interface AccessorAbstractPhase {
    @Accessor("dragon") //can't use shadow in interfaces as it causes "variable might not have been initialized"
    EnderDragonEntity getDragon();
}

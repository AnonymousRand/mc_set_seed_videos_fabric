package net.anonymousrand.setseedvideos.mixin;

import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Entity.class)
public interface AccessorEntityMembers {

    @Invoker
    void callRemove(); //call followed by original method name, capitalized
}

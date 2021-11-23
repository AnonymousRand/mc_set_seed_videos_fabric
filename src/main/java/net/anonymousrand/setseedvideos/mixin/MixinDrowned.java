package net.anonymousrand.setseedvideos.mixin;

import net.fabricmc.loom.util.FabricApiExtension;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.DrownedEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DrownedEntity.class)
public abstract class MixinDrowned extends LivingEntity {

    public MixinDrowned(World world) {
        super(EntityType.DROWNED, world);
    }

    @Inject(method = "initEquipment", at = @At("TAIL"))
    private void removeTrident(CallbackInfo info) {
        this.setStackInHand(Hand.MAIN_HAND, new ItemStack(Items.AIR)); /**drowned can't have tridents etc.*/
    }
}

package net.kav.stamina_kav.mixin;

import net.kav.stamina_kav.event.AttackOveride;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class doAttackMixin {



    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/MinecraftClient;doAttack()Z"), method = "handleInputEvents()V", cancellable = true)
    public void doAttack(CallbackInfo info)
    {
        AttackOveride.print();

    }
}

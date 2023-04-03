package net.fabricmc.example.mixin;

import net.fabricmc.example.ExampleModKt;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.RunArgs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

    @Inject(method = "<init>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/MinecraftClient;setOverlay(Lnet/minecraft/client/gui/screen/Overlay;)V",
                    shift = At.Shift.BEFORE
            ))
    public void onSetOverlay(RunArgs args, CallbackInfo callback) {
        ExampleModKt.postInit();
    }

    @Inject(at = @At("HEAD"), method = "scheduleStop")
    public void onScheduleStop(CallbackInfo ci) {
        ExampleModKt.shutdown();
    }

}
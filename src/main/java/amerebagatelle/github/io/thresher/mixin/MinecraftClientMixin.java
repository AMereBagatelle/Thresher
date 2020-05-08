package amerebagatelle.github.io.thresher.mixin;

import amerebagatelle.github.io.thresher.Thresher;
import amerebagatelle.github.io.thresher.util.ThresherException;
import amerebagatelle.github.io.thresher.util.ThresherExceptionScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.RunArgs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Inject(method = "<init>", at = @At("TAIL"))
    @Environment(EnvType.CLIENT)
    public void onInit(RunArgs args, CallbackInfo ci) {
        try {
            Thresher.checker.checkValues();
        } catch (ThresherException e) {
            MinecraftClient.getInstance().openScreen(new ThresherExceptionScreen(e.reasons));
        }
    }
}
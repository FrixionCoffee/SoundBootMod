package jp.sugarcoffee.soundboot.forge.mixin;

import jp.sugarcoffee.soundboot.CommonTitleScreenMixin;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {
    private static boolean initialize = false;

    @Inject(at = @At("TAIL"), method = "init()V")
//    @Inject(at = @At("TAIL"), method = "render")
    private void init(CallbackInfo callbackInfo) {
        if (!initialize) {

            CommonTitleScreenMixin.playSound();
            initialize = true;

        }
    }
}

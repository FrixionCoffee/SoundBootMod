package jp.sugarcoffee.soundboot.fabric.mixin;

import jp.sugarcoffee.soundboot.CommonTitleScreenMixin;
import jp.sugarcoffee.soundboot.SoundBootMod;
import net.minecraft.client.gui.screens.TitleScreen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {

    private static byte mixinCall = 0;

    @Inject(at = @At("TAIL"), method = "init()V")
    private void init(CallbackInfo callbackInfo) {

        addCall();

        //Forgeと異なりinit()が2回呼ばれた時がタイトル表示時
        if (mixinCall != 2) {
            return;
        }

        CommonTitleScreenMixin.playSound();
    }

    private void addCall() {
        if (mixinCall >= 4) {
            return;
        }
        mixinCall++;
    }

}

package jp.sugarcoffee.soundboot.forge.mixin;

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
    private static boolean initialize = false;

    @Inject(at = @At("TAIL"), method = "init()V")
//    @Inject(at = @At("TAIL"), method = "render")
    private void init(CallbackInfo callbackInfo) {
        if (!initialize) {
            final Logger LOGGER = LogManager.getLogger();
            LOGGER.debug("Sound Boot Mod: TitleScreen Mixin run!");

            SoundBootMod.createBootSoundDirectory();
            SoundBootMod.searchWavFile()
                            .ifPresent(SoundBootMod::soundPlay);
            initialize = true;

        }
    }
}

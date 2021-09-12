package jp.sugarcoffee.soundboot;

import org.apache.logging.log4j.LogManager;

public class CommonTitleScreenMixin {

    public static void playSound() {
        LogManager.getLogger()
                .debug("Sound Boot Mod: TitleScreen Mixin run!");

        SoundBootMod.createBootSoundDirectory();
        SoundBootMod.searchWavFile()
                .ifPresent(SoundBootMod::soundPlay);
    }

}

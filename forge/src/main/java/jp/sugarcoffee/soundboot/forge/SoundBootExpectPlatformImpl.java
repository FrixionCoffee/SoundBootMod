package jp.sugarcoffee.soundboot.forge;

import jp.sugarcoffee.soundboot.SoundBootExpectPlatform;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

@SuppressWarnings("unused")
public class SoundBootExpectPlatformImpl {
    /**
     * This is our actual method to {@link SoundBootExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }

    public static Path getGameDirectory() {
        return getConfigDirectory().getParent();
    }
}

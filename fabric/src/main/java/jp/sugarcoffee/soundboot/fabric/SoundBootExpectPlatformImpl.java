package jp.sugarcoffee.soundboot.fabric;

import jp.sugarcoffee.soundboot.SoundBootExpectPlatform;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

@SuppressWarnings("unused")
public class SoundBootExpectPlatformImpl {
    /**
     * This is our actual method to {@link SoundBootExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }

    public static Path getGameDirectory() {
        return getConfigDirectory().getParent();
    }
}

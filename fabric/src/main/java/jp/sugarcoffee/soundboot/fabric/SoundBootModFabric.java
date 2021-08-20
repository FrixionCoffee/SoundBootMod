package jp.sugarcoffee.soundboot.fabric;

import jp.sugarcoffee.soundboot.SoundBootMod;
import net.fabricmc.api.ModInitializer;

public class SoundBootModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        SoundBootMod.init();
    }
}

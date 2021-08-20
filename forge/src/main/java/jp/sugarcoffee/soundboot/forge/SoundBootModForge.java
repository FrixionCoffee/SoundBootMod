package jp.sugarcoffee.soundboot.forge;

import jp.sugarcoffee.soundboot.SoundBootMod;
import me.shedaniel.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SoundBootMod.MOD_ID)
public class SoundBootModForge {
    public SoundBootModForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(SoundBootMod.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        SoundBootMod.init();
    }
}

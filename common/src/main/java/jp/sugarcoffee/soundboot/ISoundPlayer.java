package jp.sugarcoffee.soundboot;

import java.nio.file.Files;
import java.nio.file.Path;

public interface ISoundPlayer {

    void start(Path soundPath);

    default void checkFile(Path soundPath) {
        if (Files.isDirectory(soundPath) || Files.notExists(soundPath)) {
            throw new IllegalArgumentException();
        }

    }
}

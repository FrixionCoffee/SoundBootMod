package jp.sugarcoffee.soundboot;

import jp.sugarcoffee.soundboot.functions.IOExceptionRunner;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SoundBootMod {
    public static final String MOD_ID = "soundbootmod";

    public static void init() {

    }

    public static void soundPlay(Path path) {
        SoundBootPlayerFactory factory = new SoundBootPlayerFactory();
        factory.create()
                .start(path);
    }

    private static Path getBootSoundDirPath() {
        final Path gameDir = SoundBootExpectPlatform
                .getGameDirectory()
                .normalize()
                .toAbsolutePath();

        return gameDir.resolve("sound_boot");
    }

    public static void createBootSoundDirectory() {
        final Path soundDir = getBootSoundDirPath();

        if (Files.exists(soundDir)) {
            return;
        }

        // return ignore
        new IOExceptionRunner<Path, Path>().run(
                Files::createDirectory, soundDir
        );
    }

    private static Stream<Path> filesList(Path searchDirPath) {
        return new IOExceptionRunner<Path, Stream<Path>>().run(
                Files::list, searchDirPath
        );
    }

    public static Optional<Path> searchWavFile() {
        final List<Path> pathList = filesList(getBootSoundDirPath())
                .filter(Objects::nonNull)
                .filter(path -> path.getFileName().toString().endsWith(".wav"))
                .collect(Collectors.toList());

        if (pathList.isEmpty()) {
            return Optional.empty();
        }

        Random random = new Random();
        final int index = random.nextInt(pathList.size());

        return Optional.of(
                pathList.get(index)
        );
    }
}

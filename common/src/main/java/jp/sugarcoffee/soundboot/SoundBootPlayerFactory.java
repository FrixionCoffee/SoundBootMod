package jp.sugarcoffee.soundboot;

import jp.sugarcoffee.soundboot.functions.IOExceptionRunner;
import org.apache.logging.log4j.LogManager;

import javax.sound.sampled.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SoundBootPlayerFactory {

    ISoundPlayer create() {
        switch (JavaVersion.getJavaVersion()) {

            case JAVA8:
//                return new Java8SoundPlayer();
            case JAVA11_ENVIRONMENT_OVER:
            case JAVA16:
                return new ClipPlayer();
            case JAVA17_FUTURE:
                return new Java17SoundPlayer();
            default:
                throw new IllegalJavaEnvironmentException("Java 7 and below and Java 9 to 10 do not work.");
        }
    }
}

class ThreadStart {

    /**
     * Decide if you want it to work on the thread.
     *
     * @param runnable function
     */
    public static void run(Runnable runnable) {
        new Thread(runnable).start();
//        runnable.run();
    }

}

@Deprecated
class Java8SoundPlayer implements ISoundPlayer {

    /**
     * @deprecated I'm not sure why, but it doesn't work.Delete Applet(Java11? over).
     */
    @Override
    public void start(final Path soundPath) {
        checkFile(soundPath);

        ThreadStart.run(() -> {
            try {
                final AudioClip audioClip = Applet.newAudioClip(
                        soundPath.toAbsolutePath().normalize().
                                toUri().toURL()
                );

                audioClip.play();

            } catch (MalformedURLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        });

    }
}

class ClipPlayer implements ISoundPlayer {

    enum Si {

        ONE_GIGA_BYTE(1_000_000_000L);

        public final long value;

        Si(long l) {
            value = l;
        }
    }

    @Override
    public void start(final Path soundPath) {
        checkFile(soundPath);

        final long fileSize = new IOExceptionRunner<Path, Long>().run(
                Files::size, soundPath
        );

        if (fileSize >= Si.ONE_GIGA_BYTE.value) {
            // 多分Clip Playerはストリーム再生ではなく、RAMに一括展開して再生するタイプなので、あまりにもRAMを専有しそうなファイルは弾く
            throw new IllegalArgumentException("Playable files are less than 1GB");
        }

        ThreadStart.run(() -> {
            try (final AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundPath.toFile())) {

                final AudioFormat audioFormat = audioInputStream.getFormat();
                DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
                final Clip clip = (Clip) AudioSystem.getLine(info);
                // if (AudioSystem.getLine(info) instanceof Clip c) java16用構文

                // Forge時、リスナを追加しないと音声が問答無用で途中終了されてしまう
                clip.addLineListener(event -> {
                    if (event.getType() == LineEvent.Type.STOP) {
                        clip.close();
                        LogManager.getLogger().info("Music fin.");
                    }
                });

                clip.open(audioInputStream);
                clip.start();

            } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        });

    }
}

class Java17SoundPlayer implements ISoundPlayer {
    @Override
    public void start(Path soundPath) {
        throw new UnsupportedOperationException();
    }
}
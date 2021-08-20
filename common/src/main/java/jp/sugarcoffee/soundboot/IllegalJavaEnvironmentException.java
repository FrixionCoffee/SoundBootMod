package jp.sugarcoffee.soundboot;

public class IllegalJavaEnvironmentException extends RuntimeException {

    public IllegalJavaEnvironmentException(Throwable cause) {
        super(cause);
    }

    public IllegalJavaEnvironmentException(String message) {
        super(message);
    }
}

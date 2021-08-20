package jp.sugarcoffee.soundboot.functions;

import java.io.IOException;

public class IOExceptionRunner<T, R> {
    public R run(IOFunction<T, R> function, T t) {
        try {
            return function.apply(t);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
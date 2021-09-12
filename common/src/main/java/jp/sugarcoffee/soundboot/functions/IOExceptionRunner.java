package jp.sugarcoffee.soundboot.functions;

import java.io.IOException;
import java.io.UncheckedIOException;

public class IOExceptionRunner<T, R> {
    public R run(IOFunction<T, R> function, T t) {
        try {
            return function.apply(t);
        } catch (IOException e) {
            throw ExceptionUtil.printAndWrapThrow(e, UncheckedIOException::new);
        }
    }
}
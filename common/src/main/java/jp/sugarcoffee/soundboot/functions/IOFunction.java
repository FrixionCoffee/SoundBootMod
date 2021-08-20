package jp.sugarcoffee.soundboot.functions;

import java.io.IOException;

@FunctionalInterface
public interface IOFunction<T, R> extends ThrowsFunction<T, R, IOException> {
}
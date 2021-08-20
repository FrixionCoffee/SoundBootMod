package jp.sugarcoffee.soundboot.functions;

@FunctionalInterface
public interface ThrowsFunction<T, R, Ex extends Exception> {
    R apply(T t) throws Ex;
}
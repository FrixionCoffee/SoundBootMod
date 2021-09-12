package jp.sugarcoffee.soundboot.functions;

import java.util.function.Function;

public class ExceptionUtil {

    public static <X extends Exception, Ex extends RuntimeException> Ex printAndWrapThrow(X e, Function<X, Ex> exceptionFunction) {
        e.printStackTrace();
        return exceptionFunction.apply(e);
    }

    public static <X extends Exception> RuntimeException printAndWrapThrow(X e) {
        e.printStackTrace();
        return new RuntimeException(e);
    }

}

package java8.zJava8Revisions.myFunctionalInterface;

import java.util.Objects;
import java.util.function.Function;

/**
 * Created by nitin on Tuesday, February/18/2020 at 11:08 PM
 */
@FunctionalInterface
public interface Convertor<T, R> {

    R convert(T t);

    default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> convert(before.apply(v));
    }

    default <V> Function<T, V> convertFurther(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(convert(t));
    }
}
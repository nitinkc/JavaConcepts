package nitin.a6oops.interfaces.functionalInterface.PredefinedFunctionalInterfaces.functionUsage;

import java.util.function.Function;

public class TransformExecutor<T, R> {
    public T transformString(R r, Transformer<T, R> transformer) {
        return transformer.applyFunction(r);
    }

    public R transform(T t, Function<T, R> transformer) {
        return transformer.apply(t);
    }
}

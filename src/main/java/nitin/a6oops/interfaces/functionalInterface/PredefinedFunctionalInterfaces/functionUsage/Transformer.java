package nitin.a6oops.interfaces.functionalInterface.PredefinedFunctionalInterfaces.functionUsage;

@FunctionalInterface
public interface Transformer<T, R> {
    T applyFunction(R r);
}

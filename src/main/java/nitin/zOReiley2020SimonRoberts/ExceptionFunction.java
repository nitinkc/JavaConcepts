package nitin.zOReiley2020SimonRoberts;

public interface ExceptionFunction<E, F> {
    F apply(E e) throws Throwable;
}

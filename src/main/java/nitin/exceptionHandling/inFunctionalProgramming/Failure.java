package nitin.exceptionHandling.inFunctionalProgramming;

public final class Failure<T> implements Try<T> {
    private final Throwable throwable;

    Failure(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public T getResult() {
        throw new RuntimeException("Invalid invocation");
    }

    @Override
    public Throwable getError() {
        return throwable;
    }
}

package nitin.exceptionHandling.inFunctionalProgramming;

public final class Success<T> implements Try<T> {
    private T result;

    Success(T result){
        this.result = result;
    }

    @Override
    public T getResult(){
        return result;
    }

    @Override
    public Throwable getError(){
        throw new RuntimeException("Invalid invocation");
    }
}

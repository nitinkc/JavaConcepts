package nitin.multithreading.bFuturesAndCompletableFutures.futures;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class OurFutureTask<V> extends FutureTask<V> {

    public OurFutureTask(Callable<V> callable) {
        super(callable);
    }

    @Override
    protected void done() {
        try {
            System.out.println("Done Task1..." + get());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Exception Task1..." + exceptionNow());
        }
   }

}


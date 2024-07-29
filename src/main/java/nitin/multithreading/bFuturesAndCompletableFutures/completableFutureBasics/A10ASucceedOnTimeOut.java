package nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static com.utilities.MultiThreadUtility.delay;

public class A10ASucceedOnTimeOut {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = new CompletableFuture<>();

        future
                .thenApply(data -> data + 3)
                .exceptionally(throwable -> handleExcptionally(throwable))
                .thenApply(data -> data * 2)
                .thenAccept(data -> System.out.println("Result from Future " + data));

        System.out.println("Pipeline is built....");

        delay(1000);

        future.completeOnTimeout(5, 1, TimeUnit.SECONDS);//With Java 9 onwards
        //does not keep the pipeline in PENDING STATE more than a second. If the values doesnt arrive in a second,
        //then resolve it with the default value being passes

        delay(2000);

        //If there is delay for complete to run more than time out value from completeOnTimeout, then complete on time
        //out code will run
        future.complete(2);//if this runs, then completeOnTimeout will have no effect
        System.out.println("DONE");
    }

    private static Integer handleExcptionally(Throwable throwable) {
        System.out.println(throwable.getMessage());
        System.out.println("Sending recovery value");
        return -1;
    }

    private static void successOnTimeOut(CompletableFuture<Integer> future) {
        future.completeOnTimeout(5, 1, TimeUnit.SECONDS);//Does not keep the pipeline in PENDING state
        //for more than a second. the value doesn't arrive in 1 sec (timeout) then resolve it, via the default value
    }

    private static void failureOnTimeOut(CompletableFuture<Integer> future) {
        future.orTimeout(1, TimeUnit.SECONDS);//Does not keep the pipeline in PENDING state
        //for more than a second. the value doesn't arrive in 1 sec (timeout) then cancel it, and completes it exceptionally with a TimeoutException
    }
}

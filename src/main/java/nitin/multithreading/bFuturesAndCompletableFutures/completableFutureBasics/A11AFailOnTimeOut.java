package nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static com.utilities.MultiThreadUtility.delay;

public class A11AFailOnTimeOut {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = new CompletableFuture<>();

        future
                .thenApply(data -> data + 3)
                .exceptionally(throwable -> handleExceptionally(throwable))
                .thenApply(data -> data * 2)
                .thenAccept(data -> System.out.println("Result from Future " + data));

        System.out.println("Pipeline is built....");

        delay(1000);

        future.orTimeout(1, TimeUnit.SECONDS);//This will blowout if the state is resolved
        delay(2000);//Delay between timeout and completion is taking into account

        future.complete(2);
        System.out.println("DONE");
    }

    private static Integer handleExceptionally(Throwable throwable) {
        System.out.println(throwable.getMessage());
        System.out.println("Sending recovery value from handleExceptionally");
        return -1;
    }
}

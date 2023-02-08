package nitin.asynchronousProgramming;

import java.util.concurrent.CompletableFuture;

import static com.utilities.MultiThreadUtility.delay;

public class A9CompleteExceptionally {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = new CompletableFuture<>();

        future
                .thenApply(data -> data+1)
                .exceptionally(throwable -> handleExcptionally(throwable))
                .thenApply(data -> data*2)
                .thenAccept(data -> System.out.println("Result from Future " + data));

        System.out.println("Pipeline is built....");

        delay(1000);
        future.completeExceptionally(new RuntimeException("don't write such code"));//Evaluates lazily. The pipeline executes from this point on
        //future.complete(2);
        delay(1000);
    }

    private static Integer handleExcptionally(Throwable throwable) {
        System.out.println(throwable.getMessage());
        System.out.println("Sending recovery value");
        return -1;
    }
}

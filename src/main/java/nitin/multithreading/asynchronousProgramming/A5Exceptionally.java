package nitin.multithreading.asynchronousProgramming;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.utilities.MultiThreadUtility.delay;

public class A5Exceptionally {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //exceptionIntro1();

        CompletableFuture<Integer> future = new CompletableFuture<>();

        future
                .thenApply(data -> 5 / data)//Exception will not be printed unless exceptionally is written to handle it.
                .exceptionally(throwable -> {
                    System.out.println("5/data exception" + throwable.getMessage());
                    return null;
                })
                .thenApply(data -> data * 2)//This will get skipped if the above exception is not handled
                .exceptionally(throwable -> handleEx1(throwable))
                .thenApply(data -> data + 2)//NOT A PROBABLE EXCEPTION, except for a null
                .exceptionally(throwable -> {
                    System.out.println("Exception after data+2 :: NPE " + throwable);
                    return -1;
                })
                .thenAccept(data -> System.out.println(data));

        System.out.println("Pipeline is done");
        delay(4000);

        //future.complete(3/0);//Exception will be thrown only for the imperative style not for the functional
        future.complete(0);
    }

    private static void exceptionIntro1() {
        CompletableFuture<Double> future = new CompletableFuture<>();
        future = getData();

        future
                //.thenApply(x ->  x.intValue() )
                .thenApply(x -> 0)
                .exceptionally(throwable -> handleEx1(throwable))
                .thenApply(x -> 2 * x)
                .thenAccept(x -> System.out.println("rtr " + x))//Behaves like ForEach, but not a reduction operation.
                .exceptionally(throwable -> handleEx2(throwable))
                .thenRun(() -> System.out.println("Can continue"))
                .thenRun(() -> System.out.println("Even further"))
                .thenAccept(x -> System.out.println(x));
    }

    private static Void handleEx2(Throwable throwable) {
        System.out.println(throwable.getMessage());
        return null;
    }

    private static Integer handleEx1(Throwable throwable) {
        System.out.println(throwable.getMessage());
        return -1;
    }

    private static CompletableFuture<Double> getData() {
        return CompletableFuture.supplyAsync(() -> 3.14);
    }

    private static Integer handleExcptionally(Throwable throwable) {
        int i = 2 / 0;
        System.out.println("Recovered from ERROR");
        return 0;
    }
}

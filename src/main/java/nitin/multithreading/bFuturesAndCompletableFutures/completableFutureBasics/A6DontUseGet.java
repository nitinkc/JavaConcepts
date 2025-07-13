package nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics;

import static com.utilities.MultiThreadUtility.delay;

import java.util.concurrent.CompletableFuture;

public class A6DontUseGet {
    public static void main(String[] args) throws Exception {
        CompletableFuture<Double> future = CompletableFuture.supplyAsync(() -> compute());

        System.out.println("Before running the pileline");
        // Double data = future.get();//BAD Idea, forces to handle exception
        // get() is a blocking call; The best thing to do with GET is to forGET
        // INSTEAD use thenAccept

        delay(100);
        // if it's so important to use get, use getNow() with a default value
        Double data = future.getNow(-99.0); // need to provide a value if the value is absent
        // getNow() is impatient non-blocking and moves on with a value if there is no immediate
        // response
        // If there is delay prior to getNow call then the getNow may return the correct value.
        // The delay in compute is 100 ms while that of the delay above getNow is 1000ms, so it
        // works.

        System.out.println(data);
    }

    private static double compute() {
        delay(100);
        return 3.14;
    }
}

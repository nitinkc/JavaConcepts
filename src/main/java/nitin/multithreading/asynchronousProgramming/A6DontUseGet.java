package nitin.multithreading.asynchronousProgramming;

import java.util.concurrent.CompletableFuture;

import static com.utilities.MultiThreadUtility.delay;

public class A6DontUseGet {
    public static void main(String[] args) throws Exception {
        CompletableFuture<Double> future = getData();

        System.out.println("Before running the pileline");
        //Double data = future.get();//BAD Idea, forces to handle exception
        //get() is a blocking call; The best thing to do with GET is to forGET
        //INSTEAD use thenAccept


        delay(1000);
        //if its so important to use get, use getNow() with a default value
        Double data = future.getNow(-99.0);//need to provide a value if the value is absent
        //getNow() is impatient non-blocking and moves on with a value if there is no immediate response
        //If there is delay prior to getNow call then the getNow may return the correct value.
        //The delay in compute is 100 ms while that of the delaye above getNow is 1000ms so it works.

        System.out.println(data);

        System.out.println("Should run first if there is a delay from the Async task getData()");
    }

    public static CompletableFuture<Double> getData() {
        return CompletableFuture.supplyAsync(() -> compute());
    }

    private static double compute() {
        delay(100);
        return 3.14;
    }

}

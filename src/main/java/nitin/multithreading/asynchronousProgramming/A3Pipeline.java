package nitin.multithreading.asynchronousProgramming;

import com.entity.EmployeeSimple;
import com.entity.SampleData;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class A3Pipeline {
    public static void main(String[] args) {

        //intro();

        CompletableFuture<Double> completableFuture = getData();

        // completableFuture.thenAccept(x -> System.out.println(x));

        //If there is an exception, the future will go into REJECT state
        completableFuture
                //.thenApply(x ->  x.intValue() )
                .thenApply(x -> Double.parseDouble(String.valueOf(x))) //If there is an exception, handle with exceptionally
                .thenApply(x -> 2 / x)
                .thenAccept(x -> System.out.println("rtr " + x))//Behaves like ForEach, but not a reduction operation.
                .thenRun(() -> System.out.println("Can continue"))
                .thenRun(() -> System.out.println("Even further"))
                .thenAccept(x -> System.out.println(x));

    }

    private static void intro() {
        getData()
                .thenApply(num -> num * 100)//like Map
                .thenAccept(data -> System.out.println(data))//forEach, like reduction operation
                .thenRun(() -> System.out.println("Job Done!!"));//Still continue with the Comp\letableFuture
    }

    public static CompletableFuture<Double> getData() {
        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        return CompletableFuture.supplyAsync(() -> 3.14);
    }
}

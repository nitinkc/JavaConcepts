package nitin.asynchronousProgramming;

import com.utilities.InternetUtilities;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static com.utilities.MultiThreadUtility.delay;

public class A4CallPipeline {
    public static void main(String[] args) {
        intro0();
        intro1();
        intro2();
    }

    private static void intro0() {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<Integer>();
        completableFuture
                .thenApply(data -> data*2)
                        .thenApply(data -> data + 1)
                        .thenAccept(data -> System.out.println(data));

        System.out.println("Pipeline is built");


        completableFuture.complete(3);//Pipeline doesnot run until the complete is supplied a value.
    }

    private static void intro2() {
        CompletableFuture<List<String>> future = new CompletableFuture<>();

        future
                .thenApply(data -> data.stream().limit(10).collect(Collectors.toList()))
                .thenApply(data -> {
                    return data.stream()
                            .map(word -> getTransformedString(word))
                            .collect(Collectors.toList());

                })
                .thenAccept(data -> data.forEach(str -> System.out.println("Word is :: " + str)));

        System.out.println("Pipeline is built....");

        delay(3000);
        future.complete(InternetUtilities.bringWordListFromNet());//Evaluates lazily. The pipeline executes from this point on

        System.out.println("Post Future");
    }

    private static String getTransformedString(String word) {
        delay(1000);
        return word.toUpperCase();
    }

    private static void intro1() {
        CompletableFuture<Integer> future = new CompletableFuture<>();

        future
                .thenApply(data -> 2/data*2)
                .exceptionally(throwable -> {
                    System.out.println(throwable.getMessage());
                    return 9;
                })
                .thenApply(data -> data+1)
                .thenAccept(data -> System.out.println("Result from Future " + data))
                .thenRun(()-> System.out.println("Process Completed!!"));

        System.out.println("Pipeline is built....");

        delay(4000);
        future.complete(0);//Evaluates lazily. The pipeline executes from this point on
    }
}

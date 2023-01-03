package nitin.streams.parallelStreams;

import com.utilities.MultiThreadUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class FJPCustomization {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            list.add(i);
        }

        Stream<Integer> integerParallelStream =
                list.parallelStream()
                        .filter(num -> num * 1 == num)
                        .map(num -> incrementWith1SecDelay(num))
                //.forEach(num -> {})
                ;

        customizingForkJoinPool(integerParallelStream);//Sending the stream
    }

    private static void customizingForkJoinPool(Stream<Integer> integerStream) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(100);//parallelism = 100
        forkJoinPool.submit(() -> integerStream.forEach(e -> {}));//Running the reduction operation in another method withg another thread

        forkJoinPool.shutdown();

        try {
            forkJoinPool.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int incrementWith1SecDelay(int number){
        MultiThreadUtility.logMessage(String.valueOf(number));
        MultiThreadUtility.delay(1000);
        return number + 1;
    }
}

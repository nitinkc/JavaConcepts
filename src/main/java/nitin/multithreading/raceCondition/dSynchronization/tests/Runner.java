package nitin.multithreading.raceCondition.dSynchronization.tests;

import java.util.*;
import java.util.concurrent.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Runner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int count = 1000;

        IncrementLikes il = new IncrementLikes();
        Set<Integer> uniqueSequences = getLikes(count, il);
    }

    private static Set<Integer> getLikes(int count, IncrementLikes il)
            throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Set<Integer> uniqueSequences = new LinkedHashSet<>();
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            System.out.println("Created Task: " + executor);
            futures.add(executor.submit(il::incrementLikes));
        }

        for (Future<Integer> future : futures) {
            Integer result =
                    future.resultNow(); // Future returns the datatype of the method thats been
            // multithreaded
            System.out.println("Result from Future " + result);
            uniqueSequences.add(result);
        }

        executor.awaitTermination(1, TimeUnit.SECONDS);
        executor.shutdown();
        return uniqueSequences;
    }
}

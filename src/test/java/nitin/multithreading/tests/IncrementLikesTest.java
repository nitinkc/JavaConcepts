package nitin.multithreading.tests;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import nitin.multithreading.raceCondition.dSynchronization.tests.IncrementLikes;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class IncrementLikesTest {

    @Test
    public void givenUnsafeSequenceGenerator_whenRaceCondition_thenUnexpectedBehavior()
            throws Exception {
        int count = 1000;

        IncrementLikes il = new IncrementLikes();
        Set<Integer> uniqueSequences = getLikes(count, il);
        Assertions.assertEquals(count, uniqueSequences.size());
    }

    private Set<Integer> getLikes(int count, IncrementLikes il)
            throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Set<Integer> uniqueSequences = new LinkedHashSet<>();
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            System.out.println("Created Task: " + executor);
            futures.add(executor.submit(il::incrementLikes));
        }

        for (Future<Integer> future : futures) {
            Integer result = future.get(); // Future returns the datatype of the method thats been
            // multithreaded
            System.out.println("Result from Future " + result);
            uniqueSequences.add(result);
        }

        executor.awaitTermination(1, TimeUnit.SECONDS);
        executor.shutdown();
        return uniqueSequences;
    }
}

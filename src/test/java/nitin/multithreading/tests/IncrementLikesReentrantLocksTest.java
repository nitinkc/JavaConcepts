package nitin.multithreading.tests;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import nitin.multithreading.raceCondition.dSynchronization.tests.IncrementLikesReentrantLocks;
import org.junit.Assert;
import org.junit.Test;

public class IncrementLikesReentrantLocksTest {

    @Test
    public void givenUnsafeSequenceGenerator_whenRaceCondition_thenUnexpectedBehavior()
            throws Exception {
        int count = 1000;

        IncrementLikesReentrantLocks il = new IncrementLikesReentrantLocks();
        Set<Integer> uniqueSequences = getLikes(count, il);
        Assert.assertEquals(count, uniqueSequences.size());
    }

    private Set<Integer> getLikes(int count, IncrementLikesReentrantLocks il)
            throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Set<Integer> uniqueSequences = new LinkedHashSet<>();
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < count; i++) {

            System.out.println("Created Task: " + executor);
            Future<Integer> future = executor.submit(il::incrementLikes);
            futures.add(future);
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

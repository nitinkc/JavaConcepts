package nitin.multithreading.tests;

import nitin.multithreading.raceCondition.shared.tests.IncrementLikesReentrantLocks;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;


public class IncrementLikesReentrantLocksTest {

    @Test
    public void givenUnsafeSequenceGenerator_whenRaceCondition_thenUnexpectedBehavior() throws Exception {
        int count = 1000;

        IncrementLikesReentrantLocks il = new IncrementLikesReentrantLocks();
        Set<BigDecimal> uniqueSequences = getLikes(count, il);
        Assert.assertEquals(count, uniqueSequences.size());
    }

    private Set<BigDecimal> getLikes(int count, IncrementLikesReentrantLocks il) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Set<BigDecimal> uniqueSequences = new LinkedHashSet<>();
        List<Future<BigDecimal>> futures = new ArrayList<>();

        for (int i = 0; i < count; i++) {

            System.out.println("Created Task: " + executor);
            Future<BigDecimal> future = executor.submit(il::incrementLikeBigInt);
            futures.add(future);
        }

        for (Future<BigDecimal> future : futures) {
            BigDecimal result = future.get();//Future returns the datatype of the method thats been multithreaded
            System.out.println("Result from Future " + result);
            uniqueSequences.add(result);
        }

        executor.awaitTermination(1, TimeUnit.SECONDS);
        executor.shutdown();
        return uniqueSequences;
    }
}
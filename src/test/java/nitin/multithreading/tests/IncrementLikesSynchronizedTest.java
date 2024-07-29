package nitin.multithreading.tests;

import nitin.multithreading.shared.tests.IncrementLikes;
import nitin.multithreading.shared.tests.IncrementLikesSynchronized;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class IncrementLikesSynchronizedTest {
    @Test
    public void syncTest() throws Exception {
        int count = 1000;

        IncrementLikes il = new IncrementLikesSynchronized();
        Set<Integer> uniqueSequences = getLikes(count, il);
        Assert.assertEquals(count, uniqueSequences.size());
    }

    @Test
    public void syncTest2() throws Exception {
        BigDecimal count = BigDecimal.valueOf(1000);

        IncrementLikes il = new IncrementLikesSynchronized();
        Set<BigDecimal> uniqueSequences = getLikes2(count, il);
        Assert.assertEquals(count.intValue(), uniqueSequences.size());
    }

    private Set<BigDecimal> getLikes2(BigDecimal count, IncrementLikes il) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Set<BigDecimal> uniqueSequences = new LinkedHashSet<>();
        List<Future<BigDecimal>> futures = new ArrayList<>();

        for (int i = 0; i < count.intValue(); i++) {
            futures.add(executor.submit(il::incrementLikeBigInt));
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

    private Set<Integer> getLikes(int count, IncrementLikes il) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Set<Integer> uniqueSequences = new LinkedHashSet<>();
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            futures.add(executor.submit(il::incrementLike));
        }

        for (Future<Integer> future : futures) {
            Integer result = future.get();//Future returns the datatype of the method thats been multithreaded
            System.out.println("Result from Future " + result);
            uniqueSequences.add(result);
        }

        executor.awaitTermination(1, TimeUnit.SECONDS);
        executor.shutdown();
        return uniqueSequences;
    }
}
package nitin.multithreading;

import static com.utilities.PerformanceUtility.startTimer;
import static com.utilities.PerformanceUtility.stopTimer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ParallelFactorial {
    public static void main(String[] args) throws InterruptedException {
        List<Long> inputNumbers = List.of(100L, 3435L, 35435L, 2324L, 4656L, 23L, 5556L);
        Factorial factorial = new Factorial();

        System.out.println("SEQUENTIAL");
        sequential(inputNumbers, factorial);

        System.out.println("Parallel");
        runWithTraditionalFactorial(inputNumbers, factorial);

        System.out.println("SEQUENTIAL STREAMS");
        sequentialWithStreams(inputNumbers, factorial);

        System.out.println("PARALLEL STREAMS");
        parallelStream(inputNumbers, factorial);

        System.out.println("runParallelFactorialWithExecutor");
        runParallelFactorialWithExecutor(inputNumbers, factorial);

        System.out.println("runParallelFactorialWithVirtualThreads ");
        runParallelFactorialWithVirtualThreads(inputNumbers, factorial);

        System.out.println("runWithCompletableFuture");
        runWithCompletableFuture(inputNumbers, factorial);

        System.out.println("runWithCountDownLatch");
        runWithCountDownLatch(inputNumbers, factorial);
    }

    private static void sequential(List<Long> inputNumbers, Factorial factorial) {
        startTimer();
        for (long inputNumber : inputNumbers) {
            BigInteger computedFactorial = factorial.compute(inputNumber);
        }
        stopTimer();
    }

    private static void parallelStream(List<Long> inputNumbers, Factorial factorial) {
        startTimer();
        List<BigInteger> list2 = inputNumbers.parallelStream().map(factorial::compute).toList();
        stopTimer();
    }

    private static void sequentialWithStreams(List<Long> inputNumbers, Factorial factorial) {
        startTimer();
        List<BigInteger> list = inputNumbers.stream().map(factorial::compute).toList();
        stopTimer();
    }

    private static void runWithTraditionalFactorial(List<Long> inputNumbers, Factorial factorial)
            throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (long inputNumber : inputNumbers) {
            threads.add(
                    new Thread(
                            () -> {
                                BigInteger computedFactorial = factorial.compute(inputNumber);
                                // logShortMessage(STR."Factorial of \{inputNumber} is
                                // \{computedFactorial}");
                            }));
        }

        startTimer();
        for (Thread thread : threads) {
            thread.setDaemon(true);
            thread.start();
        }

        for (Thread thread : threads) {
            // thread.join(2000);//Wait for NOT MORE THAN 2 seconds
            thread.join();
        }
        stopTimer();
    }

    private static void runParallelFactorialWithExecutor(
            List<Long> inputNumbers, Factorial factorial) {
        /*   Pros:
        Provides better control over thread management.
        Automatically handles thread pooling and task scheduling.
            Cons:
        Requires managing the lifecycle of the ExecutorService.
        */
        Callable<BigInteger> task = null;
        List<Future<BigInteger>> futures;
        try (ExecutorService executor =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())) {
            futures = new ArrayList<>();
            for (long inputNumber : inputNumbers) {
                futures.add(executor.submit(() -> factorial.compute(inputNumber)));
            }

            List<BigInteger> results = new ArrayList<>();
            startTimer();
            for (Future<BigInteger> future : futures) {
                try {
                    results.add(future.get()); // Get is not preferred
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
            stopTimer();
        }
    }

    private static void runParallelFactorialWithVirtualThreads(
            List<Long> inputNumbers, Factorial factorial) throws InterruptedException {
        /*Pros:
            More scalable and efficient for I/O-bound tasks.
            Reduces the overhead of managing many threads.
        Cons:
            Requires Java 21 or later.
            Not suitable for CPU-bound tasks where traditional threads or parallel streams might be better.*/

        ThreadFactory threadFactory = Thread.ofVirtual().name("myThread : ", 0).factory();

        List<Future<BigInteger>> submitted = new ArrayList<>();
        // try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
        try (ExecutorService srv = Executors.newThreadPerTaskExecutor(threadFactory)) {
            for (long inputNumber : inputNumbers) {
                submitted.add(srv.submit(() -> factorial.compute(inputNumber)));
            }

            startTimer();
            List<BigInteger> results =
                    submitted.stream()
                            .map(
                                    future -> {
                                        try {
                                            return future.get();
                                        } catch (Exception e) {
                                            throw new RuntimeException(e);
                                        }
                                    })
                            .toList();
            stopTimer();
        }
    }

    private static void runWithCompletableFuture(List<Long> inputNumbers, Factorial factorial) {
        startTimer();
        List<CompletableFuture<BigInteger>> futures =
                inputNumbers.stream()
                        .map(
                                inputNumber ->
                                        CompletableFuture.supplyAsync(
                                                () -> factorial.compute(inputNumber)))
                        .toList();

        List<BigInteger> results = futures.stream().map(CompletableFuture::join).toList();
        stopTimer();
    }

    private static void runWithCountDownLatch(List<Long> inputNumbers, Factorial factorial)
            throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(inputNumbers.size());
        for (long inputNumber : inputNumbers) {
            new Thread(
                            () -> {
                                try {
                                    factorial.compute(inputNumber);
                                } finally {
                                    latch.countDown();
                                }
                            })
                    .start();
        }
        startTimer();
        latch.await();
        stopTimer();
    }
}

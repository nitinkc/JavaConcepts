---
title: Thread Creation
date: 2024-08-08 20:17:00
categories:
- Multithreading
tags:
- Java
- Concurrency
---

{% include toc title="Index" %}

Considering a method `BigInteger compute(long inputNumber)` in class `Factorial`
that takes a Long integer and computes the Factorial of the long number

# Sequential

```java
private static void sequential(List<Long> inputNumbers, Factorial factorial) {
    startTimer();
    for (long inputNumber : inputNumbers) {
        BigInteger computedFactorial = factorial.compute(inputNumber);
    }
    stopTimer();
}
```

# Sequential with Stream

```java
private static void sequentialWithStreams(List<Long> inputNumbers, Factorial factorial) {
    startTimer();
    List<BigInteger> list = inputNumbers.stream()
            .map(factorial::compute)
            .toList();
    stopTimer();
}
```

# Traditional Platform Threads

[https://nitinkc.github.io/multithreading/Multithreading/#defining-platform-threads](https://nitinkc.github.io/multithreading/Multithreading/#defining-platform-threads)

```java
private static void runWithTraditionalFactorial(List<Long> inputNumbers, Factorial factorial) throws InterruptedException {
    List<Thread> threads = new ArrayList<>();

    for (long inputNumber : inputNumbers) {
        threads.add(new Thread(() -> {
            BigInteger computedFactorial = factorial.compute(inputNumber);
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
```

# Parallel Stream

```java
private static void parallelStream(List<Long> inputNumbers, Factorial factorial) {
    startTimer();
    List<BigInteger> result = inputNumbers.parallelStream()
            .map(factorial::compute)
            .toList();
    stopTimer();
}
```

# Executor & Futures

[https://nitinkc.github.io/multithreading/Multithreading/#create-executorservices](https://nitinkc.github.io/multithreading/Multithreading/#create-executorservices)

**Pros:**

- Provides better control over thread management.
- Automatically handles thread pooling and task scheduling.

**Cons:**

- Requires managing the lifecycle of the ExecutorService.

```java
private static void runParallelFactorialWithExecutor(List<Long> inputNumbers, Factorial factorial) {
    Callable<BigInteger> task = null;
    List<Future<BigInteger>> futures;
    try (ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())) {
        futures = new ArrayList<>();
        for (long inputNumber : inputNumbers) {
            futures.add(executor.submit(() -> factorial.compute(inputNumber)));
        }
        
        List<BigInteger> results = new ArrayList<>();
        startTimer();
        for (Future<BigInteger> future : futures) {
            try {
                results.add(future.get());//runs when get is executed
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        stopTimer();
    }
}
```

# Completable futures

[https://nitinkc.github.io/multithreading/asynchronous-programming/#creating-a-new-completablefuture](https://nitinkc.github.io/multithreading/asynchronous-programming/#creating-a-new-completablefuture)

```java
private static void runWithCompletableFuture(List<Long> inputNumbers, Factorial factorial) {
    startTimer();
    List<CompletableFuture<BigInteger>> futures = inputNumbers.stream()
            .map(inputNumber -> CompletableFuture.supplyAsync(() -> factorial.compute(inputNumber)))
            .toList();

    List<BigInteger> results = futures.stream()
            .map(CompletableFuture::join)
            .toList();
    stopTimer();
}
```

# Virtual threads

[Virtual Thread Creation]({% post_url /java/threads/2024-07-19-java21-virtualthreads %}#virtual-thread-creation)

**Pros:**

- More scalable and efficient for I/O-bound tasks.
- Reduces the overhead of managing many threads.

**Cons:**

- Requires Java 21 or later.
- **Not suitable for CPU-bound** tasks where traditional threads or parallel
  streams might be better.

```java
private static void runParallelFactorialWithVirtualThreads(List<Long> inputNumbers, Factorial factorial) throws InterruptedException {

    ThreadFactory threadFactory = Thread.ofVirtual().name("myThread : ", 0).factory();
    List<Future<BigInteger>> submitted = new ArrayList<>();
    //try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
    try (ExecutorService srv = Executors.newThreadPerTaskExecutor(threadFactory)) {
        for (long inputNumber : inputNumbers) {
            submitted.add(srv.submit(() -> factorial.compute(inputNumber)));
        }

        startTimer();
        List<BigInteger> results = submitted.stream()
                .map(future -> {
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
```

# Java Concurrency Utilities

use other concurrency utilities from `java.util.concurrent`, such as
`CountDownLatch` or `CyclicBarrier`, to manage parallel execution

```java
private static void runWithCountDownLatch(List<Long> inputNumbers, Factorial factorial) throws InterruptedException {
    CountDownLatch latch = new CountDownLatch(inputNumbers.size());
    for (long inputNumber : inputNumbers) {
        new Thread(() -> {
            try {
                factorial.compute(inputNumber);
            } finally {
                latch.countDown();
            }
        }).start();
    }
    startTimer();
    latch.await();
    stopTimer();
}
```
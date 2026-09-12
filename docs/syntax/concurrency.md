# Concurrency

## Starting a platform thread

```java
Thread thread = new Thread(() -> System.out.println("working"));
thread.start();
thread.join();
```

Calling `run()` directly does not start a new thread.

## Executors

```java
try (ExecutorService executor = Executors.newFixedThreadPool(4)) {
    Future<Integer> result = executor.submit(() -> 40 + 2);
    System.out.println(result.get());
}
```

Executors separate task submission from thread creation and scheduling.

## Shared state

```java
synchronized void increment() {
    count++;
}
```

`count++` is a read-modify-write sequence, not an atomic operation. Alternatives include locks and atomic variables.

```java
AtomicInteger count = new AtomicInteger();
count.incrementAndGet();
```

## CompletableFuture

```java
CompletableFuture<String> result = CompletableFuture
        .supplyAsync(() -> "java")
        .thenApply(String::toUpperCase)
        .exceptionally(exception -> "UNKNOWN");
```

Use `thenCompose` for dependent asynchronous stages and `thenCombine` for independent results.

## Virtual threads

```java
Thread thread = Thread.startVirtualThread(() -> blockingOperation());
thread.join();
```

Virtual threads are suitable for high-concurrency workloads that spend much of their time blocked on I/O. They do not make CPU-intensive work execute faster.

## Preview and internal examples

The repository also contains structured-concurrency, scoped-value, and continuation experiments. Some require `--enable-preview`; continuation examples use internal `jdk.internal.vm` APIs and should not be treated as supported application APIs.

## Repository examples

- `src/main/java/nitin/multithreading`
- `src/main/java/nitin/multithreading/cVirtualThreads`
- `src/test/java/nitin/multithreading`
- `src/main/java/nitin/multithreading/blog/BACKUP`

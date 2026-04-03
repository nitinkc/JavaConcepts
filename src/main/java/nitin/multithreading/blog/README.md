---
layout: page
title: "Java Multithreading in Practice - Complete Series"
date: 2026-04-01
categories: [java, multithreading, concurrency]
tags: [java, threads, concurrency, tutorial]
---

# Java Multithreading in Practice

A comprehensive blog series covering Java multithreading from fundamentals to advanced patterns. Perfect for revision and interview preparation.

## Directory Structure

```
blog/
├── README.md              ← You are here
├── comprehensive/         ← Final curated articles (12 parts)
│   ├── 00-series-overview.md
│   ├── 01-theory-and-fundamentals.md
│   ├── 02-thread-creation-methods.md
│   ├── 03-thread-control-coordination.md
│   ├── 04-race-conditions-critical-sections.md
│   ├── 05-synchronization-mechanisms.md
│   ├── 06-locks-and-advanced-sync.md    ← Locks, StampedLock, Semaphore, Latch
│   ├── 07-executor-framework.md
│   ├── 08-completable-future-mastery.md
│   ├── 09-concurrent-collections.md
│   ├── 10-virtual-threads.md
│   ├── 11-structured-concurrency-scoped-values.md
│   └── 12-best-practices-patterns.md
└── mine/                  ← Original notes (reference)
    └── [date-stamped notes]
```

## Comprehensive Series (Final Version)

| Part | Title | Key Topics |
|:-----|:------|:-----------|
| [00](comprehensive/00-series-overview.md) | **Series Overview** | Roadmap, Prerequisites |
| [01](comprehensive/01-theory-and-fundamentals.md) | **Theory & Fundamentals** | Process vs Thread, Concurrency vs Parallelism |
| [02](comprehensive/02-thread-creation-methods.md) | **Thread Creation** | Runnable, Callable, Thread class |
| [03](comprehensive/03-thread-control-coordination.md) | **Thread Control** | sleep, yield, join, interrupt, priority |
| [04](comprehensive/04-race-conditions-critical-sections.md) | **Race Conditions** | Critical sections, atomicity |
| [05](comprehensive/05-synchronization-mechanisms.md) | **Synchronization** | synchronized, volatile, atomic |
| [06](comprehensive/06-locks-and-advanced-sync.md) | **Locks & Advanced Sync** | ReentrantLock, ReadWriteLock, **StampedLock**, Deadlocks, Semaphore, Latch, Barrier |
| [07](comprehensive/07-executor-framework.md) | **Executor Framework** | Thread pools, ExecutorService |
| [08](comprehensive/08-completable-future-mastery.md) | **CompletableFuture** | Async chaining, combining, error handling |
| [09](comprehensive/09-concurrent-collections.md) | **Concurrent Collections** | ConcurrentHashMap, BlockingQueue |
| [10](comprehensive/10-virtual-threads.md) | **Virtual Threads** | Project Loom, lightweight threads |
| [11](comprehensive/11-structured-concurrency-scoped-values.md) | **Structured Concurrency** | ScopedValue, StructuredTaskScope |
| [12](comprehensive/12-best-practices-patterns.md) | **Best Practices** | Patterns, pitfalls, testing |

## Quick Reference

### Thread Creation
```java
// Traditional
Thread t = new Thread(runnable);
Thread t = new Thread(() -> task());

// Executor Framework
ExecutorService executor = Executors.newFixedThreadPool(4);

// Virtual Threads (Java 21+)
Thread.startVirtualThread(() -> task());
Executors.newVirtualThreadPerTaskExecutor();
```

### Synchronization
```java
// synchronized
synchronized (lock) { criticalSection(); }

// ReentrantLock
lock.lock();
try { criticalSection(); }
finally { lock.unlock(); }

// Atomic
AtomicInteger counter = new AtomicInteger();
counter.incrementAndGet();
```

### Locks Comparison

| Lock Type | Reentrant | Multiple Readers | Optimistic Read | Use Case |
|:----------|:---------:|:----------------:|:---------------:|:---------|
| `synchronized` | ✅ | ❌ | ❌ | Simple cases |
| `ReentrantLock` | ✅ | ❌ | ❌ | Need tryLock/fair/conditions |
| `ReentrantReadWriteLock` | ✅ | ✅ | ❌ | Read-heavy, need reentrancy |
| `StampedLock` | ❌ | ✅ | ✅ | Read-heavy, max performance |

### CompletableFuture
```java
CompletableFuture.supplyAsync(() -> getData())
    .thenApply(x -> transform(x))
    .thenCombine(otherFuture, (a, b) -> combine(a, b))
    .exceptionally(ex -> handleError(ex))
    .thenAccept(result -> process(result));
```

### Virtual Threads
```java
// Simple
Thread.startVirtualThread(() -> task());

// Executor (recommended)
try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
    executor.submit(() -> ioTask());
}

// Structured Concurrency
try (var scope = StructuredTaskScope.open(Joiner.awaitAll())) {
    scope.fork(() -> task1());
    scope.fork(() -> task2());
    scope.join();
}
```

## Code Examples Location

All code examples referenced in this blog series can be found in:

```
src/main/java/nitin/multithreading/
├── aBasics/
│   ├── aPlatformThreads/    # Thread creation examples
│   ├── bThreadGroups/       # Thread group examples
│   ├── cThreadPoolsAKAExecutorFW/  # Executor examples
│   └── executionPrevention/ # sleep, yield, join, interrupt
├── bFuturesAndCompletableFutures/
│   ├── futures/             # Future examples
│   └── completableFutureBasics/  # CompletableFuture examples
├── cVirtualThreads/
│   ├── v1Runnable/          # Virtual thread creation
│   ├── v3structuredConcurrency/  # Structured concurrency
│   ├── v4threadLocals/      # ThreadLocal examples
│   └── v5scopedvalue/       # ScopedValue examples
└── raceCondition/
    ├── dSynchronization/    # synchronized examples
    ├── bReentrantLocks/     # Lock examples (including StampedLock)
    ├── eVolatileVar/        # volatile examples
    ├── fAtomicVar/          # Atomic examples
    ├── deadLocks/           # Deadlock examples
    └── semaphore/           # Semaphore examples
```

## How to Run Examples

```bash
# Build the project
./gradlew classes

# Run a specific example
java --enable-preview \
     --add-exports=java.base/jdk.internal.vm=ALL-UNNAMED \
     -cp build/classes/java/main:build/resources/main \
     nitin.multithreading.cVirtualThreads.v1Runnable.V1Intro
```

## Prerequisites

- **Java 21+** recommended (for Virtual Threads)
- **Java 8+** minimum (for CompletableFuture)
- JVM flags for preview features: `--enable-preview`
- For Continuations: `--add-exports=java.base/jdk.internal.vm=ALL-UNNAMED`

## Learning Path

### Beginner
1. Part 01: Theory & Fundamentals
2. Part 02: Thread Creation
3. Part 03: Thread Control
4. Part 04: Race Conditions

### Intermediate
5. Part 05: Synchronization
6. Part 06: Locks & Advanced Sync
7. Part 07: Executor Framework
8. Part 08: CompletableFuture

### Advanced
9. Part 09: Concurrent Collections
10. Part 10: Virtual Threads
11. Part 11: Structured Concurrency
12. Part 12: Best Practices

## Interview Preparation

Key topics frequently asked in interviews:
- Thread lifecycle and states (Part 01, 03)
- synchronized vs volatile vs atomic (Part 05)
- ReentrantLock vs ReadWriteLock vs StampedLock (Part 06)
- Deadlock causes and prevention (Part 06)
- Locks vs Synchronization Aids (Semaphore, Latch) (Part 06)
- wait() vs sleep() (Part 03, 06)
- Future vs CompletableFuture (Part 07, 08)
- Thread pool sizing (Part 07, 12)
- Virtual threads use cases (Part 10)

---

*Happy Learning! 🚀*

*Last Updated: April 2026*

---
title: Synchronization Mechanisms in Java
date: 2024-08-17 20:17:00
categories:
- Multithreading
tags:
- Java
- Synchronization
- Concurrency
---

{% include toc title="Index" %}

### Volatile Variable

[Volatile]({% post_url /java/threads/2024-08-12-Volatile %})

### Mutex (Lock) - ReentrantLock

A ReentrantLock is a more flexible lock than the built-in synchronized block.

**Advantages**:

- Can be unlocked in a different method or class from where it was locked.
- Provides more control over the lock (e.g., timed lock, interruptible lock).
- can maintain fairness `ReentrantLock(true)` but may come with a cost of
  throughput.
  use unlock in finally block so that it is always guaranteed that the resource
  is unlocked.

**Use Case**: When you need advanced locking features not provided by the
synchronized block.

### 2. ReadWriteLock - ReentrantReadWriteLock

A ReadWriteLock allows multiple threads to read a resource concurrently but only
one thread to write.

2 Types
**Advantages**:

- Improves performance in scenarios where reads are more frequent than writes.

**Use Case**: When you have a resource that is frequently read but infrequently
written.

Since the method is guarded by a read lock. Many threads can acquire that lock
as long as no other thread is holding the write lock

### Semaaphore

### Condition Variables

Condition variables are used with locks to allow threads to wait for certain
conditions to be met.

Advantages:

- Allows for complex waiting conditions.

Use Case: When threads need to wait for specific conditions before proceeding.

### Atomic Variables

Atomic variables (e.g., AtomicInteger, AtomicLong, AtomicReference) provide
lock-free thread-safe operations on single variables.

Advantages:

- Lower overhead compared to using locks.

Use Case: When you need to perform atomic operations on a single variable
without the overhead of locking.

As part of the `java.util.concurrent` package, the JDK contains many classes
that help us coordinate between threads.

A few of those include the `CountDownLatch`, `CyclicBarrier`, `Phaser`,
`Exchanger`, and others that may be added in future versions
of the JDK.

However, all those classes are no more than higher-level wrappers built upon the
same building blocks.
We can implement their functionality with the tools we already have.

### CountDownLatch

A CountDownLatch is used to make one or more threads wait until a set of
operations being performed in other threads completes.

**Advantages**:

- Allows threads to wait for a specific condition to be met.

**Use Case**: Waiting for multiple threads to complete initialization tasks
before proceeding.

### CyclicBarrier

A CyclicBarrier allows a set of threads to wait for each other to reach a common
barrier point.

- guarantee that some portion of the work is done by all threads before the rest
  of the work is performed.

### Exchanger

An Exchanger allows two threads to exchange data with each other.

Advantages:

- Useful for thread communication where each thread provides data to the other.

Use Case: Pairwise data exchange between threads.

### Phaser

A Phaser is a more flexible version of CountDownLatch and CyclicBarrier.

Advantages:

- Supports dynamic registration of parties and multiple phases of
  synchronization.

Use Case: Complex synchronization scenarios with multiple phases and dynamic
participants.

### StampedLock

A StampedLock is a lock that offers three modes for controlling read/write
access.

Advantages:

- Provides an optimistic read mode, which can improve performance for read-heavy
  scenarios.

Use Case: When you need high-performance read access with occasional writes.

> Synchronization mechanisms like CountDownLatch and CyclicBarrier can be
> applicable in distributed systems.

Their usage and considerations differ compared to their usage in single-process
applications.
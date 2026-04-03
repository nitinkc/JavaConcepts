---
title: Semaphores
date: 2024-08-18 05:17:00
categories:
- Multithreading
tags:
- Java
- Synchronization
- Concurrency
---

{% include toc title="Index" %}

# Semaphore

[English meaning](https://www.merriam-webster.com/dictionary/semaphore)

![](https://merriam-webster.com/assets/mw/static/art/dict/semaphor.gif)

Can be used to restrict the **number of "users"** to a particular resource or a
group of resources

- Unlike the **locks that allow only one** "user/thread" per resource.

Initializes a Semaphore with a given number of permits. The number of permits
indicates how many
threads can access the resource simultaneously.

```java
Semaphore semaphore = new Semaphore(int permits);
```

##### Acquire and release a permit

Acquires a permit from the semaphore, **blocking until a permit is available**.

- Throws InterruptedException if the current thread is interrupted while
  waiting.

```java
try {
        semaphore.acquire();
// critical section
} catch (InterruptedException e) {
        Thread.currentThread().interrupt(); // restore interrupt status
} finally {//To ensure the release even if there is exception in the critical section
        semaphore.release();
}
```

##### tryAcquire()

```java
//if (semaphore.tryAcquire()) {//without time
if (semaphore.tryAcquire(1, TimeUnit.SECONDS)) {
    try {
        // critical section
    } finally {
        semaphore.release();
    }
} else {
    // handle failure to acquire permit
}
```

### Semaphore vs lock

Lock is a special case of Semaphore which `number_of_permits=1`

- Semaphore doen't have notion of owner thread
- Same thread can acquire the semaphore multiple times
- the binary semaphore (initialized with permits = 1) is **not reentrant**
    - if the same thread acquires it and tries to reaquire, its stuck and relies
      on other thread to release the semaphore

Semaphore can be released by any thread.

- Even can be released by a thread that hasn't actually acquired it.
- That creates a bug as it allows 2 threads inside critical section which is not
  possible at all with locks

But Semaphore is great choice for other solutions for the problems such as
Producer consumer problem

| Feature                           | Semaphore                                                                                                                                                                                                                                                                             | Lock                                                                                                                                                                                                                                         |
|-----------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Purpose**                       | Controls access to a resource by **maintaining a set number of permits**.                                                                                                                                                                                                             | Ensures **only one thread can access a resource or critical section** at a time. Provides mutual exclusion.                                                                                                                                  |
| **Basic Operation**               | **Acquire**: Threads acquire permits before accessing the resource. If no permits are available, threads **block** until a permit becomes available.<br>**Release**: Threads release permits when done with the resource, allowing other waiting threads to acquire permits.          | **Lock**: A thread acquires the lock to access the resource. If the lock is held by another thread, the current thread blocks until the lock is released.<br>**Unlock**: The thread releases the lock, allowing other threads to acquire it. |
| **Permit Count vs. Binary State** | A semaphore with 3 permits allows up to 3 threads to access the resource simultaneously.                                                                                                                                                                                              | A lock allows only one thread to enter a critical section.                                                                                                                                                                                   |
| **Fairness**                      | Can be used in a fair manner, though fairness is not always guaranteed.                                                                                                                                                                                                               | Some locks (e.g., `ReentrantLock` with fairness parameter set to true) can be configured to be fair, ensuring that threads acquire the lock in the order they requested it.                                                                  |
| **Lock as Special Case**          | A lock is a special case of a semaphore with `number_of_permits=1`.                                                                                                                                                                                                                   | N/A                                                                                                                                                                                                                                          |
| **No Owner Notion**               | Semaphore does not have a notion of an owner thread.                                                                                                                                                                                                                                  | Lock has an owner thread and ensures only the thread that acquired the lock can release it.                                                                                                                                                  |
| **Reentrancy**                    | The same thread can acquire the semaphore multiple times.<br>**Binary Semaphore**: The binary semaphore (initialized with permits = 1) is **not reentrant**; if the same thread acquires it and tries to reacquire, it is stuck and relies on other threads to release the semaphore. | Reentrant locks (e.g., `ReentrantLock`) allow the same thread to acquire the lock multiple times.                                                                                                                                            |
| **Release by Any Thread**         | Semaphore permits can be released by any thread, even if it did not acquire the permit. This can create bugs as it allows multiple threads to enter a critical section simultaneously.                                                                                                | Locks can only be released by the thread that acquired them, ensuring exclusive access to the critical section.                                                                                                                              |
| **Example Use Cases**             | **Database Connection Pool**: Limiting the number of concurrent connections to a database.<br>**Thread Pool Management**: Limiting the number of concurrent threads executing tasks.                                                                                                  | **Critical Section**: Ensuring that only one thread can modify a shared data structure or resource at a time.<br>**Atomic Operations**: Preventing race conditions when performing complex operations on shared resources.                   |

# Producer Consumer Problem

Able to have many producers and many consumers, and allow the consumers to apply
back pressure on the producers, if the producers produce faster than the
consumers can consume.

```java
final int QUEUE_CAPACITY = 10;
Semaphore emptySemaphore = new Semaphore(QUEUE_CAPACITY);
Semaphore fullSemaphore = new Semaphore(0);
ReentrantLock lock = new ReentrantLock();
Queue<Integer> queue = new ArrayDeque<>(); 
```

**Producer**

```java
 while (true) {
    emptySemaphore.acquire(); // Wait for an empty slot
      lock.lock(); // Lock access to the queue
        int item = produceItem(); // Produce an item
        queue.add(item); // Add item to the queue
      lock.unlock(); // Release the lock
    fullSemaphore.release(); // Signal that an item is available
}
```

**Consumer**

```java
while (true) {
    fullSemaphore.acquire(); // Wait for an available item
      lock.lock(); // Lock access to the queue
        int item = queue.remove(); // Remove item from the queue
        consumeItem(item); // Process the item
      lock.unlock(); // Release the lock
    emptySemaphore.release(); // Signal that an empty slot is available
```
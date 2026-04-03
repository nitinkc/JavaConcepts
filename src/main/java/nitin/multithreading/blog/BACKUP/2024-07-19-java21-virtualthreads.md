---
title: Virtual Threads
date: 2024-07-19 12:17:00
categories:
- Multithreading
tags:
- Java
- Java 21
- Concurrency
---

{% include toc title="Index" %}

| [Java21 Virtual threads Docs](https://openjdk.org/jeps/444) | [Virtual Threads Docs](https://docs.oracle.com/en/java/javase/21/core/virtual-threads.html) |

# Two kinds of threads

### Platform threads

* The number of available platform threads is limited to the number of OS
  threads.
* typically have a large thread stack and other resources that are maintained by
  the operating system.
* platform threads are managed in a **FIFO** work-stealing **ForkJoinPool**,
    * uses all available processors by default
    * can be modified by tuning the system property
      `jdk.virtualThreadScheduler.parallelism`.
* the **common pool** that’s used by other features like parallel Streams
  operates in **LIFO** mode.

[Diagram code](https://app.eraser.io/workspace/7T1zn0AFYP9i1gxvb6ZS)
![platformThreads.png](/assets/images/platformThreads.png){:width="70%" height="50%"}

### Virtual Threads

* Virtual threads are **suitable** for running tasks that spend most of the time
  blocked, often waiting **for I/O operations**
  to complete.
    * Virtual threads **don’t improve** the latency of the execution of a task
      that involves only CPU operations
* They **aren't intended** for long-running **CPU-intensive** operations. For
  that use the existing platform threads
* Not managed or scheduled by the OS, but the **JVM is responsible for
  scheduling**.
* JVM uses **carrier threads** (which are platform threads) to “carry” any
  virtual thread when its time has come to execute. Work must be run in a
  platform thread.
* All Virtual Threads are **always daemon threads**, don’t forget to call
  `join()` if you want to wait on the main thread.
    * Virtual threads are always daemon threads. An attempt to set them as non
      daemon threads will throw an exception
* Available plentifully and can be used the **one-thread-per-request** model
* If the code calls a blocking I/O operation in a virtual thread, the runtime *
  *suspends the virtual thread**
  which can be resumed at an appropriate time later

**The Virtual Thread** uses:-

- Continuations
- Executor Service
- ForkJoinPool

[Diagram code](https://app.eraser.io/workspace/zk1bATBmP6EbZ0v2nd01)
![virtualThreadArchitecture.png](/assets/images/virtualThreadArchitecture.png)

# Project Loom & Virtual threads

[Most fundamental change in Java](https://docs.oracle.com/en/java/javase/21/core/virtual-threads.html#GUID-DC4306FC-D6C1-4BCC-AECE-48C32C1A8DAA)

- The _Virtual Thread_ starts as a **Daemon thread** whereas the _Platform
  Thread_ starts as a **non-daemon thread**
- The JVM Shuts down when there are no non-daemon threads running.
- error with platform thread with a large number of threads is eliminated with
  virtual threads

```
[3.536s][warning][os,thread] Failed to start thread "Unknown thread" - pthread_create failed (EAGAIN) for attributes: stacksize: 1024k, guardsize: 4k, detached.
[3.536s][warning][os,thread] Failed to start the native thread for java.lang.Thread "Thread-8158"
```

- With Virtual threads, each worker/task corresponds to a platform thread.
- Each worker just runs and leaves and picks other task (if there is an IO bound
  operation), thus starting and ending of a same methods can be done in
  different threads.
- virtual thread `#31` is started by the `worker2` but is ended by the
  `worker4`.

```
Start::executeBusinessLogic : VirtualThread[#31]/runnable@ForkJoinPool-1-worker-2
Start::executeBusinessLogic : VirtualThread[#29]/runnable@ForkJoinPool-1-worker-1
END::executeBusinessLogic : VirtualThread[#31]/runnable@ForkJoinPool-1-worker-4
END::executeBusinessLogic : VirtualThread[#29]/runnable@ForkJoinPool-1-worker-3
```

# Virtual Thread creation

Virtual Threads are scheduled on a platform thread (aka carrier thread) for its
CPU bound operation.
The big advantage is that when we use virtual threads, the OS thread is released
**automatically during an IO operation**.

### static thread method

- can't name a thread

```java
var t = Thread.startVirtualThread(() -> executeBusinessLogic());
//Make sure that the thread terminates before moving on
t.join(); //Proceed sequentially after thread completes its task
```

### virtual thread builder object

Builder is **NOT** Thread Safe
{% gist nitinkc/b682bc6e3e3dbdb83322c940c00d0267 %}

### Thread factory

ThreadFactory is thread safe
{% gist nitinkc/cb1f98eb47895a4388e4b685a9792d65%}

### Default Virtual Thread executor service

**Default Factory** : **Cannot** name threads

**Default vs. Custom Factory**: The
`Executors.newVirtualThreadPerTaskExecutor()` uses a default virtual thread
configuration,
while the `Executors.newThreadPerTaskExecutor(factory)` allows you to specify a
**custom ThreadFactory** with particular configurations (e.g., custom naming).

{% gist nitinkc/96904758c763e2c43b6f9fdd8898e668%}

### Thread Per Task Executor Service

**Custom Factory** : The custom factory approach provides the **ability to name
threads**, which can be useful for debugging or monitoring purposes.

- The default virtual thread executor (described above) doesn’t offer this level
  of customization out of the box.

{% gist nitinkc/ddebd32d96b28d62f7fc20ddeb8336fa %}

### try with resource block

Simplifies the code because no need to join the threads.

Waiting for all threads to complete involves

- creating an array of threads and
- joining with each of them explicitly.

In JDK 21 (officially supporting Virtual threads), the ExecutorService is "*
*Autocloseable**". Which means if you use the try with resource block,
the close method will be called on the ExecutorService at the end of the block
and this will wait till all the virtual threads are terminated.

This is one example of "Structured Concurrency" where we wait for all threads
started within a block to complete,
so that there are no rogue runaway threads.

# Scenario

When there are multiple independent tasks to be completed, all as part of one
thread, without blocking the thread
> Concurrently, run many tasks within a thread in non-blocking fashion

combination of using virtual threads to write sequential code and
futures/CompletableFutures for
concurrent code is both readable and powerful
{: .notice--primary}

Whenever we need a new thread, we simply **create a new virtual thread** without
worrying about resources
as virtual threads are cheap and efficient.

There is no harm in writing blocking code within a virtual thread.

- Since there are no platform thread which holds on to the resources
- as it managed and released by the JVM

Writing non-blocking code with Reactive frameworks like project Reactor or
CompletableFutures makes the readability hard

But, if we want sophisticated mechanisms to deal things in pipeline with
exception handling and error handling mechanism,
the CompletableFutures is a good optipn

{% gist nitinkc/d218df71705ab37a711ccc6ac32ebe06%}

# Virtual Threads with ForkJoinPool

![virtualthreadWithFJPool.png]({{ site.url }}/assets/images/virtualthreadWithFJPool.png)

## Executor Framework:

- ExecutorService: Manages a pool of threads and allows you to submit tasks for execution.
- Fixed Thread Pool: Creates a pool with a fixed number of threads.
- submit(): Submits a task for execution.
- shutdown(): Initiates an orderly shutdown of the executor.
- awaitTermination(): Waits for all tasks to complete.


## CompletableFuture:
- runAsync(): Runs a task asynchronously.
- allOf(): Waits for all provided CompletableFutures to complete.
- join(): Waits for the completion of the CompletableFuture.
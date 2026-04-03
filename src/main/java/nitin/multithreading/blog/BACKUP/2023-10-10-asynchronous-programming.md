---
title: CompletableFutures & Asynchronous Programming
date: 2023-10-10 15:16:00
categories:
- Multithreading
tags:
- Java
- Concurrency
---

{% include toc title="Index" %}

# CompletableFuture

![](https://www.youtube.com/watch?v=1zSF1259s6w)

CompletableFutures in Java is the same as Promise in Javascript

##### Javascript code

Javascript is dynamically typed
{% gist nitinkc/17229c16e91766fa9eb903cad63a8def %}

| Current State | Next State | Function called            |
|:--------------|:-----------|:---------------------------|
| resolved      | resolved   | next then in the pipeline  | 
| resolved      | rejected   | next catch in the pipeline |
| rejected      | resolved   | next then in the pipeline  |
| rejected      | resolved   | next catch in the pipeline |

##### Java

Java is statically typed, so we have to provide **the type of CompletableFuture** in the declaration
{% gist nitinkc/eea4fd28d7765ec964cbf9b5c270ec5c %}

### CompletableFuture - ThreadPool

By Default, Completable future uses the **Common ForkJoinPool**.

- Which means that the number of threads in a common fork-join pool is equal to
  the number of cores in the machine
- `Runtime.getRuntime().availableProcessors()`

Common ForkJoinPool is shared by

* ParallelStreams
* CompletableFuture

And thus, **user defined thread pool** is also an option to avoid for resource
waiting scenarios arising from common thread pool.

CompletableFuture started on a different Pool (mypool) altogether.

* It's a good idea to use a different Thread pool if the tasks are IO bound.
* The Fork Join Pool must be used only CPU intensive task

User-defined thread pool

```java
int numberOfCores = Runtime.getRuntime().availableProcessors();
ExecutorService pool = Executors.newFixedThreadPool(numberOfCores);
//Usually the Thread pool would be created upfront
ExecutorService pool = Executors.newCachedThreadPool();
ForkJoinPool pool = new ForkJoinPool(10);

finally {
   pool.close();
}
```

Pass the pool into async methods (thenApplyAsync, thenAcceptAsync)

```java
ExecutorService pool = Executors.newCachedThreadPool();
CompletableFuture<Double> future =  CompletableFuture.supplyAsync(() -> compute(), pool);
CompletableFuture<Double> doubleCompletableFuture = future.thenApplyAsync(data -> data * 2, pool);
CompletableFuture<Void> voidCompletableFuture = doubleCompletableFuture.thenAcceptAsync(data -> getPrintln(data),pool);
```

# Creating a new CompletableFuture

### supplyAsync() - with return Data

`CompletableFuture<V>`
{% gist nitinkc/7d0d331d4716151c51579d4fdda5ba94 %}

### runAsync() - No Return data

`CompletableFuture<Void>`
{% gist nitinkc/e186dba8001122fa5281cf979cd5ce3d %}

### new CompletableFuture<>()

Creating a pipeline and then completing
{% gist nitinkc/da36ef99c6a7e383e7aea4475328ad9c %}

##### complete(T value):

* allows completing a `CompletableFuture`, manually, with a specific result
  value.
* to provide a result explicitly, bypassing the actual asynchronous computation.
  {% gist nitinkc/28618b6feb55df00447289a75b351dba %}

# Stages of Completable futures

When one stage completes, another one starts and it keeps running

### supplyAsync()

* Factory method
* used to initiate asynchronous computations (tasks)
* takes **Supplier** as the input
* returns `CompletableFuture<T>()` of type T

### thenApply() & thenApplyAsync()

* Completion Stage method
* used for applying transformations, takes a Function
* thenApply deals with **Function that returns** a value
* returns `CompletableFuture<T>()` of TypeT

### thenAccept() & thenAcceptAsync

* CompletionStage method
* used for chaining asynchronous tasks. Has the capability to use the results of
  previous async task and perform
  actions on it
* takes **Consumer** as the input
* returns `CompletableFuture<Void>()` type Void

### Exceptionally

With the use of **exceptionally** if the execution of the task is

* OK, go to the next THEN
* exception, go to the next EXCEPTIONALLY,
    * BUT with proper type handling. The return type of Exceptionally has to be
      of the proper type.
    * Write the exception code generically and use that so that it aligns to the
      data type properly.

  {% gist nitinkc/6ddd9a3a39bb8639ffe23e9dee2ea709 %}

### thenCombine()

**Use Case** : When there is a need to bring data from multiple microservices
and combine them

* used to combine Independent Completable Futures (two asynchronous tasks)
    * For Example : if a service makes 2 calls to independent services, then the
      total latency will be MAX(service1,
      service2) instead of SUM(service1, service2)
* Takes two arguments - `thenCombine(CompletionStage, BiFunction)`
    * CompletionStage,
    * BiFunction
* Returns a CompletableFuture

{% gist nitinkc/124fce7e90ac53e72f3d45f014d8a88b %}

### thenCompose()

* compose() is used for transforming the result of one CompletableFuture into
  another CompletableFuture.
* used to chain two asynchronous operations where the second depends on the
  result of the first.
* The function provided to compose() maps the result of the first
  CompletableFuture to a new CompletableFuture.
* thenCompose depends on the completion of the dependent Future task
* Completion Stage method
* Input is a `Function` functional interface, Transform data from one form to
  another
* returns **CompletableFuture<T>** here T is the type of the result of the
  second CompletableFuture.
* The resulting CompletableFuture is a flattened chain.

**compose()** --> sequencing dependent asynchronous tasks,**thenCombine()** --> combine the results of two independent asynchronous tasks
into a single result
{: .notice--primary}

### join() - Blocking Until Completion

**Ensuring All Steps Complete:**
The CompletableFuture operations you chain (e.g., thenApply, exceptionally,
thenAccept, thenRun) will execute asynchronously.

If the main thread exits before these operations complete, you won’t see their
output.
`join()` ensures that the main thread waits for the entire chain of operations
to finish.

* to obtain the result of the asynchronous computation when it's done.
* similar to the `get()` method, but doesn't throw checked exceptions.
* waits indefinitely for the computation to finish
    * returns the result
    * or throws any unhandled exception if one occurs.

```java
CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 100);
int result = future.join(); // Get the result when the computation is complete
//Blocks the main thread until the supplyAsync is done
```

### get() & getNow() INSTEAD use thenAccept()

get() is a blocking call; The best thing to do with GET is to for**GET**.
INSTEAD use thenAccept()

* like join(), the get() method is also used to obtain the result of the
  asynchronous computation when it's done.
* Unlike join(), the get() method can throw checked exceptions, specifically
  `InterruptedException` and
  `ExecutionException`, which need to be handled.
* use get() if there is a need to explicit handling for interruptions and want
  to differentiate between exceptions and interruptions.
* if it's so important to use get, **use getNow()** with a default value

- getNow() is impatient non-blocking and moves on with a value if there is no
  immediate response
- If there is delay prior to getNow call then the getNow may return the correct
  value.

```java
CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 100);
try {
    int result = future.get(); // Get the result and handle exceptions
    int data = future.getNow(-99.0);//need to provide a value if the value is absent
    future.thenAccept(data -> getPrintln(data));
} catch (InterruptedException e) {
    System.out.println("Thread was interrupted");
    Thread.currentThread().interrupt(); // Preserve interruption status
  } catch (ExecutionException e) {
    System.out.println("Caught exception: " + e.getCause()); // Print actual cause
  }
```

### TimeOut - 2 functions

##### completeOnTimeout

if the CompletableFuture doesn't complete within the specified timeout, it will
be completed with the provided default
value.

```java
private static void successOnTimeOut(CompletableFuture<Integer> future) {
  future.completeOnTimeout(5, 1, TimeUnit.SECONDS);//Does not keep the pipeline in PENDING state
        // for more than a second. the value doesn't arrive in 1 sec (timeout) then resolve it, via the default value
}
```

##### orTimeout

If the CompletableFuture times out, it is canceled, and the resulting
CompletableFuture is considered completed
exceptionally with a TimeoutException.

* it can interrupt the underlying task if it takes too long to complete.

```java
private static void failureOnTimeOut(CompletableFuture<Integer> future) {
    future.orTimeout(1, TimeUnit.SECONDS);//Does not keep the pipeline in PENDING state
    //for more than a second. the value doesn't arrive in 1 sec (timeout) then cancel it, and completes it exceptionally with a TimeoutException
}
```

### allOf()

**Note** :: `allOf(..)` does not "wait" for all tasks to complete. It simply
returns a CompletableFuture

{% gist nitinkc/ffb3f165b3b58072acd750b78c0a2644 %}

### whenComplete()

whenComplete doesn’t allow for transformation of the result.
it is primarily used for handling completion and any associated exceptions.
{% gist nitinkc/3648ba0dd28d87fb5c4c13d4a77742e4 %}

### anyOf()

Returns the first one succeeded.

```java
CompletableFuture
        .anyOf(future1, future2, future3, future4)
        .thenAccept(result -> {
            System.out.println("Handling Accept :: " + result);
        })
        .exceptionally(throwable -> {
            System.out.println("Handling Failure :: " + throwable);
            return null;
        })
        .join();
```

### completedFuture()

**Purpose**: This method creates a CompletableFuture that is already completed
with the specified value.

**Usage**: It is used when you have a result that is already available and want
to wrap it in a CompletableFuture without additional asynchronous computation.

**Behavior**: The resulting CompletableFuture is instantly completed with the
given value, meaning that any operations on this CompletableFuture will execute
immediately (or as soon as possible).

# Streams API vs Async API

| Functional Interface | Method         | Streams API | Async API     |
|:---------------------|:---------------|:------------|:--------------|
| Predicate &lt;T>     | boolean test() | filter()    |               |
| Function<T,R>        | R apply(T k)   | map()       | thenApply()   |
| Consumer&lt;T>       | void accept(T) | forEach()   | thenAccept()  |
| Supplier&lt;T>       | T get()        | Factories   | supplyAsync() |

# Streams vs CompletableFuture

| Streams                  | CompletableFuture                       | 
|:-------------------------|:----------------------------------------|  
| Zreo, one or more data   | zero or one                             |
| only data channel        | data channel or error channel           |
| pipeline & lazy          | pipeline & lazy                         |
| Exception - nope         | error channel                           |
| forEach                  | thenAccept (consumes data)              |
| map                      | thenApply - perform transformation      |
| ((( zip )))              | thenCombine                             |
| flatMap (returns Stream) | thenCompose (returns CompletableFuture) |
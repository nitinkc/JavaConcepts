---
title: Structured Concurrency
date: 2024-07-20 20:17:00
categories:
- Multithreading
tags:
- Java
- Java 21
---

{% include toc title="Index" %}

Java 21 Virtual Threads and Structured Concurrency

# Scenario

When there are multiple independent tasks to be completed, and one of the tasks
fail, there should be
some mechanism to let others know that it has failed
and let others also fail-fast (instead of waiting for the other tasks to finish)

# Interrupts and Thread Cancellation

`void interrupt()`

- Interrupts a thread by setting its interrupted flag.

`static boolean interrupted()`

- Checks and clears the interrupted status of the current thread.

`boolean isInterrupted()`
Effect: Checks the interrupted status of the specified thread **without**
clearing it.

# Expected features

**Cooperative Interruption**: Threads should check their interrupted status
periodically to respond appropriately to interruption requests.

**Handling Interruption**: Proper handling of interruptions improves application
responsiveness and thread management.

- Interrupter must call `interrupt()` to set the flag (its own)
- Interrupted thread
    - may choose to ignore the interrupt
    - check interrupted status periodically (polling)
    - `wait()`, `sleep()`, `join()` will check status automatically
        - throws `InterruptedException()`
        - clears the interrupted status flag
    - Cancel using `cancel(true)`

# Futures - Class build on top of Threads.

```java
Future<TaskResponse> taskFuture = excecutor.submit(callable);
taskFuture.cancel(true);
```

# Structured Task

- StructuredTaskScope
- Subtask

following examples are based on the list of tasks

```java
var tasks = List.of(new BlockingIOTasks("Price-1", 3, true), 
        new BlockingIOTasks("Price-2", 10,true));
```

### StructuredTaskScope

Shuts down when **all child** threads complete

```java
try(var scope = new StructuredTaskScope<TaskResponse>()){
    // Start running the tasks in parallel
    List<Subtask<TaskResponse>> subtasks = tasks.stream().map(task -> scope.fork(task)).toList();
    
    // Wait for all tasks to complete (success or not)
    scope.join();
    
    subtasks.stream().forEach(subTask -> {
        // Handle Child Task Results (might have succeeded or failed)
        State taskState = subTask.state();
        if (taskState == State.SUCCESS)
            System.out.println(subTask.get());
        else if (taskState == State.FAILED)
            System.out.println(subTask.exception());
    });
}
```

### StructuredTaskScope.ShutdownOnSuccess

Shuts down when the first child thread **succeeds**

```java
try(var scope = new StructuredTaskScope.ShutdownOnSuccess<TaskResponse>()) {
    // Start running the tasks in parallel 
    List<Subtask<TaskResponse>> list = tasks.stream().map(task -> scope.fork(task)).toList();

    // Wait till first Child Task Succeeds. Send Cancellation to all other Child Tasks
    scope.join();
    
    // Handle Successful Child Task
    TaskResponse result = scope.result();
}
```

### StructuredTaskScope.ShutdownOnFailure()

Shuts down when **the first** child thread fails

```java 
try(var scope = new StructuredTaskScope.ShutdownOnFailure()){
    // Start running the tasks in parallel
    List<Subtask<TaskResponse>> subtasks = tasks.stream().map(task -> scope.fork(task)).toList();

    / 
    scope.throwIfFailed();// Wait till first Child Task fails. Send cancellation to all other Child Tasks
    
    // Handle Success Child Task Results
    subtasks.forEach(System.out::println);
}
```

### Custom

extend `StructuredTaskScope` and implement the `handleComplete()` method.

# handle parallel tasks using CompletionService

```java
try (var service = Executors.newVirtualThreadPerTaskExecutor()) {
    CompletionService<TaskResponse> completionService = new ExecutorCompletionService<TaskResponse>(service);

    List<Future<TaskResponse>> taskFutures 
        = tasks.stream().map(completionService::submit).toList();

    try {
        for(int j = 0; j < taskFutures.size() ; j++) {
            completionService.take().get();
        }
    } catch (Exception e) {
        // request that the threads terminate. Do not wait for the threads to terminate
        for (var taskFuture : taskFutures) {
            taskFuture.cancel(true);
        }
        throw e;
    }
    
    // All tasks are successful at this point
    List<TaskResponse> result 
        = taskFutures.stream().map(Future::resultNow).toList();
    
    return result;
} // makes sure that all threads are fully terminated
```
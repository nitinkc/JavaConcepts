---
title: Thread-local storage (TLS) in multithreading
date: 2024-07-26 20:17:00
categories:
- Multithreading
tags:
- Java
- Concurrency
---

{% include toc title="Index" %}

Each thread has its own **instance of a map** that stores **thread-local variables**.

This map holds the associations between the thread-local variables and their corresponding values,
ensuring that the variables are unique to the thread and are not shared across other threads.

This allows threads to maintain 
- isolated states, 
- preventing race conditions and
- ensuring data consistency within each thread.

```java
public static ThreadLocal<Student> studentThreadLocal = new ThreadLocal<Student>();
```

`studentThreadLocal` has the global scope, but the value inside the
studentThreadLocal has the scope **only for the duration of a thread**

```java
//Sets the current thread's value
studentThreadLocal.set(new Student("Harry Potter"));

//gets the current thread's value'
studentThreadLocal.get();
```

# Inheritable ThreadLocal

`InheritableThreadLocal` is a subclass of `ThreadLocal`. It allows child threads
to inherit the values of the parent thread.

- By Default child thread values are identical to Parent Thread.

When a child thread gets created the the local values of parent get copied over
to the child in 2 ways

- Default copy is shallow copy (pointer to the original is saved with the child)
    - If the child thread sets a new value, parent thread will see the updated
      value

```java
// InheritableThreadLocal variable
private static final InheritableThreadLocal<String> threadLocalValue = new InheritableThreadLocal<>();
```
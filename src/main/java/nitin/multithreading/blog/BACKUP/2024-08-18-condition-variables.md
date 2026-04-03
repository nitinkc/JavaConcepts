---
title: Condition Variables
date: 2024-08-18 05:17:00
categories:
- Multithreading
tags:
- Java
- Synchronization
- Concurrency
---

{% include toc title="Index" %}

# Condition Variables

Semaphore as particular example of condition variable `Is number of Permits > 0`

- if condition is not met, thread-1 goes to sleep until another thread changes
  the semaphore's state.

Condition variable is always associated with a lock.
Lock ensures **atomic** check and modification of the shared variables involved
in the condition.

```java
Lock lock  = new ReentrantLock();
Condition condition = lock.newCondition();
```

Example signalling

```java
Lock lock  = new ReentrantLock();
Condition condition = lock.newCondition();
//Shared resources
String username = null, password = null;
```

`await()` unlocks the lock, wait until signal or some time

```java
lock.lock();
try{
    while(username == null || password == null)
        //condition.await();
        condition.await(1, TimeUnit.SECONDS);
} finally {
    lock.unlock();
}
performTask();
```

`signal()` wakes up a single thread, waiting on the condition variable

```java
lock.lock();
try{
    username = getUserFromUiTextBox();
    password = getPasswordFromUiTextBox();
    condition.signal();
}finally(){
    lock.unlock();
}
```
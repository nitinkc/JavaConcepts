---
title: Reentrant Lock
date: 2024-08-18 05:17:00
categories:
- Multithreading
tags:
- Java
- Concurrency
---

{% include toc title="Index" %}

# ReentrantLock

Works same as `synchronized` keyword applied to an object

- but requires explicit locking and unlocking
    - prone to errors if forget to unlock, or if there is an exception after
      locking and before unlocking

**SOLUTION** : always lock in the try block and unlock in the finally block

- this pattern also helps when you want to unlock after `return` statement

##### Reentrancy

The same thread can acquire the read or write lock multiple times without
causing a deadlock.

- For example, if a thread already holds the write lock, it can acquire it again
  without blocking.

##### Fairness

By default, it uses a non-fair policy where thread scheduling is not guaranteed
to follow any specific order.

- However, a fair version can be used where threads are granted locks in the
  order they requested them, which can help prevent thread starvation.

```java
Lock lock = new ReentrantLock();
public int task() {
    lock.lock();
    try {
      // Critical section
      return doTask();//returns an integer
    } finally {//Guaranteed to execute
        lock.unlock();//with return statements, this is the only way to unlock 
    }
}
```

With this extra complexity we have more control over lock & get more Lock
operations

#### Queries

- `int getQueueLength()` : Returns an estimate of the number of threads waiting
  to acquire the lock.
- `Thread getOwner()` : Returns the thread currently holding the lock, or null
  if no thread holds the lock.
- `boolean isHeldByCurrentThread()` : Returns true if the current thread holds
  the lock.
- `boolean isLocked()` : Returns true if the lock is currently held by any
  thread.

By default,
both `synchronized` keyword and `ReentrantLock()` **does not** provide a
fairness guarantee.

- But, `ReentrantLock(true)` can be used to enforce fairness
- may affect the throughput as maintaining fairness comes with a cost.

### LockInterruptibly

- Useful with Watchdog for deadlock detection and recovery
- Waking up threads to do cleanup

```java
try{
    //lock.lock();
    lock.lockInterruptibly();
        ...
} catch(InterruptedException){
    if(Thread.currentThread().isInterrupted()){
        doCleanUp&Exit();
    }
}
```

### lock() and tryLock()

- never blocks
- Attempts to acquire the lock immediately.
- If the lock is available, it is acquired and the method returns true.
- If the lock is not available, it returns false immediately **without blocking
  ** or waiting.

**Use Cases**

- tryLock(): When immediate feedback is needed without waiting. eg Video/Image
  processing, Trading systems, UI Applications
- tryLock(long time, TimeUnit unit): When waiting for a limited time is
  acceptable and you want to handle lock acquisition with a timeout.

Regular lock

```java
lock.lock();//sleeps when the lock is not free
try{
   // Critical section
} finally() {
    lock.unlock();
}
```

##### Summary

```java
ReentrantLock lock = new ReentrantLock();
public void update(int key, int value) {
  lock.lock();
  try {
    writeToDatabase(key, value); //slow
  } finally {
    lock.unlock();
  }
}

public int read(int key) {
  lock.lock();
  try {
    return readFromDatabase(key); //slow
  } finally {
    lock.unlock();
  }
}
```

for `ReentrantLock lock = new ReentrantLock();`

- Only **one thread** can execute `writeToDatabase(key, value)` as The lock
  protects the critical section from concurrent access
- Only **one thread** can execute `readFromDatabase(key)` since it's guarded by
  a lock

# ReentrantReadWriteLock

`Synchronized` and `ReentrantLock` do not allow **multiple readers** to access a
shared resource concurrently

But when read operations are predominant or when read operations aren’t fast due
to

- read from many variables
- read from complex data structure

Under these circumstances, mutual exclusion negatively impacts performance.

ReentrantReadWriteLock solves this problem.

```java
ReadWriteLock lock = new ReentrantReadWriteLock();
Lock readLock = lock.readLock();
Lock writeLock = lock.writeLock();
```

#### Read Lock

**Multiple threads can hold the read lock** simultaneously as long as no thread
holds the write lock.

- This is useful for scenarios where multiple threads need to read data
  concurrently without modifying it.

```java
ReadWriteLock lock = new ReentrantReadWriteLock();
Lock readLock = lock.readLock();
public int read(int key) {
  readLock.lock();
  try {
    return readFromDatabase(key); //slow
  } finally {
    readLock.unlock();
  }
}
```

#### Write Lock:

Only one thread can hold the write lock at a time, and no other threads (either
read or write) can acquire the lock.

- This ensures exclusive access to the resource for modifications.

```java
ReadWriteLock lock = new ReentrantReadWriteLock();
Lock writeLock = lock.writeLock();
public void update(int key, int value) {
  writeLock.lock();
  try {
    writeToDatabase(key, value); //slow
  } finally {
    writeLock.unlock();
  }
}
```

### Summary

```java
ReadWriteLock lock = new ReentrantReadWriteLock();
Lock readLock = lock.readLock();
Lock writeLock = lock.writeLock();

public void update(int key, int value) {
  writeLock.lock();
  try {
     writeToDatabase(key, value); //slow
  } finally {
     writeLock.unlock();
  }
 }

public int read(int key) {
  readLock.lock();
  try {
     return readFromDatabase(key); //slow
  } finally {
     readLock.unlock();
  }
}
```

for `ReadWriteLock lock = new ReentrantReadWriteLock();`

- `writeToDatabase(key, value);` method is guarded by a write lock, and only one
  thread can acquire a write lock at a time
- `readFromDatabase(key);` is guarded by a read lock. Many threads can acquire
  that lock as long as no other thread is holding the write lock
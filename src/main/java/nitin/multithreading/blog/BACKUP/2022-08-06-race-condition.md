---
title: Synchronization - Race Condition & Critical Section
date: 2022-08-06 08:30:00
categories:
- Multithreading
tags:
- Java
- Synchronization
---

{% include toc title="Index" %}

**What are Shared Resources?**

- Variables (Class level, static etc)
- Data structures (Objects)
- File or Connection handles
- Message queues or Work Queues
- Any Other Object

Heap Memory is shared.
Stack is created for each thread, so the variables on the Stack aren’t shared.

> Concurrent systems -> different threads **communicate** with each other <br>
> Distributed Systems -> different processes **communicate**.

Reentrant Locks and Semaphores are introduced in Java 1.5

* Reentrant Locks (Mutex) allows only one thread in a critical section.
* Semaphore allows a fixed number of threads to access a critical section.

# Atomic Operation

**All-or-Nothing**: The operation either completes fully or doesn’t start at
all.

**Indivisibility**: No other operations can interleave or interrupt the atomic
operation.

In the given example, `counter++` or `counter--` are **not atomic operation** as
it involves 3 steps

- **Read** - Fetch the current value of counter from memory.
- **Temp Write** - Increment the fetched value by 1.
- **Assignment** - Store the incremented value back into counter.
  ```java
  private int counter;
  public void increment() {
      counter++;
  }
  
  public void decrement() {
      counter--;
  }
  ```

If two threads execute `counter++` simultaneously, they could both fetch the
same
initial value of counter, increment it, and then store the same new value,
resulting in one increment instead of two.

This is a **race condition**.

# Critical Section

Critical Sections are parts of code that access shared resources and must be
protected to prevent concurrent access issues.

- **Synchronized** Methods and Synchronized Blocks (with lock object) ensure
  that only one thread can access a critical section at a time.
- **ReentrantLocks** offer more control and flexibility compared to synchronized
  blocks.
- **Concurrent Collections** are thread-safe and can simplify handling shared
  data without manual synchronization.
    - **Examples**: ConcurrentHashMap, CopyOnWriteArrayList, BlockingQueue

# Race Condition

- Multiple threads accessing shared resources
- At least one thread is modifying the shared resources
- The timing of thread scheduling may cause incorrect results
- the core of the problem is **non-atomic operations** performed on the shared
  resource

**Non-Atomic operation** - A single Java operation(eg. count++) turns into two
or more hardware operation

- fetch current value of count
- perform count+1
- reassign back to count

### Interleaved Execution with a shared resource.

**Both thread incrementing with NO COMMUNICATION**

```mermaid!
sequenceDiagram
    participant T1 as Thread 1
    participant SR as Shared Resource<br/> count
    participant T2 as Thread 2

    SR ->> T1: Read count (0)
    SR ->> T2: Read count (0)
    
    T1--x T1: Increment count to 1
    T1->>SR: Write count (1)
    T2--x T2: Increment count to 1
    T2->>SR: OverWrite count (1)
```

**One thread incrementing, one decrementing**

```mermaid!
sequenceDiagram
    participant T1 as Thread 1 <br/> count++ #blue
    participant SR as Shared Resource<br/> count
    participant T2 as Thread 2 <br/> count-- #green

    SR->>T1: Read count (0)
    SR->>T2: Read count (0)
    T1->>T1: Increment count to 1
    T1->>SR: Write count (1)
    T2->>T2: Decrement count to -1
    T2->>SR: Write count (-1)
```

### Race Condition Solution

**Ensuring Atomicity**

Identify and protect the critical section

- Using synchronized keyword
    - on the method - monitor
    - using synchronized block - more granularity & flexibility but verbose
- Using AtomicInteger

```java
//Run by increment thread
public synchronized void increment() {
    count++;
}
//Run by decrement thread
public synchronized void decrement() {
    count--;
}
```

- When thread1 is executing `increment();` thread2 can’t execute `decrement();`
- And when thread2 is executing `decrement();`thread1 can’t execute
  `increment();`

That is because both methods are synchronized, and belong to the same object (
counter).

# Data Race

Is `x` strictly greater than `y`?

```java
private int x = 0, y = 0;
public void increment() {
    x++;//Does this always run before y++? 
    y++;
}
// Check for the above hypothesis
public void checkForDataRace() {
    if (y > x) 
        System.out.println("y > x - Data Race is detected");
}
```

- One thread running `increment()` method in a loop
- One checker thread just to see if Data Race occurs.

### Code rearrangement

Compiler and CPU **may** execute the instruction **Out of order** (if the
instructions are independent) to optimize performance

- The logical correctness of the code is always maintained

[Java Compilation Optimization](https://nitinkc.github.io/java/compiler-code-optimization/)

**The compiler re-arranges the instructions for better**

- branch prediction (optimized loops, `if` statements etc.)
- Vectorization - parallel instruction execution (SIMD)
- Prefetching instructions - better cache performance

**The CPU rearranges the code for better**

- hardware units utilization

The following can't be rearranged as all instructions are interdependent

- `y` depends on `x` and `z` depends on `y`ß

```java
x = 1;
y = x * 2;
z = y + 1;
```

The following code may be arranged by the Compiler or CPU

- leading to unexpected, paradoxical, and incorrect results.

```java
x++; y++;
//OR
y++; x++;
```

### Data Race - Solution

Establish a `Happens-Before` semantics by

- synchronization of methods
    - solves both race and data condition but has a performance penalty
- [volatile shared variables](https://nitinkc.github.io/java/Volatile/)
    - solves race condition for read/write from long and double
    - solves all data races by guaranteeing order

##### Rule of thumb

Every shared variable (modified by at least one thread) should be either

- Guarded by a synchronized block (or any type of lock) OR
- declared volatile

# Locks

When we have multiple shared resources, we can use

- one lock for all the shared resources
    - **Coarse grain locking** - simplicity, but performance is not good.
    - lots of suspended threads
- individual lock for each resource
    - **Fine-grained locking** - more control, but can cause deadlocks
    - more programmatic control but prone to errors.

# Deadlocks

Problem when multiple locks are held.

For a deadlock to occur, all 4 conditions need to be met simultaneously.

| **Concept**                   | **Description**                                                                   |
|:------------------------------|:----------------------------------------------------------------------------------|
| **Mutual Exclusion**          | Only one thread can have exclusive access to a resource at a given moment.        |
| **Hold and Wait**             | At least one thread is holding a resource and is waiting for another resource.    |
| **Non-Preemptive Allocation** | A resource cannot be released until the thread using it is finished with it.      |
| **Circular Wait**             | A situation where one thread is holding resource A and waiting for resource B,  \ 
|                               | while another thread holds resource B and is waiting for resource A.              | 

The easiest solution to avoid deadlocks is to **break the Circular Wait
condition**.

Enforcing **strict order** on lock acquisition prevents deadlocks.
Lock resources in the same order everywhere
{: .notice--primary}

{% gist nitinkc/442baad95fd069a9ac1645db1f941d1b %}

### Deadlock detection

##### 1. Watchdog

In microcontrollers, this watchdog is implemented by a low level routine that
periodically
checks the status of a particular register.

That register needs to be updated by every thread, every few instructions, and
if the watchdog detects
that this register hasn't been updated, it knows that the threads aren’t
responsive and will simply
restart them in a similar way.

##### 2. Thread Interruption (not possible with synchronized)

##### 3. tryLock Operations (not possible with synchronized)

# ReentrantLock

[https://nitinkc.github.io/java/multithreading/reentrant-lock/](https://nitinkc.github.io/java/multithreading/reentrant-lock/)

# Semaphore

[https://nitinkc.github.io/java/multithreading/semaphores/](https://nitinkc.github.io/java/multithreading/semaphores/)

# Condition Variables

[https://nitinkc.github.io/java/multithreading/condition-variables/](https://nitinkc.github.io/java/multithreading/condition-variables/)

# Inter-thread Communications

basdkjsadnas

# Lock Free Algorithms

**What's wrong with Locks?**

- DEADLOCKS
- slow critical section (the one thread that holds the lock for long, the
  slowest thread determines the speed)
- Priority inversion when 2 threads share a lock, but the low-priority thread
  keeps getting scheduled
    - Low-priority thread acquires the lock and is preempted (schedule out)
    - High-priority thread can’t progress because the low-priority thread is not
      scheduled to release the lock.
- Thread not releasing the lock (Kill Tolerance)
    - Thread dies, gets interrupted, or forgets to release the lock
    - Leaves all other threads hanging forever
    - Unrecoverable, just like deadlocks
    - To avoid, need to write more complex error-prone code.
- Performance overhead in having contention over a lock
    - Thread A acquires a lock
    - Thread B tries and gets blocked
    - Thread B is scheduled out (context switch)
    - Later Thread B is scheduled back (another context switch)
    - overhead for latency-sensitive applications (stock market data)

## Lock free solutions

- uses operations guaranteed to be executed as a single hardware operation
- A single hardware operation
    - is Atomic by definition and thus
    - threadsafe

# Atomic Operations in Java

- Read & Assignment on all primitive types (except for long and double)
- Read & Assigment on all references
- Read & Assignment on all Volatile long and double

Java provides several mechanisms to achieve atomic operations:

1. **Atomic Variables** :
   The `java.util.concurrent.atomic` package provides classes that perform
   atomic operations on various types:

2. **Volatile Variables**
   The `volatile` keyword in Java ensures **visibility of changes** to variables
   across threads.
   However, it **does not guarantee** atomicity for operations on **long and
   double types**,
   which are 64-bit values and may require special handling.

3. **Synchronization**
   While not strictly atomic operations, synchronized blocks or methods provide
   mutual exclusion,
   ensuring that only one thread can execute a block of code at a time.
   This can be used to manage complex atomic operations that involve multiple
   steps.

## Avoid DataRaces

Make all shared variables that you want to read or write **Volatile**

- read/Assignment on all Volatile Primitive types and references

# Volatile

For primitive types other than long and double atomic operations are typically
managed using the volatile keyword or synchronization,

  ```java
  private volatile int counter;
  ```

Accessing or updating this counter will be atomic, but **only for reads and
writes**.
More complex operations like incrementing require additional synchronization.

# Atomic Classes in Java

Atomic classes in `java.util.concurrent.atomic` package

- internally uses the unsafe class which provides access to low level, native
  methods
- [Java Docs - java.util.concurrent.atomic](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/atomic/package-summary.html)

### AtomicInteger

**Atomic Classes for int**: The `java.util.concurrent.atomic` package provides
`AtomicInteger` for int:

```java
int initialValue = 0;
AtomicInteger atomicInteger = new AtomicInteger(initialValue);

public void increment() {
  //Increments by 1, 
  int previousValue = atomicInteger.getAndIncrement();//return the PREVIUOS value
  int updatedValue = atomicInteger.incrementAndGet();// return the NEW-VALUE
  //Similarly for decrement
}

public int getValue() {
  return atomicCounter.get(); // Atomic read
}

//addAndGet(delta), getAndAdd(delta) increments or decrements by delta(delta can be negative)
```

**Pros**

- Simplicity
- no synchronization or locks needed
- no race conditions or data races

**Cons**

- Only the operation itself is atomic
- There will still be race condition between 2 separate atomic operations
  ```java
  int initialValue = 0;
  AtomicInteger atomicInteger = new AtomicInteger(initialValue);
  
  int a = atomicInteger.incrementAndGet();
  int b = atomicInteger.addAndGet(-1); // SUBJECTED TO RACE CONDITION
  ```

**Summary**

AtomicInteger is a great tool for concurrent counting, without the complexity of
using a lock

AtomicInteger should be used only when atomic operations are needed.

- it's on par and sometimes more performant than regular integer with lock
  protection

### Atomic Operations on volatile long and volatile double

In Java, volatile

- **guarantees visibility and ordering** but
- does not guarantee atomicity for long and double types.

For these types, Java uses `AtomicLong` and `AtomicDouble` from the
`java.util.concurrent.atomic` package

- note that AtomicDouble is **not in the standard library** but is available in
  libraries like Google Guava.

- **AtomicLong**: Provides atomic operations for long values:
  ```java
import java.util.concurrent.atomic.AtomicLong;

private final AtomicLong atomicLong = new AtomicLong();

public void incrementLong() {
    atomicLong.incrementAndGet(); // Atomic increment
}

public long getLongValue() {
    return atomicLong.get(); // Atomic read
}
```

- **AtomicDouble**: Provided by libraries such as Google Guava:
  ```java
import com.google.common.util.concurrent.AtomicDouble;

private final AtomicDouble atomicDouble = new AtomicDouble();

public void setDouble(double newValue) {
    atomicDouble.set(newValue); // Atomic assignment
}

public double getDoubleValue() {
    return atomicDouble.get(); // Atomic read
}
```

# AtomicReference<T>

**AtomicReference Class**: Manages atomic operations on references. For example:

```java
import java.util.concurrent.atomic.AtomicReference;

private final AtomicReference<MyObject> atomicRef = new AtomicReference<>(new MyObject());

public void updateReference(MyObject newValue) {
    atomicRef.set(newValue); // Atomic assignment
}

public MyObject getReference() {
    return atomicRef.get(); // Atomic read
}
```

# Synchronization Mechanisms in Java

[Synchronization Mechanisms]({% post_url /java/threads/2024-08-17-synchronization-mechanism-java %})

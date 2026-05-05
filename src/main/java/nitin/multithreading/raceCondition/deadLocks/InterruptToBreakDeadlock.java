package nitin.multithreading.raceCondition.deadLocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Demonstrates how Thread.interrupt() can be used to break out of a deadlock situation.
 *
 * <h2>The Problem:</h2>
 *
 * With synchronized blocks or Lock.lock(), once a thread is blocked waiting for a lock, it CANNOT
 * be interrupted - it will wait forever (deadlock is permanent).
 *
 * <h2>The Solution:</h2>
 *
 * Use Lock.lockInterruptibly() which allows a blocked thread to respond to interrupts, enabling
 * deadlock recovery.
 *
 * <h2>Key Concepts:</h2>
 *
 * <ul>
 *   <li>synchronized - CANNOT be interrupted while waiting for lock
 *   <li>Lock.lock() - CANNOT be interrupted while waiting for lock
 *   <li>Lock.lockInterruptibly() - CAN be interrupted while waiting for lock
 *   <li>Lock.tryLock(timeout) - Returns after timeout if lock not acquired
 * </ul>
 *
 * <pre>
 * Deadlock Visualization:
 *
 *    Thread-1                    Thread-2
 *        │                           │
 *        ▼                           ▼
 *   ��─────────┐                 ┌─────────┐
 *   │ Holds A │                 │ Holds B │
 *   └─────────┘                 └─────────┘
 *        │                           │
 *        │  Wants B                  │  Wants A
 *        │  ┌─────┐                  │  ┌─────┐
 *        └─►│BLOCK│◄─────────────────┴─►│BLOCK│
 *           └─────┘                     └─────┘
 *              ▲                           ▲
 *              │                           │
 *              └───── DEADLOCK! ───────────┘
 *
 * With interrupt():
 *    Thread-1                    Thread-2
 *        │                           │
 *        ▼                           ▼
 *   ┌─────────┐                 ┌─────────┐
 *   │ Holds A │                 │ Holds B │
 *   └─────────┘                 └─────────┘
 *        │                           │
 *        │ lockInterruptibly(B)      │ lockInterruptibly(A)
 *        │  ┌───────────────────┐    │  ┌─────┐
 *        └─►│ BLOCKED (waiting) │    └─►│BLOCK│
 *           └───────────────────┘       └─────┘
 *                    │
 *                    ▼  ← interrupt() called!
 *           ┌───────────────────┐
 *           │ InterruptedException │
 *           │ Thread-1 releases A  │
 *           │ Thread-2 can proceed │
 *           └───────────────────────┘
 * </pre>
 */
public class InterruptToBreakDeadlock {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=".repeat(70));
        System.out.println("DEMO: Using interrupt() to break a Deadlock");
        System.out.println("=".repeat(70));

        BankAccount account1 = new BankAccount("Alice", 1000);
        BankAccount account2 = new BankAccount("Bob", 1000);

        // Transfer service that can deadlock
        TransferService service = new TransferService();

        // Thread 1: Transfer from Alice to Bob
        Thread t1 =
                new Thread(
                        () -> {
                            try {
                                service.transferWithInterruptibleLock(account1, account2, 100);
                            } catch (InterruptedException e) {
                                System.out.println(
                                        "⚠️  "
                                                + Thread.currentThread().getName()
                                                + " was INTERRUPTED while waiting for lock!");
                                System.out.println(
                                        "   → Releasing all held locks and backing off...");
                            }
                        },
                        "Transfer-AliceToBob");

        // Thread 2: Transfer from Bob to Alice (opposite direction = potential deadlock!)
        Thread t2 =
                new Thread(
                        () -> {
                            try {
                                service.transferWithInterruptibleLock(account2, account1, 200);
                            } catch (InterruptedException e) {
                                System.out.println(
                                        "⚠️  "
                                                + Thread.currentThread().getName()
                                                + " was INTERRUPTED while waiting for lock!");
                                System.out.println(
                                        "   → Releasing all held locks and backing off...");
                            }
                        },
                        "Transfer-BobToAlice");

        System.out.println("\n📍 Starting both transfer threads (deadlock likely)...\n");
        t1.start();
        t2.start();

        // Give threads time to potentially deadlock
        Thread.sleep(2000);

        // Check if threads are still alive (deadlocked)
        if (t1.isAlive() && t2.isAlive()) {
            System.out.println("\n🔴 DEADLOCK DETECTED! Both threads are stuck.");
            System.out.println("   Thread 1 state: " + t1.getState());
            System.out.println("   Thread 2 state: " + t2.getState());

            System.out.println("\n💡 Using interrupt() to break the deadlock...");
            System.out.println("   Interrupting Thread 1: " + t1.getName());

            // Interrupt one thread to break the deadlock
            t1.interrupt();

            // Wait for threads to finish
            t1.join(1000);
            t2.join(1000);

            System.out.println("\n✅ Deadlock broken! Threads finished:");
            System.out.println("   Thread 1 alive: " + t1.isAlive() + ", state: " + t1.getState());
            System.out.println("   Thread 2 alive: " + t2.isAlive() + ", state: " + t2.getState());
        } else {
            System.out.println("\n✅ No deadlock occurred (threads completed normally)");
        }

        System.out.println("\n" + "=".repeat(70));
        System.out.println("Final Balances:");
        System.out.println("  " + account1);
        System.out.println("  " + account2);
        System.out.println("=".repeat(70));

        // Demonstrate the difference between lock() and lockInterruptibly()
        System.out.println("\n\n");
        demonstrateLockVsLockInterruptibly();
    }

    /** Shows the key difference between lock() and lockInterruptibly() */
    private static void demonstrateLockVsLockInterruptibly() throws InterruptedException {
        System.out.println("=".repeat(70));
        System.out.println("COMPARISON: lock() vs lockInterruptibly()");
        System.out.println("=".repeat(70));

        Lock lock = new ReentrantLock();

        // Main thread holds the lock
        lock.lock();
        System.out.println("\n🔒 Main thread holds the lock\n");

        // --- Test 1: lock() ignores interrupt ---
        System.out.println("TEST 1: Using lock() - Thread CANNOT be interrupted while waiting");
        System.out.println("-".repeat(50));

        Thread t1 =
                new Thread(
                        () -> {
                            System.out.println("  [T1] Trying to acquire lock with lock()...");
                            lock.lock(); // Will block and IGNORE interrupts
                            try {
                                System.out.println("  [T1] Got the lock!");
                            } finally {
                                lock.unlock();
                            }
                        },
                        "Thread-lock()");

        t1.start();
        Thread.sleep(500);
        System.out.println("  [Main] Interrupting T1...");
        t1.interrupt();
        Thread.sleep(500);
        System.out.println("  [Main] T1 is still waiting (interrupt ignored): " + t1.getState());
        System.out.println("  [Main] T1 isInterrupted flag: " + t1.isInterrupted());

        // Release lock so T1 can proceed
        System.out.println("  [Main] Releasing lock...");
        lock.unlock();
        t1.join();
        System.out.println(
                "  [T1] Finally completed (interrupt flag was set but ignored during lock())");

        // Reacquire for next test
        lock.lock();

        // --- Test 2: lockInterruptibly() respects interrupt ---
        System.out.println("\n\nTEST 2: Using lockInterruptibly() - Thread CAN be interrupted");
        System.out.println("-".repeat(50));

        Thread t2 =
                new Thread(
                        () -> {
                            System.out.println(
                                    "  [T2] Trying to acquire lock with lockInterruptibly()...");
                            try {
                                lock.lockInterruptibly(); // Will block BUT can be interrupted!
                                try {
                                    System.out.println("  [T2] Got the lock!");
                                } finally {
                                    lock.unlock();
                                }
                            } catch (InterruptedException e) {
                                System.out.println(
                                        "  [T2] ⚡ Caught InterruptedException! Exiting gracefully.");
                            }
                        },
                        "Thread-lockInterruptibly()");

        t2.start();
        Thread.sleep(500);
        System.out.println("  [Main] Interrupting T2...");
        t2.interrupt();
        t2.join();
        System.out.println("  [T2] Completed immediately after interrupt!");

        lock.unlock();

        System.out.println("\n" + "=".repeat(70));
        System.out.println("SUMMARY:");
        System.out.println("  • lock()              → Ignores interrupts, waits indefinitely");
        System.out.println("  • lockInterruptibly() → Responds to interrupts, throws exception");
        System.out.println("  • tryLock(timeout)    → Returns false after timeout");
        System.out.println("=".repeat(70));
    }
}

/** Simple bank account with a ReentrantLock for thread-safe operations. */
class BankAccount {
    private final String owner;
    private int balance;
    private final Lock lock = new ReentrantLock();

    public BankAccount(String owner, int initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
    }

    public Lock getLock() {
        return lock;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return owner + "'s account: $" + balance;
    }
}

/** Transfer service that demonstrates deadlock and how to break it with interrupt(). */
class TransferService {

    /**
     * Transfer money using lockInterruptibly() - CAN be interrupted to break deadlock.
     *
     * <p>This method intentionally acquires locks in the order they're passed (from → to), which
     * can cause deadlock if two threads transfer in opposite directions.
     */
    public void transferWithInterruptibleLock(BankAccount from, BankAccount to, int amount)
            throws InterruptedException {

        String threadName = Thread.currentThread().getName();

        System.out.println(
                "🔄 "
                        + threadName
                        + ": Starting transfer $"
                        + amount
                        + " from "
                        + from.getOwner()
                        + " to "
                        + to.getOwner());

        // Acquire first lock
        System.out.println(
                "   " + threadName + ": Acquiring lock on " + from.getOwner() + "'s account...");
        from.getLock().lockInterruptibly();
        System.out.println(
                "   " + threadName + ": ✓ Got lock on " + from.getOwner() + "'s account");

        try {
            // Simulate some processing time (increases chance of deadlock)
            Thread.sleep(100);

            // Try to acquire second lock (THIS IS WHERE DEADLOCK OCCURS!)
            System.out.println(
                    "   " + threadName + ": Acquiring lock on " + to.getOwner() + "'s account...");
            to.getLock().lockInterruptibly(); // <-- Can be interrupted here!
            System.out.println(
                    "   " + threadName + ": ✓ Got lock on " + to.getOwner() + "'s account");

            try {
                // Perform the transfer
                from.withdraw(amount);
                to.deposit(amount);
                System.out.println("✅ " + threadName + ": Transfer complete!");
            } finally {
                to.getLock().unlock();
            }
        } finally {
            from.getLock().unlock();
            System.out.println(
                    "   " + threadName + ": Released lock on " + from.getOwner() + "'s account");
        }
    }

    /**
     * Alternative: Transfer using tryLock with timeout - another way to avoid permanent deadlock.
     */
    public boolean transferWithTryLock(BankAccount from, BankAccount to, int amount)
            throws InterruptedException {

        String threadName = Thread.currentThread().getName();
        long startTime = System.currentTimeMillis();
        long timeout = 1000; // 1 second timeout

        while (true) {
            if (from.getLock().tryLock()) {
                try {
                    if (to.getLock().tryLock()) {
                        try {
                            from.withdraw(amount);
                            to.deposit(amount);
                            System.out.println(
                                    "✅ " + threadName + ": Transfer complete with tryLock!");
                            return true;
                        } finally {
                            to.getLock().unlock();
                        }
                    }
                } finally {
                    from.getLock().unlock();
                }
            }

            // Check if we've timed out
            if (System.currentTimeMillis() - startTime > timeout) {
                System.out.println("⏱️ " + threadName + ": Transfer timed out, will retry later");
                return false;
            }

            // Back off and retry
            Thread.sleep(50 + (long) (Math.random() * 50));
        }
    }
}

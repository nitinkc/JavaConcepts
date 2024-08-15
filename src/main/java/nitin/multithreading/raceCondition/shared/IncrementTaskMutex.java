package nitin.multithreading.raceCondition.shared;

import java.util.concurrent.locks.Lock;

public class IncrementTaskMutex implements Runnable {
    private final SharedCounter sharedCounter;
    private final Lock lock;

    public IncrementTaskMutex(SharedCounter sharedCounter, Lock lock) {
        this.sharedCounter = sharedCounter;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            lock.lock(); // Acquire the lock
            sharedCounter.increment();
        } finally {
            lock.unlock(); // Release the lock
        }
    }
}

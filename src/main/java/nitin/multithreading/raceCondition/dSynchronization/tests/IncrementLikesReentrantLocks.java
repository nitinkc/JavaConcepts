package nitin.multithreading.raceCondition.dSynchronization.tests;

import java.util.concurrent.locks.ReentrantLock;

public class IncrementLikesReentrantLocks extends IncrementLikes {
    private final ReentrantLock mutex = new ReentrantLock();

    private final Integer likeBigDecimal = super.getCurrentLikesCount();

    @Override
    public Integer incrementLikes() {
        try {
            mutex.lock();
            return super.incrementLikes();
        } finally {
            mutex.unlock();
        }
    }
}

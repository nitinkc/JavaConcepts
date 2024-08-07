package nitin.multithreading.shared.tests;

import java.math.BigDecimal;
import java.util.concurrent.locks.ReentrantLock;

public class IncrementLikesReentrantLocks extends IncrementLikes {
    private final ReentrantLock mutex = new ReentrantLock();

    private final BigDecimal likeBigDecimal = super.getNextLikeCountBigDecimal();

    @Override
    public BigDecimal incrementLikeBigInt() {
        try {
            mutex.lock();
            return super.incrementLikeBigInt();
        } finally {
            mutex.unlock();
        }
    }
}

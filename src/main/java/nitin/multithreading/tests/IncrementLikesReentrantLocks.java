package nitin.multithreading.tests;

import java.math.BigDecimal;
import java.util.concurrent.locks.ReentrantLock;

public class IncrementLikesReentrantLocks extends IncrementLikes{
    private ReentrantLock mutex = new ReentrantLock();

    private BigDecimal likeBigDecimal = super.getNextLikeCountBigDecimal();

    @Override
    public BigDecimal incrementLikeBigInt(){
        try{
            mutex.lock();
            return super.incrementLikeBigInt();
        }finally {
            mutex.unlock();
        }
    }
}

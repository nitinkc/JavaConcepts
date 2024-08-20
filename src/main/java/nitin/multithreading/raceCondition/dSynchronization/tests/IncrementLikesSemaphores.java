package nitin.multithreading.raceCondition.dSynchronization.tests;

import java.util.concurrent.Semaphore;

public class IncrementLikesSemaphores extends IncrementLikes {
    private final Semaphore semaphore = new Semaphore(1);//1 thread means it behaves as mutex.

    private final Integer likeBigDecimal = super.getCurrentLikesCount();

    @Override
    public Integer incrementLikes() {
        try {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return super.incrementLikes();
        } finally {
            semaphore.release();
        }
    }
}

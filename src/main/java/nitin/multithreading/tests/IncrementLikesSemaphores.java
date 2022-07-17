package nitin.multithreading.tests;

import java.math.BigDecimal;
import java.util.concurrent.Semaphore;

public class IncrementLikesSemaphores extends IncrementLikes{
        private Semaphore semaphore = new Semaphore(1);//1 thread means it behaves as mutex.

        private BigDecimal likeBigDecimal = super.getNextLikeCountBigDecimal();

        @Override
        public BigDecimal incrementLikeBigInt() {
            try{
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return super.incrementLikeBigInt();
            }finally {
                semaphore.release();
            }
        }
}

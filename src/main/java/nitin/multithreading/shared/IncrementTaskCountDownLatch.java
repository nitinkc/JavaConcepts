package nitin.multithreading.shared;


import java.util.concurrent.CountDownLatch;

public class IncrementTaskCountDownLatch implements Runnable {
    private final SharedCounter sharedCounter;
    private final CountDownLatch latch;

    public IncrementTaskCountDownLatch(SharedCounter sharedCounter, CountDownLatch latch) {
        this.sharedCounter = sharedCounter;
        this.latch = latch;
    }

    @Override
    public void run() {
        sharedCounter.increment();
        latch.countDown();
    }
}
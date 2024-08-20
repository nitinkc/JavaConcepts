package nitin.multithreading.raceCondition.dSynchronization;

import java.util.concurrent.CountDownLatch;

import static com.utilities.MultiThreadUtility.logMessage;

public class Processor implements Runnable {
    private final CountDownLatch latch;

    Processor(CountDownLatch latch) {
        this.latch = latch;
    }


    @Override
    public void run() {
        logMessage("Started.");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logMessage(String.valueOf(latch.getCount()));
        latch.countDown();
    }
}

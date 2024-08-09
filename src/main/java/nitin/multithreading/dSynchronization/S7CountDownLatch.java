package nitin.multithreading.dSynchronization;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Nitin Chaurasia on 12/5/15 at 10:39 PM.
 * <p>
 * Demonstrating
 */
public class S7CountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        final int THREADS = 50;
        CountDownLatch latch = new CountDownLatch(THREADS);
        Processor p = new Processor(latch);
        Thread[] t = new Thread[THREADS];

        for (int i = 0; i < THREADS; i++) {
            t[i] = new Thread(p);
            t[i].start();
        }

        //Wait for all the threads to finish
        System.out.println("Before Await...");
        latch.await();
        System.out.println("After Await");
        System.out.println(p.getClass());
    }
}

class Processor implements Runnable {
    private final CountDownLatch latch;

    Processor(CountDownLatch latch) {
        this.latch = latch;
    }


    @Override
    public void run() {
        System.out.println("Started.");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(latch.getCount());
        latch.countDown();
    }
}
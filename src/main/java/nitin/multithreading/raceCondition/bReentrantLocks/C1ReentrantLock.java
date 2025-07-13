package nitin.multithreading.raceCondition.bReentrantLocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** Created by Nitin C on 12/5/2015. */
public class C1ReentrantLock {
    public static void main(String[] args) {
        RLock r = new RLock();

        // Three threads competiting for the same a5object
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);

        t1.start();
        t2.start();
        t3.start();

        System.out.println(t1.getState());
    }
}

class RLock implements Runnable {

    // From java.util.concurrent.locks
    Lock l = new ReentrantLock();

    @Override
    public void run() {
        l.tryLock();
        System.out.println("Locked by: " + Thread.currentThread());

        // After Locking make it sleep, so that other threads can get chance
        try {
            Thread.sleep(2000);
            System.out.println("Waiting with thread: " + Thread.currentThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        l.unlock();
    }
}

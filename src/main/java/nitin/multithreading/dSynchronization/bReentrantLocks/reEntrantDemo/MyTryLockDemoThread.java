package nitin.multithreading.dSynchronization.bReentrantLocks.reEntrantDemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by nitin.chaurasia on 12/26/2016.
 */
public class MyTryLockDemoThread extends Thread {

    static ReentrantLock l = new ReentrantLock();

    //Constructor
    MyTryLockDemoThread(String name) {
        super(name);
    }

    public void run() {
        if (l.tryLock()) {
            System.out.println(Thread.currentThread().getName() + "... got Lock and performing Safe Operations");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                //Swallowing Exception
            }
            l.unlock();
        } else {
            System.out.println(Thread.currentThread().getName() + "....unable to get lock and hence performinng alternative operations");
        }
    }
}

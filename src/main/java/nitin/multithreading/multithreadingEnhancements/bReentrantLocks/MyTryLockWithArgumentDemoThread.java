package nitin.multithreading.multithreadingEnhancements.bReentrantLocks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by nitin.chaurasia on 12/26/2016.
 */
public class MyTryLockWithArgumentDemoThread extends Thread {

    static ReentrantLock l = new ReentrantLock();

    //Constructor
    MyTryLockWithArgumentDemoThread(String name) {
        super(name);
    }

    public void run() {
        do {
            try {
                if (l.tryLock(3000, TimeUnit.MILLISECONDS)) {//will try for lock every 3 seconds
                    System.out.println(Thread.currentThread().getName() + "... got Lock and performing Safe Operations");
                    try {
                        Thread.sleep(30000);
                    } catch (InterruptedException e) {
                        //Swallowing Exception
                    }
                    l.unlock();

                    System.out.println(Thread.currentThread().getName() + " ... Released Lock");
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName() + "....unable to get lock and hence performinng alternative operations");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (true);
    }
}

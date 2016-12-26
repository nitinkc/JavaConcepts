package com.nitin.multithreadingEnhancements.bReentrantLocks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by nitin.chaurasia on 12/26/2016.
 */
public class Display {

    ReentrantLock l = new ReentrantLock();

    public void wishReentrantLocked(String name) {

        l.lock();
        for (int i = 0; i < 10; i++) {
            System.out.print("Good Morning : ");
            try {
                Thread.sleep(2000);//wait for two secs
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name);
        }
        l.unlock();
    }

    //With the use of synchronized, we are forcing the other thread to wait
    public synchronized void wishSynchronized(String name) {
        for (int i = 0; i < 10; i++) {
            System.out.print("Good Morning : ");
            try {
                Thread.sleep(2000);//wait for two secs
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name);
        }
    }
}

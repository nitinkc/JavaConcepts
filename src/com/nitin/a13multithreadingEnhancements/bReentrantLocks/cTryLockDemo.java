package com.nitin.a13multithreadingEnhancements.bReentrantLocks;

/**
 * Created by nitin.chaurasia on 12/26/2016.
 */
public class cTryLockDemo {
    public static void main(String[] args) {
        MyTryLockDemoThread t1 = new MyTryLockDemoThread("Dhoni");
        MyTryLockDemoThread t2 = new MyTryLockDemoThread("Yuvi");

        t1.start(); t2.start();
    }

}

package com.nitin.a13multithreadingEnhancements.bReentrantLocks;

/**
 * Created by nitin.chaurasia on 12/26/2016.
 *
 * Second thread will continue to pull if the Lock is available or not
 */
public class dTryLockArgumentDemo {
    public static void main(String[] args) {
        MyTryLockWithArgumentDemoThread t1 = new MyTryLockWithArgumentDemoThread("Dhoni");
        MyTryLockWithArgumentDemoThread t2 = new MyTryLockWithArgumentDemoThread("Yuvi");

        t1.start(); t2.start();
    }
}

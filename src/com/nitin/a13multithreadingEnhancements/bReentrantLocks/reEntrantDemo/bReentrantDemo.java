package com.nitin.a13multithreadingEnhancements.bReentrantLocks.reEntrantDemo;

/**
 * Created by nitin.chaurasia on 12/26/2016.
 */
public class bReentrantDemo {
    public static void main(String[] args) {
        Display d = new Display();

        MyReentrantDemoThread t1 = new MyReentrantDemoThread(d,"Dhoni");
        MyReentrantDemoThread t2 = new MyReentrantDemoThread(d, "Yuvraj");
        MyReentrantDemoThread t3 = new MyReentrantDemoThread(d, "Kohli");
        t1.start(); t2.start(); t3.start();
    }
}

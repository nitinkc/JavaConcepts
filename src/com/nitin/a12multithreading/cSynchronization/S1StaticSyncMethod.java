package com.nitin.a12multithreading.cSynchronization;

/**
 * Created by Nitin Chaurasia on 12/6/15 at 7:03 PM.
 */
public class S1StaticSyncMethod {
    public static void main(String[] args) {
        Display d1 = new Display();

        // Concurrency happens when a same Object is being acted upon
        Thread t1 = new MyThread(d1, "Nitin");
        Thread t2 = new MyThread(d1, "Sindhu");

//        t1.start();
//        t2.start();

        caseStudy1();
    }

    /**
     * WHENEVER MULTIPLE THREADS ARE OPERATING ON SAME OBJECT, THEN ONLY SYNCHRONIZATION
     * PLAYS A ROLE. IF THERE ARE TWO DIFFERENT OBJECTS ACCESSED MY TWO DIFFERENT THREADS
     * THSRE IS NO ROLE OF SYNCHRONIZATION.
     */
    private static void caseStudy1() {
        Display1 d1 = new Display1();
        Display1 d2 = new Display1();

        MyThread1 t1 = new MyThread1(d1, "CS1");
        MyThread1 t2 = new MyThread1(d2, "CS2");

        // Evwn though the threads are operating on two different objects,
        // Regular outputs because the threads are calling static sync
        t1.start();
        t2.start();
    }
}

class Display1 {

    /**
     * The Static Sync method puts a class level lock.
     * When a thread executes a static Sync method then remaining threads are not allowed to
     * execute ANY static Sync Methodof that class simultaneously.
     *
     * BUT remaining threads can execute following methods
     * 1. normal static
     * 2. nornal instance
     * 3. synchronized instance
      */

    public static synchronized void wish(String name) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.print("Hello - " + i);
            Thread.sleep(500);
            System.out.println(" - " + name);
        }
    }
}

class MyThread1 extends Thread {
    Display1 d;
    String name;

    // Constructor
    MyThread1(Display1 d, String name) {
        this.d = d;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            d.wish(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.nitin.multithreading.aBasics;

/**
 * Created by Nitin Chaurasia on 12/5/15 at 10:01 PM.
 */
public class T7AnonymousThreadCall {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("From Thread: "+ Thread.currentThread() + " "+i);
                }
            }
        });

        t1.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("From Main: "+ Thread.currentThread() + " "+i);
        }

    }

}

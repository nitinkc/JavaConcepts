package com.nitin.multithreading.aBasics;

import com.nitin.multithreading.ThreadByRunnable;

/**
 * Created by Nitin Chaurasia on 12/2/15 at 10:30 PM.
 *
 * This Method is Preferred to DEFINE N1PathFileTest THREAD
 *
 * We can extend other class while Implementing Runnable Interface
 */
public class T4ThreadByRunnable {
    public static void main(String[] args) {
        ThreadByRunnable tr = new ThreadByRunnable();

        // Target Runnable
        Thread t = new Thread(tr);

        t.start();

        //Normal Execution of main
        for (int i = 0; i < 100; i++) {
            System.out.println("From Main: " + i);
        }
    }
}

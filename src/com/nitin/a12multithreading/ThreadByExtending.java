package com.nitin.a12multithreading;

/**
 * Created by Nitin Chaurasia on 12/2/15 at 11:53 PM.
 */
public class ThreadByExtending extends Thread{


    // Thread Scheduler Decides which thread runs First
    // Undeterministic Response
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Child Thread: " + i);
        }
    }
}

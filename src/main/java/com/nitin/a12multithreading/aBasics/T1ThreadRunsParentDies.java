package com.nitin.a12multithreading.aBasics;

/**
 * Created by Nitin Chaurasia on 11/30/15 at 10:22 PM.
 *
 * Demonstration that a Child Thread continues even if there is an exception in the Main Thread
 */
public class T1ThreadRunsParentDies extends Thread {// by overriding run method
    static final int MAX = 500;

    @Override
    public void run(){
        int count = 1;

        for (int i = 1; i <= MAX; i++) {
            System.out.print(Thread.currentThread());
            System.out.println(" : Child Thread execution : " + i);
        }
    }

    public static void main(String[] args) {
        //Starting the Thread
        new T1ThreadRunsParentDies().start();

        //Deliberately putting and exception so that main stops
        int test = 10/0;
        // Runtime Stack will be destroyed as there is no exception handling code

        for (int i = 1; i <= MAX; i++) {
            System.out.println("Main Thread execution" + i);
        }

    }

}

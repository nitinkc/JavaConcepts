package com.nitin.Multithreading;

/**
 * Created by Nitin Chaurasia on 11/30/15 at 10:22 PM.
 *
 * Demonstration that Thread continues if there is an ecxception in main
 */
public class T1ThreadRunsParentDies extends Thread {
    static final int MAX = 5;

    public void run(){
        int count = 1;

        for (int i = 1; i <= MAX; i++) {
            System.out.println("Thread execution" + i);
        }
    }

    public static void main(String[] args) {
        //Starting the Thread
        new T1ThreadRunsParentDies().start();

        //Deliberately putting and exception do that main stops
        int test = 10/0;
        // Runtime Stack will be destroyed as there is no exception handling code

        for (int i = 1; i <= MAX; i++) {
            System.out.println("Main execution" + i);
        }

    }

}

package com.nitin.multithreading.bExecutionPrevention;

/**
 * Created by Nitin Chaurasia on 12/3/15 at 12:57 AM.
 *
 * A Thread Can Interrupt another Sleeping or Waiting Thread
 */
public class T3InterruptDemo {
    public static void main(String[] args) {
        ThreadInterruot tr = new ThreadInterruot();
        Thread t = new Thread(tr);

        t.start();

        // No impact if target thread is in NOT in sleeping or Waiting state
        t.interrupt();

        //Normal Main Execution
        for (int i = 0; i < 100; i++) {
            System.out.println("Main: " + i);
        }
    }
}

class ThreadInterruot implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Lazy Child: " + i);
            try {
                Thread.sleep(100);
            }catch(InterruptedException e){
                System.out.println("I am Interrupted");
                e.printStackTrace();
            }
        }
    }
}
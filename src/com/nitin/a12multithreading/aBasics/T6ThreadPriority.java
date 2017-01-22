package com.nitin.a12multithreading.aBasics;

import com.nitin.a12multithreading.ThreadByRunnable;

/**
 * Created by Nitin Chaurasia on 12/2/15 at 11:03 PM.
 */
public class T6ThreadPriority {
    /** Default Priority for main is 5.
     *
     * All Child Threads inheriting from the parent has same priority
     * With Same Priority, un-deterministic order
     * Priority Varies from 1 to 10 (10 being the most)
     * */

    public static void main(String[] args) {

        ThreadByRunnable tpd = new ThreadByRunnable();
        Thread t = new Thread(tpd);

        /* Setting the Priority higher than main (default 5) will take care of
         Executing the child first.

         BUT After child starts executing, Main may also execute
        */
        // Child has more Priority than Parent
        //t.setPriority(6);

        t.setPriority(1);// ?? UNKNOWN BEHAVIOUR
        t.start();

        // Normal Main execution
        for (int i = 0; i < 1000; i++) {
            System.out.println("From Main: " + i);
        }
    }
}

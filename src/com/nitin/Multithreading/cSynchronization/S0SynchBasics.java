package com.nitin.multithreading.cSynchronization;

/**
 * Created by Nitin Chaurasia on 12/6/15 at 6:14 PM.
 *
 * Synchronize acquire Locks on the Object and not on the method. Thus If one Lock is acquired by
 * t1 for method m1, no other threads is allowed to execute even the non-sync method m3.
 */
public class S0SynchBasics {

}

class Basics implements Runnable{
    public synchronized void m1(){
        System.out.println("From M1...");
    }

    public synchronized void m2(){
        System.out.println("From M2...");
    }

    public void m3(){
        System.out.println("From M3...");
    }

    @Override
    public void run() {

    }
}

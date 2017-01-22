package com.nitin.a12multithreading.aBasics;

/**
 * Created by Nitin Chaurasia on 12/2/15 at 10:08 PM.
 *
 *
 */
public class T3OverridingStart {
    public static void main(String[] args) {
        MyThread t = new MyThread();

        // start is overridden thus it will execute like a normal method. No a12multithreading
        t.start();
    }
}
     class MyThread extends Thread{

        @Override
        // OverRiding start will make it execute like a normal method
        public void start(){
            System.out.println("OverRiding Start");
        }

        @Override
        public void run(){
            System.out.println("run Method");
        }
    }

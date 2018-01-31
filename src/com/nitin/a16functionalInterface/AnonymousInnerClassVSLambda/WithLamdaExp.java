package com.nitin.a16functionalInterface.AnonymousInnerClassVSLambda;

import com.nitin.a12multithreading.ThreadByExtending;

/**
 * Created by Nitin Chaurasia on 1/30/18 at 5:08 PM.
 */
public class WithLamdaExp {
    public static void main(String[] args) {

        //Lambda Expression
//        Runnable r = () -> {
//            for (int i = 0; i < 5; i++) {
//                System.out.println("Child Thread");
//            }
//        };
//
//        Thread t = new Thread(r);// instead of passing r, pass the lambda directly

        //Passing Lambda as Argument
        Thread t = new Thread( () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Child Thread");
            }
        });
        t.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("Main Thread");
        }
    }
}

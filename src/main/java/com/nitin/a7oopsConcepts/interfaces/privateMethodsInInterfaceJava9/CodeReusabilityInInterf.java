package com.nitin.a7oopsConcepts.interfaces.privateMethodsInInterfaceJava9;

/**
 * Created by Nitin Chaurasia on 1/31/18 at 9:24 PM.
 */
public class CodeReusabilityInInterf implements Interf{
    public static void main(String[] args) {
        CodeReusabilityInInterf t = new CodeReusabilityInInterf();
        t.m1();
        t.m2();
    }
}

interface Interf{
    default void m1(){
        System.out.println("From m1");
        m3();
    }

    default void m2(){
        System.out.println("From m2");
        m3();
    }

    private void m3(){
        System.out.println("m3 for code reusability");
    }

}
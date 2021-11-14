package com.a10interfaces.StaticMethodsInsideInterfacesFromJava8;

/**
 * Created by Nitin Chaurasia on 1/31/18 at 9:24 PM.
 */
public class CodeReusabilityInInterf implements Interf1 {
    public static void main(String[] args) {

        // Static methods can only be called from Interface
        Interf1.m1();
        Interf1.m2();
    }
}

interface Interf1{
    static void m1(){
        System.out.println("From m1");
       // m3();
    }

    static void m2(){
        System.out.println("From m2");
       // m3();
    }

    //private methods
    // java: private interface methods are not supported in -source 8
    /*private static void m3(){
        System.out.println("m3 for code reusability");
    }*/

    default void m4(){
        System.out.println("m4 Default method");
    }

}
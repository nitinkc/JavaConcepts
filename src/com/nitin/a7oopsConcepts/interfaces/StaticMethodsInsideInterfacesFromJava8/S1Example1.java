package com.nitin.a7oopsConcepts.interfaces.StaticMethodsInsideInterfacesFromJava8;

/**
 * Created by Nitin Chaurasia on 1/30/18 at 5:30 PM.
 */
public class S1Example1 {
    public static void main(String[] args) {
        Interf.m1();


    }
}

interface Interf{
    public static void m1(){
        System.out.println("Static method as a utility method in an interface");
    }
}

package com.nitin.a10interfaces.StaticMethodsInsideInterfacesFromJava8;

/**
 * Created by Nitin Chaurasia on 1/30/18 at 5:30 PM.
 */
public class S1Example1 implements Interf{
    public static void main(String[] args) {

        // the only way to call Interface static method is via the interface name.
        Interf.m1();

        //INVALID : via object reference now allowed
        S1Example1 s = new S1Example1();
        //s.m1();
        //Not available to Implementation class
       //S1Example1.m1();

    }
}

interface Interf{
    static void m1(){
        System.out.println("Static method as a utility method in an interface");
    }


    // Static methods are allowed, this method could be run directly from command prompt
    static void main(){
        System.out.println("MAin method from Interface Interf");
    }
}

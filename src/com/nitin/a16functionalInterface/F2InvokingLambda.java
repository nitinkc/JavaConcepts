package com.nitin.a16functionalInterface;

/**
 * Created by Nitin Chaurasia on 1/30/18 at 3:51 PM.
 */
public class F2InvokingLambda {
    public static void main(String[] args) {

        InvokingLambda i = () -> System.out.println("Invoking Lambda from functional interface");
        i.m1();

    }
}

// functional interface even though not annotated
interface InvokingLambda{
    public void m1();
}

package com.nitin.a16functionalInterface;

/**
 * Created by Nitin Chaurasia on 1/30/18 at 4:38 PM.
 */
public class F4InvokingLambdaReturn {
    public static void main(String[] args) {

        //Since there is only one abstract method in the functional interface, type mapping is easy forthe compiler
        InterfWithReturnMethod i = x -> x*x;
        System.out.println(i.squareIt(4));

        System.out.println(i.squareIt(18));
    }
}

interface InterfWithReturnMethod{
    public int squareIt(int a);
}

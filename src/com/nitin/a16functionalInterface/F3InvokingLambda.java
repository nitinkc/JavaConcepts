package com.nitin.a16functionalInterface;

/**
 * Created by Nitin Chaurasia on 1/30/18 at 4:08 PM.
 */
public class F3InvokingLambda {
    public static void main(String[] args) {
        Interf i = (x,y) -> System.out.println("sum : " + (x+y));
        i.add(23,7);
        i.add(76, 8);

        // takes like string
        Interf i2 = (c,d) -> System.out.println("sum : " +c+d);
        i2.add(23,7);
        i2.add(76, 8);
    }
}

interface Interf{
    public void add(int a, int b);
}

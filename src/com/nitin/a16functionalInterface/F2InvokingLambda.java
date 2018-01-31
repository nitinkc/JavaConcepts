package com.nitin.a16functionalInterface;

/**
 * Created by Nitin Chaurasia on 1/30/18 at 3:51 PM.
 */
public class F2InvokingLambda {
    public static void main(String[] args) {

        InvokingLambda i = () -> System.out.println("Invoking Lambda from functional interface");
        i.m1();


        Interf i1 = (x,y) -> System.out.println("sum : " + (x+y));
        i1.add(23,7);
        i1.add(76, 8);

        // takes like string
        Interf i2 = (c,d) -> System.out.println("sum : " +c+d);
        i2.add(23,7);
        i2.add(76, 8);

    }
}

// functional interface even though not annotated
interface InvokingLambda{
    public void m1();
}

@FunctionalInterface
interface Interf{
    public void add(int a, int b);
}

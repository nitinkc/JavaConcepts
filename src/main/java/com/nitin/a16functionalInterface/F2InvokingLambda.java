package com.nitin.a16functionalInterface;

/**
 * Created by Nitin Chaurasia on 1/30/18 at 3:51 PM.
 */
public class F2InvokingLambda {
    public static void main(String[] args) {
        InvokingLambda i = () -> System.out.println("Invoking Lambda from functional interface");
        i.m1();

        InterfaceForLambda i1 = (x,y) -> String.valueOf(x+y);
        System.out.println(i1.doSomething(23,7));
        System.out.println(i1.doSomething(76, 8));

        // takes like string
        InterfaceForLambda i2 = (c,d) -> String.valueOf(c*d);
        System.out.println(i2.doSomething(3,7));
        System.out.println(i2.doSomething(5, 8));
    }
}

// functional interface even though not annotated
interface InvokingLambda{
    public void m1();
}

@FunctionalInterface
interface InterfaceForLambda{
    public String doSomething(int a, int b);
}

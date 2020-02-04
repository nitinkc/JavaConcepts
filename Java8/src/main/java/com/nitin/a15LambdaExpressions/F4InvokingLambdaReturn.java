package com.nitin.a15LambdaExpressions;

/**
 * Created by Nitin Chaurasia on 1/30/18 at 4:38 PM.
 */
public class F4InvokingLambdaReturn {
    public static void main(String[] args) {

        //Since there is only one abstract method in the functional interface,
        // type mapping is easy for the compiler
        InterfaceWithReturnMethod i = x -> x*x;
        System.out.println(i.squareIt(4));
        System.out.println(i.squareIt(18));

        InterfaceForLambda i1 = (x,y) -> String.valueOf(x+y);
        System.out.println(i1.doSomething(23,7));
        System.out.println(i1.doSomething(76, 8));

        // takes like string
        InterfaceForLambda i2 = (c,d) -> String.valueOf(c*d);
        System.out.println(i2.doSomething(3,7));
        System.out.println(i2.doSomething(5, 8));
    }
}

interface InterfaceWithReturnMethod {
    public abstract int squareIt(int a);
}

@FunctionalInterface
interface InterfaceForLambda{
    public abstract String doSomething(int a, int b);
}

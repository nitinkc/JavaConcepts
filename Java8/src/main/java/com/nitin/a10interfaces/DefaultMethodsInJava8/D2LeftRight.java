package com.nitin.a10interfaces.DefaultMethodsInJava8;

/**
 * Created by Nitin Chaurasia on 1/31/18 at 5:50 PM.
 */

//CE : inherits unrelated defaults for m1() from types Left and DefaultMethodsInJava8.Right
public class D2LeftRight implements Left,Right{//Compulsory give implementation

    public static void main(String[] args) {
        D2LeftRight d = new D2LeftRight();
        d.m1();
    }

    //Without this method override, CE will be there.
    @Override
    public void m1(){
        Left.super.m1();
        Right.super.m1();
        System.out.println("Over ridden");
    }
}

// Two interfaces by the same default methods being implemented in the same implementation class
interface Left{
    default void m1(){
        System.out.println("Left");
    }
}

interface Right{
    default void m1(){
        System.out.println("Right");
    }
}
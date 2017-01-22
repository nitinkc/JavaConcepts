package com.nitin.a6exceptionHandling;

/**
 * Created by Nitin C on 11/27/2015.
 */
public class E1DivideByZero {
    public static void main(String[] args) {
        int x = 0;
        try{
            x = 5/0;
            //x = 10/5;
        } catch(ArithmeticException e){
            System.out.println(e);
        } finally {
            // Will always execute irrespective on the exception or not
            System.out.println("Alwaya happen");
        }


        System.out.println(x);
    }
}

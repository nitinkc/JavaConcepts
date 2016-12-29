package com.nitin.a7exceptionHandling;

/**
 * Created by Nitin C on 11/27/2015.
 */
public class E4ThrowException {


    public static void main(String[] args) {
        try {
            //Compiler forces to handle the "throw new exception"
            throw new Exception();// Checked exception
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Exception after this line will not happen

        System.out.println("AFTER TRY-CATCH");
    }
}

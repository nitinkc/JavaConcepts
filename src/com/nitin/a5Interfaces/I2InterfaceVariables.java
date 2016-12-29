package com.nitin.a5Interfaces;

/**
 * Created by nitin on 12/29/16.
 */
public class I2InterfaceVariables implements Left,Right {
    public static void main(String[] args) {
        // System.out.println(x);// Error: reference to x is ambiguous

        // Resolve Naming Conflict
        System.out.println(Left.x);
        System.out.println(Right.x);


    }
}

interface Left{
    int x = 222;
}

interface Right{
    int x = 666;
}
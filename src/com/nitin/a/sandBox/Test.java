package com.nitin.a.sandBox;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        System.out.println(power(3,3));
    }

    public static int power(int x, int k) {
        if (k < 0)
            throw new IllegalArgumentException();

        if (k == 0)
            return 1;

        return x*power(x,k-1);
    }
}
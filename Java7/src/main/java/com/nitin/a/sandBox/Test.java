package com.nitin.a.sandBox;

public class Test {
    public static void main(String[] args) {
        int start = 5;
        int end = 10;
        int[] result = new int[end-start];

        for(int i = 0; i< (end-start); i++){
            result[i] = start++;
            System.out.println(result[i]);
        }

    }
}

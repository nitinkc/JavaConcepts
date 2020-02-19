package com.nitin.myFunctionalInterface;

/**
 * Created by nitin on Tuesday, February/18/2020 at 11:14 PM
 */
public class ConverterRunner {
    public static void main(String[] args) {

        final Convertor<Integer, Float> Celcius2Fheight = x -> x * (9f / 5) + 32;


    }
}

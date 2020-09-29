package com.nitin.zJava8Revisions.myFunctionalInterface;

/**
 * Created by nitin on Tuesday, February/18/2020 at 11:14 PM
 */
public class ConverterRunner {
    public static void main(String[] args) {

        //final Convertor<Integer, Float> Celcius2Fheight = x -> x * (9f / 5) + 32;

        // Using Anonymous Class
        final Convertor<Integer, Float> celcius2Fheight = new Convertor<Integer, Float>() {
            @Override
            public Float convert(Integer x) {
                return x * (9f / 5) + 32;
            }
        };

        celcius2Fheight.convert(23);
    }
}

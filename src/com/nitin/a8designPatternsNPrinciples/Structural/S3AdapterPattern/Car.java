package com.nitin.a8designPatternsNPrinciples.Structural.S3AdapterPattern;

/**
 * Created by nitin.chaurasia on 2/19/2017.
 */
public class Car implements Vehicle {
    @Override
    public void accelerate() {
        System.out.println("Car Accelerate...");
    }
}

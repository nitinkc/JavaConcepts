package com.nitin.a8designPatternsNPrinciples.Structural.S3AdapterPattern;

/**
 * Created by nitin.chaurasia on 2/19/2017.
 */
public class BicycleAdapter implements Vehicle {

    private Bicycle bicycle;

    public BicycleAdapter(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    @Override
    public void accelerate() {
        this.bicycle.go();
    }
}

package com.nitin.a8designPatternsNPrinciples.Structural.S3AdapterPattern;

/**
 * Created by nitin.chaurasia on 2/19/2017.
 *
 * Adapter Interface - Converts an interface of a class into an other interface the client expect
 *
 * It enables classes working together, that could not otherwise, because of incompatible interfaces
 *
 * Composition is very important !!! Favour Composition over inheritance
 */
public class App {
    public static void main(String[] args) {


        Vehicle bus = new Bus();
        Vehicle car = new Car();
        Vehicle bicycle = new BicycleAdapter(new Bicycle());

        bus.accelerate();
        car.accelerate();
        bicycle.accelerate();

    }
}

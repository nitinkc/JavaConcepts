package com.nitin.a15java8.lambda.functionaInterfaceWithLambda;

/**
 * Created by Nitin Chaurasia on 5/9/16 at 10:45 PM.
 */
public class Animal {
    private String species;
    private boolean canHop;
    private boolean canSwim;

    public Animal(String species, boolean canHop, boolean canSwim){
        this.species = species;
        this.canHop = canHop;
        this.canSwim = canSwim;
    }

    // Getters for the encapsulated variables

    @Override
    public String toString() {
        return species;
    }

    public boolean isCanHop() {
        return canHop;
    }

    public boolean isCanSwim() {
        return canSwim;
    }
}

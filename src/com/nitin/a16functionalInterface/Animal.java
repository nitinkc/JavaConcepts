package com.nitin.a16functionalInterface;

/**
 * Created by Nitin Chaurasia on 3/3/16 at 12:18 AM.
 */
public class Animal {
    private String species;
    private boolean canHop;
    private boolean canSwim;

    public Animal(String species, boolean canHop, boolean canSwim) {
        this.species = species;
        this.canHop = canHop;
        this.canSwim = canSwim;
    }

    public boolean isCanHop() {
        return canHop;
    }

    public boolean isCanSwim() {
        return canSwim;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                '}';
    }
}

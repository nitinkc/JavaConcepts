package com.nitin.a8designPatternsNPrinciples.Structural.S4FlyWeightPattern;

import java.util.HashMap;

/**
 * Created by nitin.chaurasia on 3/4/2017.
 */
public class CoffeeFactory {
    private HashMap<String, Coffee> flavors = new HashMap<String, Coffee>();

    public Coffee getCoffeeFlavor(String flavorName) {
        Coffee flavor = flavors.get(flavorName);
        if (flavor == null) {
            flavor = new Coffee(flavorName);
            flavors.put(flavorName, flavor);
        }
        return flavor;
    }

    public int getTotalCoffeeFlavorsMade() {
        return flavors.size();
    }
}

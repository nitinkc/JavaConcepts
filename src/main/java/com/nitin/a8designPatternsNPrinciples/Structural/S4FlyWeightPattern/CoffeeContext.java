package com.nitin.a8designPatternsNPrinciples.Structural.S4FlyWeightPattern;

/**
 * Created by nitin.chaurasia on 3/4/2017.
 */
public class CoffeeContext {
    private final int tableNumber;

    public CoffeeContext(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getTable() {
        return this.tableNumber;
    }
}

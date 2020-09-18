package com.nitin.zRevisionsSep2020.f0functionalFoundation.r4CommandPatternSelection;

public class GasLevelCarCriterion implements CarCriteria{

    private int threshold;

    public GasLevelCarCriterion(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean test(Car car) {
        return car.getGasLevel() >= threshold;
    }
}

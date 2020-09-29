package com.nitin.zOReiley2020SimonRoberts.f1functionalFoundation.r4CommandPatternSelection;

public class RedCarCriterion implements CarCriteria{
    @Override
    public boolean test(Car car) {
        return car.getColor().equals("Red");
    }
}

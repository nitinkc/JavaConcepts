package com.nitin.zRevisionsSep2020.f0functionalFoundation.r4CommandPatternSelection;

import com.nitin.zRevisionsSep2020.f0functionalFoundation.r4CommandPatternSelection.CarCriteria;

public class RedCarCriterion implements CarCriteria{
    @Override
    public boolean test(Car car) {
        return car.getColor().equals("Red");
    }
}

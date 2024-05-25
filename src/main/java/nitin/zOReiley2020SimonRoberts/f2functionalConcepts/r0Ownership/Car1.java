package nitin.zOReiley2020SimonRoberts.f2functionalConcepts.r0Ownership;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Car1 {
    //Fields of Class Car
    private final int gasLevel;
    private final String color;
    private final List<String> passengers;
    private final List<String> trunkContents;

    // there is a functional programming style that we will be using which will lead us to using factory methods
    private Car1(int gasLevel, String color, List<String> passengers, List<String> trunkContents) {
        this.gasLevel = gasLevel;
        this.color = color;
        this.passengers = passengers;
        this.trunkContents = trunkContents;
    }

    //STATIC FACTORY
    static Car1 withGasColorPassengers(int gas, String color, String... passengers) {
        List<String> p = Collections.unmodifiableList(Arrays.asList(passengers));
        Car1 self = new Car1(gas, color, p, null);
        return self;
    }

    static Car1 withGasColorPassengersAndTrunk(int gas, String color, String... passengers) {
        List<String> p = Collections.unmodifiableList(Arrays.asList(passengers));

        Car1 self = new Car1(gas, color, p, Arrays.asList("jack", "wrench", "spare wheel"));
        return self;
    }

    public int getGasLevel() {
        return gasLevel;
    }

    public Car1 addGas(int g) {
        return new Car1(gasLevel + g, color, passengers, trunkContents);
    }

    public String getColor() {
        return color;
    }

    public List<String> getPassengers() {
        return passengers;
    }

    public List<String> getTrunkContents() {
        return trunkContents;
    }

    //This could return null; DELIBERATELY WRITTEN FOR DEMO
    public List<String> getTrunkContentsOpt() {
        return (trunkContents);
    }

    @Override
    public String toString() {
        return "Car{" + "gasLevel=" + gasLevel + ", color=" + color + ", passengers=" + passengers
                + (trunkContents != null ? ", trunkContents=" + trunkContents : " no trunk") + '}';
    }

    /*********************************************************************************************************************
     * *******************************************************************************************************************
     * *******************************************************************************************************************
     ********************************************************************************************************************/

    //Static inner class shares the same behaviour with all the instances. Static members vs instance members ->
    // the criteria is shared wil all the objects
    static class GasLevelCarCriterion implements CarCriteria1 {
        private final int threshold;

        public GasLevelCarCriterion(int threshold) {
            this.threshold = threshold;
        }

        @Override
        public boolean test(Car1 car) {
            return car.getGasLevel() >= threshold;
        }
    }

    static class RedCarCriterion implements CarCriteria1 {
        @Override
        public boolean test(Car1 car) {
            return car.getColor().equals("Red");
        }
    }
}

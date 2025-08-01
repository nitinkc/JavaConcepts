package nitin.zOReiley2020SimonRoberts.f3closures.s5replaceCriteria2Predicate;

import java.util.*;
import java.util.function.Predicate;

class Car {
    // Fields of Class Car
    private final int gasLevel;
    private final String color;
    private final List<String> passengers;
    private final List<String> trunkContents;
    public String getColor;

    // there is a functional programming style that we will be using which will lead us to using
    // factory methods
    private Car(int gasLevel, String color, List<String> passengers, List<String> trunkContents) {
        this.gasLevel = gasLevel;
        this.color = color;
        this.passengers = passengers;
        this.trunkContents = trunkContents;
    }

    // STATIC FACTORY
    static Car withGasColorPassengers(int gas, String color, String... passengers) {
        List<String> p = Collections.unmodifiableList(Arrays.asList(passengers));
        Car self = new Car(gas, color, p, null);
        return self;
    }

    static Car withGasColorPassengersAndTrunk(int gas, String color, String... passengers) {
        List<String> p = Collections.unmodifiableList(Arrays.asList(passengers));

        Car self = new Car(gas, color, p, Arrays.asList("jack", "wrench", "spare wheel"));
        return self;
    }

    /*********************************************************************************************************************
     * *******************************************************************************************************************
     * *******************************************************************************************************************
     ********************************************************************************************************************/

    public static Predicate<Car> getFourPassengerCriterion() {
        // Return type of the Lambda is carCriteria1
        return car -> car.getPassengers().size() == 4;
    }

    public static Predicate<Car> getGasLevelCarCriteria(int threshold) {
        return car1 -> car1.getGasLevel() >= threshold;
    }

    // Factory method to return a criteria of Car based on multiple car color
    public static Predicate<Car> getColorCriteria(String... colors) {
        Set<String> colorSet = new HashSet<>(Arrays.asList(colors));
        return c -> colorSet.contains(c.color);
    }

    public int getGasLevel() {
        return gasLevel;
    }

    public Car addGas(int g) {
        return new Car(gasLevel + g, color, passengers, trunkContents);
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

    // This could return null; DELIBERATELY WRITTEN FOR DEMO
    public List<String> getTrunkContentsOpt() {
        return (trunkContents);
    }

    @Override
    public String toString() {
        return "Car{"
                + "gasLevel="
                + gasLevel
                + ", color="
                + color
                + ", passengers="
                + passengers
                + (trunkContents != null ? ", trunkContents=" + trunkContents : " no trunk")
                + '}';
    }
}

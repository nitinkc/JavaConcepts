package java8.zOReiley2020SimonRoberts.f2functionalConcepts.r5genericsNgeneralization;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Car1 {
  //Fields of Class Car
  private final int gasLevel;
  private final String color;
  private final List<String> passengers;
  private final List<String> trunkContents;
  public String getColor;

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
  // Expression Lambda
  private static final Criteria<Car1> RED_CAR_CRITERION = c ->  c.getColor().equals("Red");

  // return a lambda expression directly from a function call
  public static Criteria<Car1> getFourPassengerCriterion(){
    // Return type of the Lambda is carCriteria1
    return car -> car.getPassengers().size() == 4;
  }

  public static Criteria<Car1> getRedCarCriterion(){
    return RED_CAR_CRITERION; //This is Singleton design pattern.
    //return new RedCarCriterion();
  }

  // Factory for creating GasLevelCarCriterion
  public static Criteria<Car1> getGasLevelCarCriterion(int threshold){
    return new GasLevelCarCriterion(threshold);
  }

  private static class GasLevelCarCriterion implements Criteria<Car1> {
    private int threshold;
    public GasLevelCarCriterion(int threshold) {
      this.threshold = threshold;
    }

    @Override
    public boolean test(Car1 car) {
      return car.getGasLevel() >= threshold;
    }
  }
}
package java8.zOReiley2020SimonRoberts.f2functionalConcepts.r2VisibilityNAnonymity;

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


  //Using Anonymous Class
/*  private static final RedCarCriterion RED_CAR_CRITERION = new *//*RedCarCriterion();

  static class RedCarCriterion implements *//*CarRunner1.CarCriteria1 {
    @Override
    public boolean test(Car1 car) {
      return car.getColor().equals("Red");
    }
  }*/


  private static final CarCriteria1 RED_CAR_CRITERION = new CarCriteria1() {
  @Override
  public boolean test(Car1 car) {
    return car.getColor().equals("Red");
  }
};

  //Factory method : Much better than the constructor approach
  //Here getRedCarCriterion has a choice of implementing the new object or the single static object
  //public static RedCarCriterion getRedCarCriterion(){
  public static CarCriteria1 getRedCarCriterion(){
    return RED_CAR_CRITERION; //This is Singleton design pattern.
    //return new RedCarCriterion();
  }

  /*  Not Singleton as there is amn argument, threshold, that is unique to each object.*/
  public static CarCriteria1 getGasLevelCarCriterion(int threshold){
    return new GasLevelCarCriterion(threshold);
  }

  //Static inner class shares the same behaviour with all the instances. Static members vs instance members ->
  // the criteria is shared wil all the objects
  private static class GasLevelCarCriterion implements CarCriteria1 {
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

package java8.zOReiley2020SimonRoberts.f3closures.s1SingleArgument;

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

  // Factory for creating GasLevelCarCriterion using anonymous inner class. Variable is shared between lambda.
  // Its effectively final. Can be used, but cannot be modified
  public static Criteria<Car1> getGasLevelCarCriterion(int threshold){

    //threshold = threshold + 1;//Variable 'threshold' is accessed from within inner class, needs to be final or effectively final
    return new Criteria<Car1>(){
      @Override
      public boolean test(Car1 car1) {
        return car1.getGasLevel() >= threshold;
      }
    };
  }

  public static Criteria<Car1> getGasLevelCarCriterionLambda(int threshold){
        return car1 ->  car1.getGasLevel() >= threshold;
  }

  /*private static class GasLevelCarCriterion implements Criteria<Car1> {
    private int threshold;
    public GasLevelCarCriterion(int threshold) {
      this.threshold = threshold;
    }

    @Override
    public boolean test(Car1 car) {
      return car.getGasLevel() >= threshold;
    }
  }*/
}
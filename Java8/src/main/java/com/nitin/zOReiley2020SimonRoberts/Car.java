package com.nitin.zOReiley2020SimonRoberts;

import java.util.*;
import java.util.function.Predicate;

public class Car {

  //Fields of Class Car
  private final int gasLevel;
  private final String color;
  private final List<String> passengers;
  private final List<String> trunkContents;

  // there is a functional programming style that we will be using which will lead us to using factory methods
  private Car(int gasLevel, String color, List<String> passengers, List<String> trunkContents) {
    this.gasLevel = gasLevel;
    this.color = color;
    this.passengers = passengers;
    this.trunkContents = trunkContents;
  }

  //STATIC FACTORY
  // using a named static factory for this, able to convey the meaning of the arguments.
  //It's interesting to note that with the release of Java 8, virtually all of the new APIs made exclusive use of static
  // factories instead of having public constructors, with the exception of Exceptions.
  public static Car withGasColorPassengers(int gas, String color, String... passengers) {

    // And one of the things that functional programming likes to do is to use immutable data whenever possible.
    //t's generally considered to be preferable to create a new version of something rather than to change an existing something
    List<String> p = Collections.unmodifiableList(Arrays.asList(passengers));
    Car self = new Car(gas, color, p, null);
    return self;
  }

  //Notice the list of arguments. This would not have been possible with public constructors as this would not
  // have been a valid overload
  public static Car withGasColorPassengersAndTrunk(int gas, String color, String... passengers) {
    List<String> p = Collections.unmodifiableList(Arrays.asList(passengers));

    Car self = new Car(gas, color, p, Arrays.asList("jack", "wrench", "spare wheel"));
    return self;
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

  public Optional<List<String>> getTrunkContentsOpt() {
    return Optional.ofNullable(trunkContents);
  }

  @Override
  public String toString() {
    return "Car{" + "gasLevel=" + gasLevel + ", color=" + color + ", passengers=" + passengers
        + (trunkContents != null ? ", trunkContents=" + trunkContents : " no trunk") + '}';
  }

  public static Predicate<Car> getColorCriterion(String ... colors) {
    Set<String> colorSet = new TreeSet<>(Arrays.asList(colors));
    return c -> colorSet.contains(c.getColor());
  }
  
  public static Predicate<Car> getRedCarCriterion() {
    return RED_CAR_CRITERION;
  }

  private static final Predicate<Car> RED_CAR_CRITERION
      = c -> c.color.equals("Red");

  public static Predicate<Car> getGasLevelCarCriterion(final int threshold) {
    return c -> c.gasLevel >= threshold;
  }

  public static Predicate<Car> getFourPassengerCriterion() {
    return c -> c.passengers.size() >= 4;
  }

  public static Comparator<Car> getFuelComparator() {
    return fuelComparator;
  }

  private static final Comparator<Car> fuelComparator = (o1, o2) -> o1.gasLevel - o2.gasLevel;
}

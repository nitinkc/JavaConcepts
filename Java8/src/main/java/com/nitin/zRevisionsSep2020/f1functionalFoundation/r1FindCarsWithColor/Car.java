package com.nitin.zRevisionsSep2020.f1functionalFoundation.r1FindCarsWithColor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Car {

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

  //This could return null; DELIBERATELY WRITTEN FOR DEMO
  public List<String> getTrunkContentsOpt() {
    return (trunkContents);
  }

  @Override
  public String toString() {
    return "Car{" + "gasLevel=" + gasLevel + ", color=" + color + ", passengers=" + passengers
            //Check for the null trunkContents.
        + (trunkContents != null ? ", trunkContents=" + trunkContents : " no trunk") + '}';
  }
}
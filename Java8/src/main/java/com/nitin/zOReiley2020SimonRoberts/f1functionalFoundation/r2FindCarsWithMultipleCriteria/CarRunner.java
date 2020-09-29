package com.nitin.zOReiley2020SimonRoberts.f1functionalFoundation.r2FindCarsWithMultipleCriteria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CarRunner {

  public static void main(String[] args) {

    /*
    One is how to make a sublist and the other is what to put in the sublist.

    What we would like to be able to do is not simply to specify a value that we want to match or exceed,
    like a red color or a gas level. What we would like to be able to do is to say,
    here is the behavior that will select or identify the kind of vehicle that we want in this output list.

    And we tend, as object oriented programmers, not to think in terms of behavior as arguments to functions.
    But it turns out that an object is the amalgamation of both state, things like gas levels, and behavior,
    the methods that we apply to that object, all in one place. And if we pass an object as an argument,
    we pass the behavior that that object contains. That means that we could pass the selection behavior by
    passing an object, primarily for the purpose of behavior rather than just for the purpose of its state.

    So what we would like to be able to do is to **pass an argument** in here that tells us how to
    select something and call a behavior on it in here.

    So, hopefully the idea that we can pass an object as a function argument, or as a method argument,
    and it takes with it the behavior that is built into that object, is starting to make a little bit of sense.
     */
    List<Car> cars = Arrays.asList(
            //Calling static Factories
        Car.withGasColorPassengers(6, "Red", "Fred", "Jim", "Sheila"),
        Car.withGasColorPassengers(3, "Octarine", "Rincewind", "Ridcully"),
        Car.withGasColorPassengers(9, "Black", "Weatherwax", "Magrat"),
        Car.withGasColorPassengers(7, "Green", "Valentine", "Gillian", "Anne", "Dr. Mahmoud"),
        Car.withGasColorPassengers(6, "Red", "Ender", "Hyrum", "Locke", "Bonzo")
    );

    //Calling Utility Method
    System.out.println("************ ALL CARS ************");
    showAll(cars);

    System.out.println("************ getColoredCarIterable ************");
    showAll(getColoredCarIterable(cars, "Octarine"));

    /*
     getColoredCarIterable() and getColoredCarByMinGasLevel() has code duplication. Except for the argument and the if
     statement, everything else is a copy-paste
     */
    System.out.println("************ getColoredCarByMinGasLevel ************");
    showAll(getColoredCarByMinGasLevel(cars, 7));

    //Original List doesn't change
    showAll(cars);
  }

  private static List<Car> getColoredCarIterable(Iterable<Car> iter, String color){
    //Return a new list: Functional style : DO NOT MODIFY THE ORIGINAL LIST
    List<Car> returnCars = new ArrayList<>();

    for (Car c : iter){
      if(c.getColor().equals(color)){
        returnCars.add(c);
      }
    }
    return returnCars;
  }

  private static List<Car> getColoredCarByMinGasLevel(Iterable<Car> iter, int minGasLevel) {
    //Return a new list: Functional style : DO NOT MODIFY THE ORIGINAL LIST
    List<Car> returnCars = new ArrayList<>();

    for (Car c : iter) {
      if (c.getGasLevel() >= minGasLevel) {
        returnCars.add(c);
      }
    }
    return returnCars;
  }

  public static void showAll(List<Car> lc) {
    for (Car c : lc) {
      //Printing each car using toString representation
      System.out.println(c);
    }
    System.out.println("-------------------------------------");
  }

}

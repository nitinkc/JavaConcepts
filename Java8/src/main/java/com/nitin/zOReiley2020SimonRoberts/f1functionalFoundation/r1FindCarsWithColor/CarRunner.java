package com.nitin.zOReiley2020SimonRoberts.f1functionalFoundation.r1FindCarsWithColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CarRunner {

  public static void main(String[] args) {
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

    //Showing Red Cars... But how abotu Blue. Make the method General insteaqd of copy pasting the red and change blue.
    System.out.println("************ getRedCar ************");
    showAll(getRedCar(cars));

    //A little better
    System.out.println("************ getColoredCar ************");
    showAll(getColoredCar(cars, "Black"));

    System.out.println("************ getColoredCarIterable ************");
    showAll(getColoredCarIterable(cars, "Black"));

    //Original List doesn't change
    showAll(cars);
  }

  public static void showAll(List<Car> lc) {
    for (Car c : lc) {
      //Printing each car using toString representation
      System.out.println(c);
    }
    System.out.println("-------------------------------------");
  }

  // Too specific method to be reusable
  public static List<Car> getRedCar(List<Car> car){
    //Return a new list: Functional style : DO NOT MODIFY THE ORIGINAL LIST
    List<Car> returnCars = new ArrayList<>();

    for (Car c : car){
      if(c.getColor().equals("Red")){
        returnCars.add(c);
      }
    }
    return returnCars;
  }

  // General method || Slightly reusable
  public static List<Car> getColoredCar(List<Car> car, String color){
    //Return a new list: Functional style : DO NOT MODIFY THE ORIGINAL LIST
    List<Car> returnCars = new ArrayList<>();

    for (Car c : car){
      if(c.getColor().equals(color)){
        returnCars.add(c);
      }
    }
    return returnCars;
  }

  //Generalizing the arguments || The more general the argument, the better is its usability.
  // In the method, only the iterable feature of the list is being used.

  //ONLY THE ARGUMENT IS CHANGED. NO OTHER CODE CHANGE
  public static List<Car> getColoredCarIterable(Iterable<Car> iter, String color){
    //Return a new list: Functional style : DO NOT MODIFY THE ORIGINAL LIST
    List<Car> returnCars = new ArrayList<>();

    for (Car c : iter){
      if(c.getColor().equals(color)){
        returnCars.add(c);
      }
    }
    return returnCars;
  }

}

package com.nitin.zOReiley2020SimonRoberts.f2functionalConcepts.r0Ownership;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CarRunner1 {

  public static void main(String[] args) {
    List<Car1> cars = Arrays.asList(
            //Calling static Factories
            Car1.withGasColorPassengers(6, "Red", "Fred", "Jim", "Sheila"),
            Car1.withGasColorPassengers(3, "Octarine", "Rincewind", "Ridcully"),
            Car1.withGasColorPassengers(9, "Black", "Weatherwax", "Magrat"),
            Car1.withGasColorPassengers(7, "Green", "Valentine", "Gillian", "Anne", "Dr. Mahmoud"),
            Car1.withGasColorPassengers(6, "Red", "Ender", "Hyrum", "Locke", "Bonzo")
    );

    //Calling Utility Method
    System.out.println("************ ALL CARS ************");
    showAll(cars);

    System.out.println("************ getCarsByCriteria ************");
    //The behaviour of decision  making is passed as an argument.
    showAll(getCarsByCriteria1(cars, new Car1.RedCarCriterion()));

    System.out.println("************ GasLevelCarCriterion ************");
    showAll(getCarsByCriteria1(cars, new Car1.GasLevelCarCriterion(7)));

    //Original List is not changed
    showAll(cars);
  }

  private static List<Car1> getCarsByCriteria1(Iterable<Car1> iter, CarCriteria1 criteria) {
    //Return a new list: Functional style : DO NOT MODIFY THE ORIGINAL LIST
    List<Car1> returnCars = new ArrayList<>();

    for (Car1 c : iter) {
      //Passing the criteria based on the users input
      if (criteria.test(c)) {
        returnCars.add(c);
      }
    }
    return returnCars;
  }

  public static void showAll(List<Car1> lc) {
    for (Car1 c : lc) {
      //Printing each car using toString representation
      System.out.println(c);
    }
    System.out.println("-------------------------------------");
  }
}
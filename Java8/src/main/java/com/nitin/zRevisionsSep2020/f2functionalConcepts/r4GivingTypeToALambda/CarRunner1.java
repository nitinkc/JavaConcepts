package com.nitin.zRevisionsSep2020.f2functionalConcepts.r4GivingTypeToALambda;

import com.nitin.zRevisionsSep2020.Car;

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
    showAll(getCarsByCriteria1(cars, Car1.getRedCarCriterion()));//****** Singletom ***********

    System.out.println("************ getFourPassengerCriterion ************");
    showAll(getCarsByCriteria1(cars, Car1.getFourPassengerCriterion()));

    System.out.println("************ Passing Lambda. The method argument decides the type of the Lambda expression ************");
    showAll(getCarsByCriteria1(cars, c -> c.getPassengers().size() == 2));

    //Original List is not changed
    showAll(cars);

    // Lambda Assignment
    CarCriteria1 x = c -> c.getColor().equals("Red");

    // Giving context to an stand alone Lambda to help determine its type.
    // The Cast provides the necessasary context for the Lambda expression to be successful.
    // ((CarCriteria1)(c -> c.getColor().equals("Red"))) is an object reference of type CarCriteria1 and thus the test
    // method can be invoked.
    boolean b1 = ((CarCriteria1)(c -> c.getColor().equals("Red"))).test(Car1.withGasColorPassengers(0,"Red"));

    //  a single lambda expression could potentially be compiled into multiple
    //different interfaces depending on the context. Almost the same context.
    boolean b2 = ((Strange)((Car1 c) -> c.getColor().equals("Red"))).anotherTestStuff(Car1.withGasColorPassengers(0,"Red"));

    System.out.println( "a single lambda expression could potentially be compiled into multiple " +
            "different interfaces depending on the context");
    System.out.println("B1 = "+b1 + " abd B2 = " + b2);
  }

  private static List<Car1> getCarsByCriteria1(Iterable<Car1> iter, CarCriteria1 criteria) {
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
      System.out.println(c);
    }
    System.out.println("-------------------------------------");
  }
}
package nitin.interfaces.f1functionalFoundation.r4CommandPatternSelection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CarRunner {

  public static void main(String[] args) {

    /*
    So a key piece of what we have to do now is to build an interface that we can use to pass this question of
    do we like this one, wrapped up as an object, as an argument into our selection mechanism.

    the command Pattern. Turns out, that not only is the command pattern, a well-known Pattern,
    although not perhaps as well used as it should have been in object orientation, it's also key way of doing things
    in functional programming.
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

    System.out.println("************ getCarsByCriteria ************");
    //The behaviour of decision  making is passed as an argument.
    showAll(getCarsByCriteria(cars,new RedCarCriterion()));

    System.out.println("************ GasLevelCarCriterion ************");
    showAll(getCarsByCriteria(cars,new GasLevelCarCriterion(7)));

    //Original List is not changed
    showAll(cars);
  }

  private static List<Car> getCarsByCriteria(Iterable<Car> iter, CarCriteria criteria){
    //Return a new list: Functional style : DO NOT MODIFY THE ORIGINAL LIST
    List<Car> returnCars = new ArrayList<>();

    for (Car c : iter){

      //Passing the criteria based on the users input
      if(criteria.test(c)){
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

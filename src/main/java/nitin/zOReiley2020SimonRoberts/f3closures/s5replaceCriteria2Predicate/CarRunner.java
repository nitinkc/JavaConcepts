package nitin.zOReiley2020SimonRoberts.f3closures.s5replaceCriteria2Predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

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
    //showAll(cars);

    System.out.println("************ getColorCriteria with varArg ************");
    showAll(getByCriteria(cars, Car.getColorCriteria("Red", "Green")));

    Predicate<Car> level7 = Car.getGasLevelCarCriteria(7);
    Predicate<Car> notLever7 =level7.negate();

    System.out.println("********* Not Level 7 ******************");
    showAll(getByCriteria(cars, notLever7));

    Predicate<Car> isRed = Car.getColorCriteria("Red");
    Predicate<Car> fourPassengers = Car.getFourPassengerCriterion();

    showAll(getByCriteria(cars, level7));

    System.out.println("************ red Or Level 7 ************");
    Predicate<Car> redORlevel7 = isRed.or(level7);
    showAll(getByCriteria(cars,redORlevel7));

  }

  //The Type declaration of the Generic Variable is placed immediately before the Return Type
  private static <E> List<E> getByCriteria(Iterable<E> iter, Predicate<E> criteria) {
    List<E> returnCars = new ArrayList<>();
    for (E c : iter) {
      //Passing the criteria based on the users input
      if (criteria.test(c)) {
        returnCars.add(c);
      }
    }
    return returnCars;
  }

  public static <E> void showAll(List<E> lc) {
    for (E c : lc) {
      System.out.println(c);
    }
    System.out.println("-------------------------------------");
  }
}
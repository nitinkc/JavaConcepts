package nitin.interfaces.f1functionalFoundation.r0TheProblem;

import java.util.Arrays;
import java.util.List;

//Package-private class
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
    showAll(cars);
  }

  public static void showAll(List<Car> lc) {
    for (Car c : lc) {
      //Printing each car using toString representation
      System.out.println(c);
    }
    System.out.println("-------------------------------------");
  }
}

package nitin.oops.interfaces.f1functionalFoundation.r3SortCarsPreJava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CarRunner {

    public static void main(String[] args) {

    /*
    That was the version of ordering things for lists prior to Java eight but the essential thing that's going on here
    is that we've created an object, implementing the comparator interface such that, the sort method could use the
    behavior defined in that object to decide, are these two objects in the right order, or the wrong order and that
    was the basis on which it could then proceed to sort objects of a type it had never seen before based on an
    ordering criterion that did not come to anybody's head at the time when the sort method was written.
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

        //PassengerCountOrder doesnt have any state to it, Only behaviour (compare method)
        cars.sort(new PassengerCountOrder());

        //Original List got changed
        showAll(cars);
    }

    private static List<Car> getColoredCarIterable(Iterable<Car> iter, String color) {
        //Return a new list: Functional style : DO NOT MODIFY THE ORIGINAL LIST
        List<Car> returnCars = new ArrayList<>();

        for (Car c : iter) {
            if (c.getColor().equals(color)) {
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

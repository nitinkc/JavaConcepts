package nitin.zOReiley2020SimonRoberts.f2functionalConcepts.r3IntroducingLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CarRunner1 {

    public static void main(String[] args) {
        List<Car1> cars =
                Arrays.asList(
                        // Calling static Factories
                        Car1.withGasColorPassengers(6, "Red", "Fred", "Jim", "Sheila"),
                        Car1.withGasColorPassengers(3, "Octarine", "Rincewind", "Ridcully"),
                        Car1.withGasColorPassengers(9, "Black", "Weatherwax", "Magrat"),
                        Car1.withGasColorPassengers(
                                7, "Green", "Valentine", "Gillian", "Anne", "Dr. Mahmoud"),
                        Car1.withGasColorPassengers(6, "Red", "Ender", "Hyrum", "Locke", "Bonzo"));

        // Calling Utility Method
        System.out.println("************ ALL CARS ************");
        showAll(cars);
        System.out.println("************ getCarsByCriteria ************");

        // Factory type of approach. Instead of calling a static field, call a static method.
        // showAll(getCarsByCriteria1(cars, Car1.RED_CAR_CRITERION));

        // Here getRedCarCriterion has a choice of implementing the new a5object or the single
        // static a5object
        // If the below line is to be used 5 10 times within the same code, the new approach will
        // created multiple objects,
        // while the static field will only create it once
        // showAll(getCarsByCriteria1(cars, Car1.getRedCarCriterion()));

        // Calling directly by the interface name instead of its implementation
        // showAll(getCarsByCriteria1(cars, Car1.getCarCriterion()));
        showAll(
                getCarsByCriteria1(
                        cars, Car1.getRedCarCriterion())); // ****** Singletom ***********
        System.out.println("************ GasLevelCarCriterion ************");
        showAll(
                getCarsByCriteria1(
                        cars, Car1.getGasLevelCarCriterion(7))); // ****** Not a Singleton ******

        // Original List is not changed
        showAll(cars);
    }

    private static List<Car1> getCarsByCriteria1(Iterable<Car1> iter, CarCriteria1 criteria) {
        // Return a new list: Functional style : DO NOT MODIFY THE ORIGINAL LIST
        List<Car1> returnCars = new ArrayList<>();

        for (Car1 c : iter) {
            // Passing the criteria based on the users input
            if (criteria.test(c)) {
                returnCars.add(c);
            }
        }
        return returnCars;
    }

    public static void showAll(List<Car1> lc) {
        for (Car1 c : lc) {
            // Printing each car using toString representation
            System.out.println(c);
        }
        System.out.println("-------------------------------------");
    }
}

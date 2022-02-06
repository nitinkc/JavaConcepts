package nitin.zOReiley2020SimonRoberts.f2functionalConcepts.r5genericsNgeneralization;

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
        showAll(getByCriteria(cars, Car1.getRedCarCriterion()));//****** Singletom ***********

        System.out.println("************ getFourPassengerCriterion ************");
        showAll(getByCriteria(cars, Car1.getFourPassengerCriterion()));

        System.out.println("************ Passing Lambda. The method argument decides the type of the Lambda expression ************");
        showAll(getByCriteria(cars, c -> c.getPassengers().size() == 2));

        //Original List is not changed
        showAll(cars);

        // Lambda Assignment
        Criteria<Car1> x = c -> c.getColor().equals("Red");

    }

    //The Type declaration of the Generic Variable is placed immediately before the Return Type
    private static <E> List<E> getByCriteria(Iterable<E> iter, Criteria<E> criteria) {
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
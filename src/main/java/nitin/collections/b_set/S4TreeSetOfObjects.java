package nitin.collections.b_set;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

/**
 * Created by nitin on Saturday, August/24/2019 at 22:07
 */
public class S4TreeSetOfObjects {


    public static void main(String[] args) {

        Car a = new Car("Honda", "CRV", new int[]{05, 2019}, new ArrayList<String>(Arrays.asList("AWD", "Leather", "Sun Roof", "Grey Interior")));
        Car b = new Car("Toyota", "RAV4", new int[]{03, 2019}, new ArrayList<String>(Arrays.asList("2WD", "Cotton", "Sun Roof", "Grey Interior")));
        Car c = new Car("Honda", "Accord", new int[]{03, 2018}, new ArrayList<String>(Arrays.asList("AWD", "Leather", "Sun Roof", "Grey Interior")));
        Car d = new Car("Toyota", "Camry", new int[]{06, 2018}, new ArrayList<String>(Arrays.asList("2WD", "Cotton", "Sun Roof", "Grey Interior")));

        Set<Car> set = new TreeSet<>(Comparator
                .comparing(Car::getMake)//Default Natural Sorting Order
                .thenComparing(Car::getModel)
                .thenComparingInt(car -> car.getYymm()[0])
                .thenComparingInt(car -> car.getYymm()[1])
                .thenComparingInt(car -> car.getFeatures().size())
        );
        System.out.println(set.add(a));
        System.out.println(set.add(b));
        System.out.println(set.add(c));
        System.out.println(set.add(d));

        System.out.println(set);
    }
}

/****************/
@Data
@AllArgsConstructor
class Car {
    private String model;
    private String make;
    private int[] yymm;
    private List<String> features;
}
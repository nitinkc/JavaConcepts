package nitin.generic.oReilly.a2Wildcards;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class B2UpperBounds {
    public static void main(String[] args) {
        List<? extends Number> numbers = new ArrayList<>();
        // Cannot be added into, like Unbounded
        // numbers.add(3);
        // inheritanceProblemSolved();

        List<? extends Number> list = Arrays.asList(3.14, (22 / 7), 1.00, 2);
        callMethodsOfBoundedClass(list);
        /*
            * Generic java collections are covarient
            * when extends is used with a wild card
            * this means - if you declare a collection, with a bounded wildcard,
            you can use methods from the Bound (AClass)
            * Eg: ? extends Number, the methods of Number can also be used
        * USING -> List<? extends Number> each element Supports Number methods as well, along with ? */
    }

    private static void callMethodsOfBoundedClass(List<? extends Number> list) {
        final int DEFAULT_VALUE = 9999;
        // Function to convert Strings to Int, put 9999 as default value for other cases
        Function<Number, ? extends String> function = x -> x.toString();

        list.stream().map(function).forEach((x) -> System.out.println(x));
    }

    private static void inheritanceProblemSolved() {
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubles = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        List<BigDecimal> bigDecimals = Arrays.asList(new BigDecimal(1), new BigDecimal(2));

        System.out.println(sumList(ints));
        System.out.println(sumList(doubles));
        System.out.println(sumList(bigDecimals));
    }

    // Upper bounds solves the problem. Number and its child classes can be used (see ReadMe).
    private static Double sumList(List<? extends Number> list) {
        return list.stream()
                .mapToDouble(Number::doubleValue) // Using Number as the Upper Bound Class
                .sum();
    }
}

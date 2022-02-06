package nitin.oops.interfaces.functionalInterface.PredefinedFunctionalInterfaces;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Created by Nitin Chaurasia on 1/30/18 at 8:37 PM.The file name should be application-datasource-h2.properties
 * P1 -> if number is > 10
 * P2 -> is even
 * <p>
 * P1.negate()
 * P1.and(P2)
 * P1.or(P2)
 */


public class PDF2PredicateJoining {
    public static void main(String[] args) {
        int[] x = {0, 5, 10, 15, 20, 25, 30};

        Predicate<Integer> p1 = i -> i > 10;
        Predicate<Integer> p2 = i -> i / 2 == 0;

        System.out.println("ARRAY : " + Arrays.asList(x));
        System.out.println("Number Greater than 10");
        m1(p1, x);

        System.out.println("Number Less than 10");
        m1(p1.negate(), x);

        System.out.println("Number Greater than 10 and Even");
        m1(p1.and(p2), x);

        System.out.println("Number Greater than 10 or Even");
        m1(p1.or(p2), x);


        Predicate<String> egg = (s -> s.contains("egg"));
        Predicate<String> brownEgg = (s -> s.contains("brown"));
        //Predicate if both egg and brownEgg exists
        Predicate<String> doublePredicate = egg.and(brownEgg);
        Predicate<String> doublePredicateNegate = egg.and(brownEgg.negate());


    }

    private static void m1(Predicate<Integer> p, int[] arr) {

        for (int x : arr) {
            if (p.test(x))
                System.out.print(x + "\t");
        }
        System.out.println();
        return;
    }


}

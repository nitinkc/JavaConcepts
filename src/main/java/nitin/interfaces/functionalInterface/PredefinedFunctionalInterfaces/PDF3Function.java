package nitin.interfaces.functionalInterface.PredefinedFunctionalInterfaces;

import java.util.function.Function;

/**
 * Created by Nitin C on 3/3/2016.
 * A function is responsible for turning one parameter into a value of a potentially different type and returning it.
 * has a method apply
 */
public class PDF3Function {
    public static void main(String[] args) {

        //Takes String as input and and return an Integer as output
        //Function<T,R> T input type, R return type
        Function<String, Integer> f1 = String::length;
        Function<String, String> f2 = x -> x.toUpperCase();

        System.out.println(f1.apply("Nitin"));
        System.out.println(f2.apply("chaurasia"));

        //Implement a function to return square of an integer
        Function<Integer,Integer> f3 = x -> x*x;
        System.out.println(f3.apply(3));

    }
}

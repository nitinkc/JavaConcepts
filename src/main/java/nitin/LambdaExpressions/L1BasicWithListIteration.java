package nitin.LambdaExpressions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Nitin C on 2/27/2016.
 *
 * <p>The biggest change in the Java 8 is in the minds of the programmers. A lot of fun to be
 * learning a better way of programming
 */
public class L1BasicWithListIteration {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        /************************
         *  EXTERNAL ITERATORS (for and for each) (Manage outside)
         ************************/

        // Complex, initial (boundary less than or less than equal to)
        // Self inflicted wound pattern
        for (int i = 0; i < list.size(); i++) {
            // System.out.println(list.get(i));
        }

        // Fewer moving parts
        for (int element : list) {
            // System.out.println(element);
        }

        /************************
         *  Internal iterator, put on autopilot
         *  just tell what to do, not how the iterations done
         ************************/

        // method forEach is called on the a5object
        // Anonymous inner class
        // This gives polymorphism
        // forEach method is now on a10collections
        list.forEach(
                new Consumer<Integer>() { // Consumer is a new interface in java 8
                    @Override
                    public void accept(
                            Integer value) { // method of consumer, which accepts the array
                        // System.out.println(value);
                    }
                });

        // FUNDAMENTAL DIFFERENCE  SEMANTICALLY

        // Polymorphism says : don't worry how things are done, worry about what you want to do
        // and decide the implementation at one time. Whether its sequential or concurrent or lazy,
        // i don't want now, it want to postpone the decision to a later time

        // Ceremony is the things that you HAVE do before you do before you do what you REALLY want
        // to do
        list.forEach((Integer element) -> System.out.print(element));
        System.out.println();
        /* forEach says i am accepting a function CONSUMER
         * a Function has 4 things - name, return type, parameter list and Body
         * Most Imp: is Body of the function
         * Body of the function -> System.out.println(element)
         * Parameter List --> (Integer element)
         * */

        // A collection of integer is known to integer
        // Java figures out BASED ON THE CONTEXT.
        // Don't have to write the obvious
        list.forEach((element) -> System.out.print(element));
        System.out.println();

        // Removing the brackets
        list.forEach(element -> System.out.print(element));
        System.out.println();

        // Even Shorter
        list.forEach(System.out::print);
        System.out.println();
        // ForEach receives a Consumer functional parameter
        // Functional Interface : can be automatically be elevated to lambda expression
        // In other words, you can Only use lambdas for functional interfaces
        // A functional interface is a SAM (Single abstract Method) interface. it can only have one
        // abstract method
        // that method has signature with parameter coming in.
        // Functional interface assign a contract!!

        // forEach received Consumer F interface

        /*DOUBLE THE VALUE AND TOTAL*/
        // Imperative code : you use Mutation!!
        // total is constantly mutating!
        // We spend efforts ion what to do and how to do
        int total = 0;
        for (int e : list) {
            total += e * 2;
        }

        System.out.println(total);

        // Declarative style
        System.out.println(list.stream().map(e -> e * 2).reduce(0, (c, e) -> c + e));
    }

    // Old interface evolved : through default methods
    // Default method is a method implementation, you can write within an interface

}

package nitin.LambdaExpressions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Nitin C on 3/3/2016.
 */
public class LoopThroughCollections {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,1,4,5,6);

        // PRINT USING ArrayList Default toString method
        System.out.println(list);

        //Print Using Lambda with CONSUMER - not very Common
        list.forEach(l -> System.out.print(l + ", "));// Off by one for the last comma!!
        System.out.println();

        //Print using static reference
        list.forEach(System.out :: print);// How to insert a comma between elements
        System.out.println();

        //Demonstration that forEach accepts Consumer
        Consumer<Integer> c1 = (System.out::print);

        // Prints com.nitin.a15java8.lambda.LoopThroughCollections$$Lambda$3/1023892928@214c265e
        // This is the result of calling toString() on a Lambda
        //Fully Qualified Class name is followed by $$ which means that the class doesn't exist in a class file
        // on the file system. IT exists only in the memory
        System.out.println(c1);

        list.forEach(c1);

    }
}

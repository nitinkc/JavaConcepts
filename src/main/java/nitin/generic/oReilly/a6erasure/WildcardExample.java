package nitin.generic.oReilly.a6erasure;

import java.util.ArrayList;
import java.util.List;

public class WildcardExample {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);

        // Method that tries to add elements to a list with a wildcard
        processList(integers); // Compiler error in this line

        // Print the modified list
        for (Integer num : integers) {
            System.out.println(num);
        }
    }

    public static void processList(List<? extends Number> list) {
        // Compiler error: Cannot add elements to a list with an extends wildcard
        //list.add(new Integer(10)); // This line would cause a compile-time error
    }
}


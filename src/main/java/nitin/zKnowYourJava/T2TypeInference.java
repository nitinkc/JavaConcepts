package nitin.zKnowYourJava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class T2TypeInference {
    public static void main(String[] args) {
        var test = "test";
        // test.foo();
        removeIndexFromVar();
        removeObjectFromCollection();
    }

    private static void removeObjectFromCollection() {
        Collection<Integer> numbers = new ArrayList<Integer>(getIntegers());
        numbers.remove(1); // Removes the Object
        System.out.println(numbers); // [2, 3]
    }

    private static void removeIndexFromVar() {
        var numbers = new ArrayList<Integer>(getIntegers());
        numbers.remove(1); // overloaded Remove method that takes Integer instead of Object
        System.out.println(numbers); // [1, 3]
    }

    private static List<Integer> getIntegers() {
        return List.of(1, 2, 3);
    }
}

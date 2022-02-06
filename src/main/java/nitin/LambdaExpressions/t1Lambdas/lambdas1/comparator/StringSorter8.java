package nitin.LambdaExpressions.t1Lambdas.lambdas1.comparator;

import java.util.Arrays;

import static java.util.Comparator.comparing;

public class StringSorter8 {
    public static void doTests() {
        String[] testStrings = {"one", "two", "three", "four"};
        System.out.print("Original: ");
        ArrayUtils.printArray(testStrings);
        // Declaration of s as String required to avoid ambiguity
        Arrays.sort(testStrings, comparing((String s) -> s.length()));
        // CanNOT directly use Arrays.sort(testStrings, comparing(String::length));
        // due to type ambiguity.
        System.out.print("After sorting by length: ");
        ArrayUtils.printArray(testStrings);
        // Declaration of s as String required to avoid ambiguity
        Arrays.sort(testStrings, comparing((String s) -> s.charAt(s.length() - 1)));
        System.out.print("After sorting by last letter: ");
        ArrayUtils.printArray(testStrings);
    }
}

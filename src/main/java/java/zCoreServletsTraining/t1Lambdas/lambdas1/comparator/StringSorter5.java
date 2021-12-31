package java.zCoreServletsTraining.t1Lambdas.lambdas1.comparator;

import java.util.Arrays;

public class StringSorter5 {
  public static void doTests() {
    String[] testStrings = {"one", "two", "three", "four"};
    System.out.print("Original: ");
    ArrayUtils.printArray(testStrings);
    Arrays.sort(testStrings, (String s1, String s2) -> { return(s1.length() - s2.length()); });
    System.out.print("After sorting by length: ");
    ArrayUtils.printArray(testStrings);
    Arrays.sort(testStrings, (String s1, String s2) -> { return(s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1)); });
    System.out.print("After sorting by last letter: ");
    ArrayUtils.printArray(testStrings);
  }
}

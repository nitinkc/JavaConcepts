package java8.zCoreServletsTraining.t1Lambdas.lambdas1.comparator;

import java.util.Arrays;

public class StringSorter1 {
  public static void doTests() {
    String[] testStrings = {"one", "two", "three", "four"};
    System.out.print("Original: ");
    ArrayUtils.printArray(testStrings);
    Arrays.sort(testStrings, new StringLengthComparator());
    System.out.print("After sorting by length: ");
    ArrayUtils.printArray(testStrings);
    Arrays.sort(testStrings, new LastLetterComparator());
    System.out.print("After sorting by last letter: ");
    ArrayUtils.printArray(testStrings);
  }
}

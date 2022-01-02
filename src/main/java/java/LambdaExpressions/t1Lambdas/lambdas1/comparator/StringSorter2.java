package java.LambdaExpressions.t1Lambdas.lambdas1.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class StringSorter2 implements Comparator<String> {
  public void doTests() {
    String[] testStrings = {"one", "two", "three", "four"};
    System.out.print("Original: ");
    ArrayUtils.printArray(testStrings);
    Arrays.sort(testStrings, this);
    System.out.print("After sorting by length: ");
    ArrayUtils.printArray(testStrings);
    System.out.println("NO sorting by last letter.");
  }
  
  @Override
  public int compare(String s1, String s2) {
    return(s1.length() - s2.length());
  }
}

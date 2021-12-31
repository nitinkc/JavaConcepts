package java.zCoreServletsTraining.t1Lambdas.lambdas1Ex;

import java.util.Arrays;

public class SortingExamples {
  public static void main(String[] args) {
    String[] words = { "hi", "hello", "hola", "bye", "goodbye", "adios" };
    System.out.println("Original array: " + 
                       Arrays.asList(words));
    
    Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());
    System.out.println("Sorted by length ascending: " + 
                       Arrays.asList(words));
    
    Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
    System.out.println("Sorted by length descending : " + 
                       Arrays.asList(words));
    
    Arrays.sort(words, (s1, s2) -> s1.charAt(0) - s2.charAt(0));
    System.out.println("Sorted by first letter : " + 
                       Arrays.asList(words));
    
    Arrays.sort(words, (s1, s2) -> 
                 { int compareFlag = 0;
                   if(s1.contains("e") && !s2.contains("e")) {
                     compareFlag = -1;
                   } else if(s2.contains("e") && !s1.contains("e")) {
                     compareFlag = 1;
                   }
                   return(compareFlag);
                 });
    System.out.println("Sorted by whether it contains 'e' [v1] : " +
                       Arrays.asList(words));
    
  }
}

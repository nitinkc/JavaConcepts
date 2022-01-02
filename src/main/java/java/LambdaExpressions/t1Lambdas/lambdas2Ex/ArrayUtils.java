package java.LambdaExpressions.t1Lambdas.lambdas2Ex;

import java.util.Arrays;

/** Two ways to print an array.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java)</a>.
 */

public class ArrayUtils {
  /** Prints an array by turning it into a List, then printing the List.
   *  Lists already have useful toString methods that print the individual
   *  entries delimited by commas and surrounded by square brackets.
   */
  public static <T> void printArray(T[] entries) {
    System.out.println(Arrays.asList(entries));
  }
    
  /** Prints an array "by hand", resulting in the same thing as
   *  printArray above, except surrounded by curly braces instead
   *  of square brackets. Another alternative would be to use String.join.
   */
  public static <T> void printArray2(T[] entries) {
    System.out.print("{");
    int lastIndex = entries.length - 1;
    for(int i=0; i<lastIndex; i++) {
      System.out.printf("%s, ", entries[i]);
    }
    System.out.printf("%s}%n", entries[lastIndex]);
  }
  
  private ArrayUtils() {}; // Uninstantiatable class; contains only static methods.
}

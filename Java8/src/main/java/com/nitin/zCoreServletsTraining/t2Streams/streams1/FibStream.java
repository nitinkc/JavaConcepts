package com.nitin.zCoreServletsTraining.t2Streams.streams1;

import java.util.List;
import java.util.stream.*;

/** A class with static methods to build streams of Fibonacci numbers.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java)</a>.
 */

public class FibStream {
  
  /** Makes an "infinite" (unbounded) stream of Fibonacci numbers
   *  (1, 1, 2, 3, 5, 8, 13, 21, 34, and so forth).
   *  This method is for when you want to control the size-limiting steps later.
   *  The more common usage is the next method, where you limit the
   *  size in the call to the original method.
   */
  public static Stream<Long> makeFibStream() {
    return(Stream.generate(new FibonacciMaker()));
  }
  
  /** Makes a Stream of the specified number of Fibonacci numbers. */
  
  public static Stream<Long> makeFibStream(int numFibs) {
    return(makeFibStream().limit(numFibs));
  }
  
  /** Makes a List of the specified number of Fibonacci numbers. */
  
  public static List<Long> makeFibList(int numFibs) {
    return(makeFibStream(numFibs).collect(Collectors.toList()));
  }
  
  /** Makes an array of the specified number of consecutive n-digit primes */
  
  public static Long[] makeFibArray(int numFibs) {
    return(makeFibStream(numFibs).toArray(Long[]::new));
  } 
  
  private FibStream() {} // Uninstantiatable class
}

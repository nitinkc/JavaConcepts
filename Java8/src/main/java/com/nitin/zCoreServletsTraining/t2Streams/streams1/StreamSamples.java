package com.nitin.zCoreServletsTraining.t2Streams.streams1;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/** Various examples of Stream functionality, shown and explained in the Stream
 *  sections of the Java 8 tutorial at coreservlets.com.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, JavaScript, jQuery, Angular 2,
 *  GWT, Android, Spring, Hibernate, JPA, RESTful Web Services, Hadoop, 
 *  servlets, JSP, and Java 8 and Java 9 programming</a>.
 */

public class StreamSamples {
  public static void main(String[] args) {
    forEachExamples();
    forEachExamples();
    mapExamples();
    filterExamples();
    combinedExample();
    lazyEvaluationExample();
  }
  
  /** Examples of the forEach method */
  
  public static void forEachExamples() {
    List<Employee> googlers = EmployeeSamples.getGooglers();
    googlers.stream().forEach(System.out::println);
    googlers.stream().forEach(e -> e.setSalary(e.getSalary() * 11/10)); 
    googlers.stream().forEach(System.out::println);
    
    Consumer<Employee> giveRaise = e -> {
      System.out.printf("%s earned $%,d before raise.%n",
                         e.getFullName(), e.getSalary());
      e.setSalary(e.getSalary() * 11/10);
      System.out.printf("%s will earn $%,d after raise.%n",
                        e.getFullName(), e.getSalary());
    };
    googlers.stream().forEach(giveRaise);
    List<Employee> sampleEmployees = EmployeeSamples.getSampleEmployees();
    sampleEmployees.stream().forEach(giveRaise);
  }
  
  /** A simple static method that turns a Stream into a List, then prints the List
   *  and the associated message.
   */
  private static <T> void printStream(Stream<T> s, String message) {
    System.out.printf("%s: %s.%n", 
                      message, s.collect(Collectors.toList()));
  }
  
  /** Very basic and introductory examples of the map method. More on map later. */
  
  public static void mapExamples() {
    List<Double> nums = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
    printStream(nums.stream(), "Original nums");
    printStream(nums.stream().map(n -> n * n), "Squares");
    printStream(nums.stream().map(n -> n * n).map(Math::sqrt), 
                      "Square roots of the squares");
   
    Integer[] ids = { 1, 2, 4, 8 };
    printStream(Stream.of(ids), "IDs");
    printStream(Stream.of(ids).map(EmployeeSamples::findGoogler)
                                    .map(Person::getFullName), 
                      "Names of Googlers with given IDs");
  }
  
  /** Very basic and introductory examples of the filter method. More on filter later. */
  
  public static void filterExamples() {
    Integer[] nums = { 1, 2, 3, 4, 5, 6 };
    printStream(Stream.of(nums), "Original nums");
    printStream(Stream.of(nums).filter(n -> n%2 == 0), "Even nums");
    printStream(Stream.of(nums).filter(n -> n>3), "Nums > 3");
    printStream(Stream.of(nums).filter(n -> n%2 == 0)
                                     .filter(n -> n>3), 
                      "Even nums > 3");
    
    Integer[] ids = { 16, 8, 4, 2, 1 };
    printStream(Stream.of(ids).map(EmployeeSamples::findGoogler) 
                                    .filter(e -> e != null)
                                    .filter(e -> e.getSalary() > 500_000),
                      "Googlers with salaries over $500K");
    
  }
  
  /** An example that combines map and filter operations. Used to illustrate lazy evaluation. */
  
  public static void combinedExample() {
    Integer[] ids = { 16, 8, 4, 2, 1 };
    System.out.printf("First Googler with salary over $500K: %s%n", 
                      Stream.of(ids).map(EmployeeSamples::findGoogler) 
                                    .filter(e -> e != null)
                                    .filter(e -> e.getSalary() > 500_000)
                                    .findFirst()
                                    .orElse(null));
  }
  
  /** Same as combinedExample, but with print statements added inside the lambdas. */
  
  public static void lazyEvaluationExample() {
    Function<Integer,Employee> findGoogler = 
      n -> { System.out.println("Finding Googler with ID " + n);
             return(EmployeeSamples.findGoogler(n));
           };
    Predicate<Employee> checkForNull = 
      e -> { System.out.println("Checking for null");
             return(e != null);
           };
    Predicate<Employee> checkSalary = 
      e -> { System.out.println("Checking if salary > $500K");
             return(e.getSalary() > 500_000);
           };
    Integer[] ids = { 16, 8, 4, 2, 1 };
    System.out.printf("First Googler with salary over $500K: %s%n", 
                      Stream.of(ids).map(findGoogler)
                                    .filter(checkForNull)
                                    .filter(checkSalary)
                                    .findFirst()
                                    .orElse(null));
  }
  /** An example that (partially) illustrates that you cannot break
   *  out of forEach loops. */
  
  public static void testBreak() {
    List<Employee> googlers = EmployeeSamples.getGooglers();
    // Continues to the end of the Googlers, regardless of the value of Math.random
    googlers.stream().forEach(e -> {
      System.out.println(e);
      if (Math.random() > 0.5) {
        System.out.println("Continuing");
      } else {
        System.out.println("Stopping");
        return;
      }
    });
  }
}

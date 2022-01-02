package java.streams.t2Streams.t2Streams.streams2.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

/** Various examples of stream functionality, shown and explained in the stream
 *  sections of the Java 8 tutorial at coreservlets.com.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, Angular 2,
 *  GWT, Android, Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java). Java 9 topics coming soon.</a>.
 */

public class StreamSamples {
  public static void main(String[] args) {
    limitExamples();
    sortedExamples();
    matchExamples();
    reduceExamples();
  }
 
  /** Examples of the limit and skip methods. */
  
  public static void limitExamples() {
    List<Employee> googlers = EmployeeSamples.getGooglers();
    // Calls getFirstName only 6 times
    List<String> emps = 
      googlers.stream()
              .map(Person::getFirstName)
              .limit(8)
              .skip(2)
              .collect(Collectors.toList());
    System.out.printf("Names of 6 Googlers: %s.%n", 
                      emps);
  }
  
  /** Examples of the sorted, min, max, and distinct methods. */
  
  public static void sortedExamples() {
    List<Integer> ids = Arrays.asList(9, 11, 10, 8);
    List<Employee> emps1 = 
      ids.stream().map(EmployeeSamples::findGoogler)
                  .sorted((e1, e2) -> e1.getLastName()
                                        .compareTo(e2.getLastName()))
                  .collect(Collectors.toList());
    System.out.printf("Googlers with ids %s sorted by last name: %s.%n", 
                      ids, emps1);
    List<Employee> emps2 = 
      ids.stream().map(EmployeeSamples::findGoogler)
                  .sorted((e1, e2) -> e1.getSalary() - e2.getSalary())
                  .collect(Collectors.toList());
    System.out.printf("Googlers with ids %s sorted by salary: %s.%n", 
                      ids, emps2);
    
    List<Employee> sampleEmployees = EmployeeSamples.getSampleEmployees();
    // Using limit does not short-circuit the sorting
    List<Employee> emps3 = 
      sampleEmployees.stream()
                     .sorted(Person::firstNameComparer)
                     .limit(2)
                     .collect(Collectors.toList());
    System.out.printf("Employees sorted by first name: %s.%n", 
                      emps3);
    
    // min is faster than sorting and choosing the first
    Employee alphabeticallyFirst = 
      ids.stream().map(EmployeeSamples::findGoogler)
                  .min((e1, e2) -> e1.getLastName()
                                     .compareTo(e2.getLastName()))
                  .get();
    System.out.printf("Googler from %s with earliest last name: %s.%n", 
                      ids, alphabeticallyFirst);
    Employee richest = 
      ids.stream().map(EmployeeSamples::findGoogler)
                  .max((e1, e2) -> e1.getSalary() - 
                                   e2.getSalary())
                  .get();
    System.out.printf("Richest Googler from %s: %s.%n", 
                      ids, richest);
    List<Integer> ids2 = 
      Arrays.asList(9, 10, 9, 10, 9, 10);
    List<Employee> emps4 = 
      ids2.stream().map(EmployeeSamples::findGoogler)
                   .distinct()
                   .collect(Collectors.toList());
    System.out.printf("Unique Googlers from %s: %s.%n", 
                      ids2, emps4);
  }
  
  /** Examples of the noneMatch, anyMatch, allMatch, and count methods. */
  
  public static void matchExamples() {
    List<Employee> googlers = EmployeeSamples.getGooglers();
    boolean isNobodyPoor = 
      googlers.stream().noneMatch(e -> e.getSalary() < 200000);
    Predicate<Employee> megaRich = e -> e.getSalary() > 7000000;
    boolean isSomeoneMegaRich = googlers.stream().anyMatch(megaRich);
    boolean isEveryoneMegaRich = googlers.stream().allMatch(megaRich);
    long numberMegaRich = googlers.stream().filter(megaRich).count();
    System.out.printf("Nobody poor? %s.%n", isNobodyPoor);
    System.out.printf("Someone mega rich? %s.%n", isSomeoneMegaRich);
    System.out.printf("Everyone mega rich? %s.%n", isEveryoneMegaRich);
    System.out.printf("Number mega rich: %s.%n", numberMegaRich);
  }
  
  /** Examples of the reduce method and related reduction operations. */
  
  public static void reduceExamples() {
    List<String> letters = Arrays.asList("a", "b", "c", "d");
    String concat = letters.stream().reduce("", String::concat);
    System.out.printf("Concatenation of %s is %s.%n", 
                      letters, concat);
    String reversed = letters.stream().reduce("", (s1,s2) -> s2+s1);
    System.out.printf("Reversed concatenation of %s is %s.%n", 
                      letters, reversed);
    String upperReversed = 
      letters.stream().reduce("", (s1,s2) -> s2.toUpperCase() + s1);
    System.out.printf("Uppercase reversed concatenation of %s is %s.%n", 
                      letters, upperReversed);
    String upperReversed2 = 
        letters.stream().reduce("", (s1,s2) -> s2+s1).toUpperCase();
    System.out.printf("Uppercase reversed concatenation of %s is %s.%n", 
                      letters, upperReversed2);

    Employee poorest = new Employee("None", "None", -1, -1);
    BinaryOperator<Employee> richer = (e1, e2) -> {
      return(e1.getSalary() >= e2.getSalary() ? e1 : e2);
    };
    List<Employee> googlers = EmployeeSamples.getGooglers();
    Employee richestGoogler = googlers.stream().reduce(poorest, richer);
    System.out.printf("Richest Googler is %s.%n", richestGoogler);

    List<Double> nums1a = Arrays.asList(1.2, -2.3, 4.5, -5.6);
    double maxNum1 = 
      nums1a.stream().reduce(Double.MIN_VALUE, Double::max);
    System.out.printf("Max of %s is %s.%n", nums1a, maxNum1);
    double[] nums1b = {1.2, -2.3, 4.5, -5.6};
    double maxNum2 = 
      DoubleStream.of(nums1b).max().orElse(Double.MIN_VALUE);
    System.out.printf("Max of [same numbers] is %s.%n", 
                      maxNum2);
    
    List<Integer> nums2 = Arrays.asList(1, 2, 3, 4);
    int sum1 = nums2.stream().reduce(0, Integer::sum);
    System.out.printf("Sum of %s is %s.%n", nums2, sum1);
    int sum2 = nums2.stream().reduce(Integer::sum).get();
    System.out.printf("Sum of %s is %s.%n", nums2, sum2);
    int[] nums3 = { 1, 2, 3, 4 };
    int sum3 = Arrays.stream(nums3).sum();
    System.out.printf("Sum of {1, 2, 3, 4} is %s.%n", sum3);
    
    int product = nums2.stream().reduce(1, (n1, n2) -> n1 * n2);
    System.out.printf("Product of %s is %s.%n", nums2, product);
    
    int sum4 = nums2.stream().map(EmployeeSamples::findGoogler)
                             .map(Employee::getSalary)
                             .reduce(0, Integer::sum);
    System.out.printf("Combined salaries of Googlers with IDs %s is $%,d.%n", 
                      nums2, sum4);
    int sum5 = nums2.stream().map(EmployeeSamples::findGoogler)
                             .mapToInt(Employee::getSalary)
                             .sum();
    System.out.printf("Combined salaries of Googlers with IDs %s is $%,d.%n", 
                      nums2, sum5);
  }
}

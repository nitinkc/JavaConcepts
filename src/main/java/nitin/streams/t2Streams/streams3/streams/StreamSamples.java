package nitin.streams.t2Streams.streams3.streams;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    collectExamples();
    generateExamples();
    stringJoinerExamples();
  }
  
  public static void collectExamples() {
    List<Integer> ids = Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16); // and imagine 1000 more ids
    List<Employee> emps = 
      ids.stream().map(EmployeeSamples::findGoogler)
                  .filter(e -> e != null)
                  .collect(Collectors.toList());
    System.out.printf("Googlers with ids %s: %s.%n", 
                      ids, emps);
    String lastNames = ids.stream().map(EmployeeSamples::findGoogler)
                                   .filter(e -> e != null)
                                   .map(Employee::getLastName)
                                   .collect(Collectors.joining(", "))
                                   .toString(); 
    List<Employee> googlers = EmployeeSamples.getGooglers();
    System.out.printf("Last names of Googlers with ids %s: %s.%n", 
                      ids, lastNames);
    Set<String> firstNames =
      googlers.stream().map(Employee::getFirstName)
                       .collect(Collectors.toSet());
    Stream.of("Larry", "Harry", "Peter", "Deiter", "Eric", "Barack")
            .forEach(s -> System.out.printf
                              ("%s is a Googler? %s.%n",
                               s,
                               firstNames.contains(s) ? "Yes" : "No"));
    TreeSet<String> firstNames2 =
      googlers.stream()
              .map(Employee::getFirstName)
              .collect(Collectors.toCollection(TreeSet::new));
      Stream.of("Larry", "Harry", "Peter", "Deiter", "Eric", "Barack")
            .forEach(s -> System.out.printf
                              ("%s is a Googler? %s.%n",
                               s,
                               firstNames2.contains(s) ? "Yes" : "No"));
    Map<Boolean,List<Employee>> richTable =
      googlers.stream()
              .collect(Collectors.partitioningBy(e -> e.getSalary() > 1000000));
    System.out.printf("Googlers with salaries over $1M: %s.%n", richTable.get(true));
    System.out.printf("Destitute Googlers: %s.%n", richTable.get(false));
    
    Map<String,List<Emp>> officeTable =
      EmpSamples.getSampleEmps().stream().collect(Collectors.groupingBy(Emp::getOffice));
    System.out.printf("Emps in Mountain View: %s.%n", officeTable.get("Mountain View"));
    System.out.printf("Emps in NY: %s.%n", officeTable.get("New York"));
    System.out.printf("Emps in Zurich: %s.%n", officeTable.get("Zurich"));
  }
  
  // To support the tiny StringJoiner example inside the collect examples.
  
  public static void stringJoinerExamples() {
    StringJoiner joiner1 = new StringJoiner(", ");
    String result1 =
      joiner1.add("Java").add("Lisp").add("Ruby").toString();
    System.out.println(result1);
    String result2 =
      String.join(", ", "Java", "Lisp", "Ruby");
    System.out.println(result2);
  }
  
  public static void generateExamples() {
    System.out.println("2 Random numbers:");
    Stream.generate(Math::random).limit(2).forEach(System.out::println);
    System.out.println("4 Random numbers:");
    Stream.generate(Math::random).limit(4).forEach(System.out::println);
    System.out.println("5 Fibonacci numbers:");
    FibStream.makeFibStream(5)
             .forEach(System.out::println);
    System.out.println("25 Fibonacci numbers:");
    FibStream.makeFibStream(25)
             .forEach(System.out::println);
    System.out.println("14 Twitter messages:");
    Stream.iterate("Big News!!", msg -> msg + "!!!!!!!!!!")
          .limit(14)
          .forEach(System.out::println);
    System.out.println("10 100-digit primes:");
    PrimeStream.makePrimeStream(100, 10)
               .forEach(System.out::println);
    
    BigInteger[] primes = PrimeStream.makePrimeArray(100, 5);
    for(BigInteger prime: primes) {
      System.out.println("Prime is " + prime);
    }
  }
  

  
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

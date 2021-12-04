package java8.zCoreServletsTraining.t1Lambdas.lambdas4Ex;

import java.util.Arrays;
import java.util.List;

/** Exercise solutions: higher-order methods.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java)</a>.
 */

public class FunctionExamples {
  public static void main(String[] args) {
    List<String> words = Arrays.asList("hello", "hola", "goodbye", "adios");
    
    String word1 = 
        FunctionUtils.firstAllMatch(words.stream(), 
                                    s -> s.contains("o"),
                                    s -> s.length() > 5);
    System.out.println("First word with o and 5+ letters is " + word1);
    
    String word2 = 
        FunctionUtils.firstAllMatch(words.stream(), 
                                    s -> s.contains("o"),
                                    s -> s.length() > 8);
    System.out.println("First word with o and 8+ letters is " + word2);
    
    String word3 = 
        FunctionUtils.firstAnyMatch(words.stream(), 
                                    s -> s.contains("o"),
                                    s -> s.length() > 5);
    System.out.println("First word with o or 5+ letters is " + word3);
    
    String word4 = 
        FunctionUtils.firstAnyMatch(words.stream(), 
                                    s -> s.contains("o"),
                                    s -> s.length() > 8);
    System.out.println("First word with o or 8+ letters is " + word4);
    
    String word5 = 
        FunctionUtils.firstAnyMatch(words.stream(), 
                                    s -> s.contains("q"),
                                    s -> s.length() > 8);
    System.out.println("First word with q or 8+ letters is " + word5);
  }
}

package java8.zCoreServletsTraining.t1Lambdas.lambdas3Ex;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/** Some generically-typed versions of methods that transform Lists. See
 *  StringUtils for the less flexible String-specific versions.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java)</a>.
 */

public class ElementUtils {
  public static <T> List<T> allMatches(List<T> candidates, 
                                       Predicate<T> matchFunction) {
    List<T> results = new ArrayList<>();
    for(T possibleMatch: candidates) {
      if(matchFunction.test(possibleMatch)) {
        results.add(possibleMatch);
      }
    }
    return(results); 
  }

  public static <T, R> List<R> transformedList(List<T> originals, 
                                               Function<T, R> transformer) {
    List<R> results = new ArrayList<>();
    for(T original: originals) {
      results.add(transformer.apply(original));
    }
    return(results); 
  }
  
  private ElementUtils() {} // Uninstantiatable class
}

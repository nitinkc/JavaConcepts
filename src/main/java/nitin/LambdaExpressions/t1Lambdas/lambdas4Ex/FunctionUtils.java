package nitin.LambdaExpressions.t1Lambdas.lambdas4Ex;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class FunctionUtils {
  
  /** Returns a Predicate that is the result of ANDing all the argument Predicates.
   *  If no Predicates are supplied, it returns a Predicate that always returns
   *  true.
   */
  
  // @SafeVarargs is difficult to understand. The issue is that it is not always safe to use varargs for generic types: 
  // the resultant array can have runtime type problems if you modify entries in it. 
  // @SafeVarargs says "I am not doing anything dangerous, please suppress the compiler warnings".  
  // For details, see http://docs.oracle.com/javase/7/docs/technotes/guides/language/non-reifiable-varargs.html
  
  @SafeVarargs
  public static <T> Predicate<T> allPassPredicate(Predicate<T>... tests) {
    Predicate<T> result = e -> true;
    for(Predicate<T> test: tests) {
      result = result.and(test);
    }
    return(result);
  }
  
  /** Returns first element that matches all of the tests, null otherwise. */
  
  @SafeVarargs
  public static <T> T firstAllMatch(Stream<T> elements, Predicate<T>... tests) {
    Predicate<T> combinedTest = allPassPredicate(tests);
    return(elements.filter(combinedTest)
                   .findFirst()
                   .orElse(null));
  }
  
  /** Returns a Predicate that is the result of ORing all the argument Predicates.
   *  If no Predicates are supplied, it returns a Predicate that always returns
   *  false.
   */
  @SafeVarargs
  public static <T> Predicate<T> anyPassPredicate(Predicate<T>... tests) {
    Predicate<T> result = e -> false;
    for(Predicate<T> test: tests) {
      result = result.or(test);
    }
    return(result);
  }
  
  /** Returns first element that matches any of the tests, null otherwise. */
  
  @SafeVarargs
  public static <T> T firstAnyMatch(Stream<T> elements, Predicate<T>... tests) {
    Predicate<T> combinedTest = anyPassPredicate(tests);
    return(elements.filter(combinedTest)
                   .findFirst()
                   .orElse(null));
  }
  
  private FunctionUtils() {} // Uninstantiatable class
}

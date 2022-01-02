package java.LambdaExpressions.t1Lambdas.lambdas2Ex;

/** An interface for which lambdas can be used. See StringUtils for
 *  examples of USING this interface in code, which are more or less the same
 *  as in Java 7. But, see IsBetterExamples for examples of PASSING IN
 *  instances of this interface, where now in Java 8 you can use lambdas.
 *  Also see TwoStringPredicate for a weaker version of this interface
 *  that works only for Strings.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java)</a>.
 */
 
@FunctionalInterface
public interface TwoElementPredicate<T> {
  /** Returns true if the first entry is "better" than the second one,
   *  returns false otherwise. Concrete classes (or lambdas) that implement
   *  this interface give meaning to their definition of "better".
   */
  boolean isBetter(T element1, T element2);
}

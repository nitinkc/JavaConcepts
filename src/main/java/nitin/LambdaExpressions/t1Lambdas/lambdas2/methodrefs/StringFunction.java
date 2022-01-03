package nitin.LambdaExpressions.t1Lambdas.lambdas2.methodrefs;

/** A simple interface that will be used to demonstrate
 *  the equivalence of method references to explicit lambdas.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java)</a>.
 */

@FunctionalInterface
public interface StringFunction {
  String applyFunction(String s);
}

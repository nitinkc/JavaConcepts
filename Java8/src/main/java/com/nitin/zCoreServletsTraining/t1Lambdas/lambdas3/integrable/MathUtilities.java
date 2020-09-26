package com.nitin.zCoreServletsTraining.t1Lambdas.lambdas3.integrable;

import java.util.function.*;

/** A numerical integration routine. Minor variation of previous versions,
 *  which uses the builtin DoubleUnaryOperator interface
 *  instead of the Integrable interface that we defined ourselves. 
 *  Notice the point that code that USES an interface (this code) must
 *  know the real interface name and name of the method in the interface, so
 *  changing from Integrable to DoubleUnaryOperator also requires changing
 *  function.eval to function.applyAsDouble. It is the code that CALLS these
 *  methods that can supply a lambda, and that calling code does not change
 *  when we switch from Integrable to DoubleUnaryOperator.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java)</a>.
 */

public class MathUtilities {
  public static double integrate(DoubleUnaryOperator function, double x1, double x2, int numSlices) {
    if (numSlices < 1) {
      numSlices = 1;
    }
    if (x2 < x1) {
      double temp = x1;
      x1 = x2;
      x2 = temp;
    }
    double delta = (x2 - x1)/numSlices;
    double start = x1 + delta/2;
    double sum = 0;
    for(int i=0; i<numSlices; i++) {
      sum += delta*function.applyAsDouble(start + delta*i);
    }
    return(sum);
  }
  
  public static void integrationTest(DoubleUnaryOperator function, double x1, double x2) {
    for(int i=1; i<7; i++) {
      int numSlices = (int)Math.pow(10, i);
      double result = MathUtilities.integrate(function, x1, x2, numSlices);
      System.out.printf("  For numSlices =%,10d result = %,.8f%n", numSlices, result);
    }
  }
  
  public static void printExpectedAnswer(double x1, double x2,
                                         String functName, String resultDescription,
                                         double exactAnswer) {
    System.out.printf("%nEstimating integral of %s from %.3f to %.3f.%n", functName, x1, x2);
    System.out.printf("Exact answer = %s.%n", resultDescription);
    System.out.printf("                                  ~= %,.8f.%n", exactAnswer);
  }
  
  private MathUtilities() {}  // Uninstantiatable class: static methods only
}

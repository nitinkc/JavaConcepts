package java.zCoreServletsTraining.t1Lambdas.lambdas2.integrable;

/** A numerical integration routine. This is the same in EVERY way
 *  as it would have been in Java 7. The difference in Java 8 is
 *  in the code that *calls* integrate or integrationTest.
 *  <p>
 *  This is the original version, which uses the Integrable interface
 *  we defined ourselves. In later sections we will use the
 *  the builtin DoubleUnaryOperator interface instead.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java)</a>.
 */
public class MathUtilities {
  public static double integrate(Integrable function, double x1, double x2, int numSlices) {
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
      sum += delta*function.eval(start + delta*i);
    }
    return(sum);
  }
  
  public static void integrationTest(Integrable function, double x1, double x2) {
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
  
  private MathUtilities() {}  // Class cannot be instantiated
}

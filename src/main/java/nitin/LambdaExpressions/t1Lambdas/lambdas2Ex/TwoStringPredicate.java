package nitin.LambdaExpressions.t1Lambdas.lambdas2Ex;

/**
 * An interface for which lambdas can be used. See StringUtils for
 * examples of USING this interface in code, which are more or less the same
 * as in Java 7. But, see IsBetterExamples for examples of PASSING IN
 * instances of this interface, where now in Java 8 you can use lambdas.
 * Also see TwoElementPredicate for a genericized version of this interface.
 * <p>
 * From <a href="http://courses.coreservlets.com/Course-Materials/">the
 * coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 * Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 * servlets, JSP, Java 8 lambdas and streams (for those that know Java already),
 * and Java 8 programming (for those new to Java)</a>.
 */

// Adding the following annotation does not change the behavior of CORRECT
// code in any way. But, see the "blah" method at the bottom.
@FunctionalInterface
public interface TwoStringPredicate {
    /**
     * Returns true if the first String is "better" than the second one,
     * returns false otherwise. Concrete classes (or lambdas) that implement
     * this interface give meaning to their definition of "better".
     */
    boolean isBetter(String s1, String s2);

    // Using @FunctionalInterface means that if you try to add a second
    // method (as below), you will get a compile-time error in this interface.
    // public void blah();
}

package nitin.LambdaExpressions.t1Lambdas.lambdas1Ex;

/**
 * An interface for which lambdas can be used. See StringUtils for
 * examples of USING this interface in code, which are the same
 * as in Java 7. But, see IsBetterExamples for examples of PASSING IN
 * instances of this interface, where now in Java 8 you can use lambdas.
 * Also see TwoElementPredicate for a genericized version of this interface,
 * and see the next solution set, where we add in the @FunctionalInterface annotation.
 * <p>
 * From <a href="http://courses.coreservlets.com/Course-Materials/">the
 * coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 * Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 * servlets, JSP, Java 8 lambdas and streams (for those that know Java already),
 * and Java 8 programming (for those new to Java)</a>.
 */

public interface TwoStringPredicate {
    /**
     * Returns true if the first String is "better" than the second one,
     * returns false otherwise. Concrete classes (or lambdas) that implement
     * this interface give meaning to their definition of "better".
     */
    boolean isBetter(String s1, String s2);
}

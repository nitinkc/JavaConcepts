package nitin.LambdaExpressions.t1Lambdas.lambdas2Ex;

/**
 * Method that uses the generic TwoElementPredicate, rather than the
 * String-specific TwoStringPredicate.
 * <p>
 * From <a href="http://courses.coreservlets.com/Course-Materials/">the
 * coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 * Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 * servlets, JSP, Java 8 lambdas and streams (for those that know Java already),
 * and Java 8 programming (for those new to Java)</a>.
 */

public class ElementUtils {
    public static <T> T betterElement(T element1, T element2,
                                      TwoElementPredicate<T> tester) {
        if (tester.isBetter(element1, element2)) {
            return (element1);
        }
        return (element2);
    }

    private ElementUtils() {
    } // Uninstantiatable class; contains only static methods.
}

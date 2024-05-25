package nitin.LambdaExpressions.t1Lambdas.lambdas3Ex;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Some String-specific versions of methods that transform Lists. See
 * ElementUtils for the better, generically-typed versions.
 * <p>
 * From <a href="http://courses.coreservlets.com/Course-Materials/">the
 * coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 * Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 * servlets, JSP, Java 8 lambdas and streams (for those that know Java already),
 * and Java 8 programming (for those new to Java)</a>.
 */

public class StringUtils {
    private StringUtils() {
    } // Uninstantiatable class

    public static List<String> allMatches(List<String> candidates,
                                          Predicate<String> matchFunction) {
        List<String> results = new ArrayList<>();
        for (String possibleMatch : candidates) {
            if (matchFunction.test(possibleMatch)) {
                results.add(possibleMatch);
            }
        }
        return (results);
    }

    public static List<String> transformedList(List<String> originals,
                                               Function<String, String> transformer) {
        List<String> results = new ArrayList<>();
        for (String original : originals) {
            results.add(transformer.apply(original));
        }
        return (results);
    }
}

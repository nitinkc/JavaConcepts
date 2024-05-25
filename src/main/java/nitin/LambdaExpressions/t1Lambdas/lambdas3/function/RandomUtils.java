package nitin.LambdaExpressions.t1Lambdas.lambdas3.function;

import java.util.Random;

/**
 * An example to demonstrate writing your own generic method.
 * <p>
 * From <a href="http://courses.coreservlets.com/Course-Materials/">the
 * coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 * Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 * servlets, JSP, Java 8 lambdas and streams (for those that know Java already),
 * and Java 8 programming (for those new to Java)</a>.
 */
public class RandomUtils {
    private static final Random r = new Random();

    /**
     * Return a random int from 0 to range-1. So, randomInt(4)
     * returns any of 0, 1, 2, or 3.
     */

    public static int randomInt(int range) {
        return (r.nextInt(range));
    }

    /**
     * Return a random index of an array.
     */

    public static int randomIndex(Object[] array) {
        return (randomInt(array.length));
    }

    /**
     * Return a random element from an array.
     * Uses generics, so no typecast is required
     * for the return value.
     */

    public static <T> T randomElement(T[] array) {
        return (array[randomIndex(array)]);
    }
}

package nitin.LambdaExpressions.t1Lambdas.lambdas4.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Some methods to illustrate use of the default or static methods (i.e., the non-abstract)
 * methods of Function, Predicate, etc.
 * <p>
 * From <a href="http://courses.coreservlets.com/Course-Materials/">the
 * coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 * Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 * servlets, JSP, Java 8 lambdas and streams (for those that know Java already),
 * and Java 8 programming (for those new to Java)</a>.
 */

public class FunctionUtils {
    /**
     * Returns first entry from list that passes the match function. This is
     * a generalized version of EmployeeUtils.firstMatchingEmployee.
     */
    public static <T> T firstMatch(List<T> candidates, Predicate<T> matchFunction) {
        for (T possibleMatch : candidates) {
            if (matchFunction.test(possibleMatch)) {
                return (possibleMatch);
            }
        }
        return (null);
    }

    /**
     * Returns a List of all entries from input list that pass the match function.
     * The result could be an empty List, but not null. This is very similar
     * to the builtin "filter" method of Stream.
     */
    public static <T> List<T> allMatches(List<T> candidates, Predicate<T> matchFunction) {
        List<T> matches = new ArrayList<>();
        for (T possibleMatch : candidates) {
            if (matchFunction.test(possibleMatch)) {
                matches.add(possibleMatch);
            }
        }
        return (matches);
    }

    // @SafeVarargs is difficult to understand. The issue is that it is not always safe to use varargs for generic types:
    // the resultant array can have runtime type problems if you modify entries in it.
    // But, if you only read the values and never modify them, varargs is perfectly safe.
    // @SafeVarargs says "I am not doing anything dangerous, please suppress the compiler warnings".
    // For details, see http://docs.oracle.com/javase/8/docs/technotes/guides/language/non-reifiable-varargs.html

    /**
     * Returns a Predicate that is the result of ANDing all the argument Predicates.
     * If no Predicates are supplied, it returns a Predicate that always returns
     * true. This method and allMatches2 are given here without much explanation,
     * but are discussed in detail in the section on File I/O.
     */

    @SafeVarargs
    public static <T> Predicate<T> combinedPredicate(Predicate<T>... tests) {
        Predicate<T> result = e -> true;
        for (Predicate<T> test : tests) {
            result = result.and(test);
        }
        return (result);
    }

    /**
     * Returns a List of all entries from input list that pass ALL the match functions.
     */
    @SafeVarargs
    public static <T> List<T> allMatches2(List<T> candidates, Predicate<T>... matchFunctions) {
        Predicate<T> combinedTest = combinedPredicate(matchFunctions);
        return (allMatches(candidates, combinedTest));
    }

    /**
     * Returns a List with the given function applied to each element.
     * Very similar to the built-in "map" method of Streams.
     */

    public static <T, R> List<R> transform(List<T> origValues,
                                           Function<T, R> transformer) {
        List<R> transformedValues = new ArrayList<>();
        for (T value : origValues) {
            transformedValues.add(transformer.apply(value));
        }
        return (transformedValues);
    }

    /**
     * Returns a List with the given functions applied. The functions
     * must all map their argument to an output of the SAME type (i.e., Function&lt;T,T&gt;).
     */

    // @SafeVarargs is difficult to understand. The issue is that it is not always safe to use varargs for generic types:
    // the resultant array can have runtime type problems if you modify entries in it.
    // @SafeVarargs says "I am not doing anything dangerous, please suppress the compiler warnings".
    // For details, see http://docs.oracle.com/javase/8/docs/technotes/guides/language/non-reifiable-varargs.html
    @SafeVarargs
    public static <T> List<T> transform2(List<T> origValues,
                                         Function<T, T>... transformers) {
        Function<T, T> composedFunction = composeAll(transformers);
        return (transform(origValues, composedFunction));
    }

    /**
     * Returns composition of given functions. Given 0 or more functions,
     * returns a new function that is a composition of them, in order. The functions
     * must all map their argument to an output of the SAME type (i.e., Function&lt;T,T&gt;).
     */
    @SafeVarargs
    public static <T> Function<T, T> composeAll(Function<T, T>... functions) {
        Function<T, T> result = Function.identity();
        for (Function<T, T> f : functions) {
            result = result.compose(f);
        }
        return (result);
    }

    /**
     * Calls the function on each element of the List. Like the builtin
     * forEach method of Stream and of List, which we have not yet covered.
     * Used to illustrate the andThen method of Consumer.
     */
    public static <T> void processEntries(List<T> entries, Consumer<T> operation) {
        for (T e : entries) {
            operation.accept(e);
        }
    }

    public FunctionUtils() {
    } // Uninstantiatable class; static methods only
}

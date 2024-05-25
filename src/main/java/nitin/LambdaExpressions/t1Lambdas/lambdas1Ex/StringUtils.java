package nitin.LambdaExpressions.t1Lambdas.lambdas1Ex;

public class StringUtils {
    private StringUtils() {
    } // Uninstantiatable class; contains only static methods.

    public static String betterString(String s1, String s2,
                                      TwoStringPredicate tester) {
        if (tester.isBetter(s1, s2)) {
            return (s1);
        } else {
            return (s2);
        }
    }
}

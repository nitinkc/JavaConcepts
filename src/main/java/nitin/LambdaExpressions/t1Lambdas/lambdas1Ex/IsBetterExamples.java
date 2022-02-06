package nitin.LambdaExpressions.t1Lambdas.lambdas1Ex;

public class IsBetterExamples {
    public static void main(String[] args) {
        String test1 = "Hello";
        String test2 = "Goodbye";
        String message = "Better of %s and %s based on %s is %s.%n";
        String result1 =
                StringUtils.betterString(test1, test2,
                        (s1, s2) -> s1.length() > s2.length());
        System.out.printf(message, test1, test2, "length", result1);
        String result2 =
                StringUtils.betterString(test1, test2, (s1, s2) -> true);
        System.out.printf(message, test1, test2, "1st arg", result2);
        String result3 =
                ElementUtils.betterElement(test1, test2,
                        (s1, s2) -> s1.length() > s2.length());
        System.out.printf(message, test1, test2, "length", result3);
        String result4 =
                ElementUtils.betterElement(test1, test2, (s1, s2) -> true);
        System.out.printf(message, test1, test2, "1st arg", result4);
        int result5 =
                ElementUtils.betterElement(1, 2, (n1, n2) -> n1 > n2);
        System.out.printf(message, 1, 2, "numeric size", result5);
    }
}

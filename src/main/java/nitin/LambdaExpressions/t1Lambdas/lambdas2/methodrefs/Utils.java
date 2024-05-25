package nitin.LambdaExpressions.t1Lambdas.lambdas2.methodrefs;

public class Utils {
    private Utils() {
    }

    public static String transform(String s, StringFunction f) {
        return (f.applyFunction(s));
    }

    public static String makeExciting(String s) {
        return (s + "!!");
    }
}

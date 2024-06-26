package nitin.LambdaExpressions.t1Lambdas.lambdas4.function;

public class PersonUtils {
    private static final String[] possibleFirstNames =
            {"Andrea", "Brad", "Cathy", "David", "Erin", "Frank"};
    private static final String[] possibleLastNames =
            {"Anderson", "Bradley", "Carson", "Donaldson", "Evans", "Fisher"};

    private PersonUtils() {
    }

    public static String randomFirstName() {
        return (RandomUtils.randomElement(possibleFirstNames));
    }

    public static String randomLastName() {
        return (RandomUtils.randomElement(possibleLastNames));
    }

    // Uninstantiatable class
}

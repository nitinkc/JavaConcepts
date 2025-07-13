package nitin.zKnowYourJava;

import java.util.List;

public class T5StreamLazyEvaluation {
    public static void main(String[] args) {
        Integer multiplier =
                2; // error: local variables referenced from a lambda expression must be final or
        // effectively final
        final int finalMultiplier =
                multiplier; // Either use the final variable so that no mutation can happen
        int[] factor = new int[] {2};

        var numbers = List.of(1, 2, 3);
        var stream =
                numbers.stream()
                        // .map(number -> number * finalMultiplier)
                        .map(number -> factor[0]); // Does not evaluate yet, as there is no
        // terminal operator

        // multiplier = 0;//Mutating the multiplier
        // finalMultiplier = 0;//Can't happen
        factor[0] = 0;

        stream.forEach(System.out::println); // Evaluates here
    }
}

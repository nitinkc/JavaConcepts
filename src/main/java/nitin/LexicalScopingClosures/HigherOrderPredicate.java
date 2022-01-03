package nitin.LexicalScopingClosures;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class HigherOrderPredicate {

    // Method returning a function. Filter accepts a Predicate & this method is
    // made to return a predicate, to be used within filter
    /* LEXICAL SCOPING : vriable letter has lexical scoping*/
    public static Predicate<String> checkIfStartsWith(final String letter) {
        return name -> name.startsWith(letter);
    }

    public static final List<String> namesList = Arrays.asList("Adrian", "Briana", "Chetan", "Neil", "Nitin", "Mukesh");

    public static void main(final String[] args) {

        //Simple Predicates
        final Predicate<String> startsWithN = name -> name.startsWith("N");
        final Predicate<String> startsWithB = name -> name.startsWith("B");

        System.out.println("Block 1");
        System.out.println(namesList.stream().filter(startsWithN).count());
        System.out.println(namesList.stream().filter(startsWithB).count());

        System.out.println("Block 2");
        System.out.println(namesList.stream().filter(checkIfStartsWith("A")).count());
        System.out.println(namesList.stream().filter(checkIfStartsWith("B")).count());


        // Function, taking in a String and returning a Predicate, as expected by a filter
        final Function<String, Predicate<String>> startsWithLetterFunction =
                (String letter) -> {
                    Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
                    return checkStarts;
                };

        System.out.println("Block 3");
        System.out.println(namesList.stream().filter(startsWithLetterFunction.apply("N")).count());
        System.out.println(namesList.stream().filter(startsWithLetterFunction.apply("B")).count());


        // Higher Order function :: Function returning a function. Same as block 3 function
        final Function<String, Predicate<String>> startsWithLetter =
                (String letter) -> (String name) -> name.startsWith(letter);

        System.out.println("Block 4");
        System.out.println(namesList.stream().filter(startsWithLetter.apply("N")).count());
        System.out.println(namesList.stream().filter(startsWithLetter.apply("B")).count());

        // Higher Order function :: Function returning a function, with concise code
        //Same as block 3 and 4 Functions
        final Function<String, Predicate<String>> startsWithLetterConcise =
                letter -> name -> name.startsWith(letter);

        System.out.println("Block 5");
        System.out.println(namesList.stream().filter(startsWithLetterConcise.apply("N")).count());
        System.out.println(namesList.stream().filter(startsWithLetterConcise.apply("B")).count());
    }
}
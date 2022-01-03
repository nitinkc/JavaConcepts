package nitin.interfaces.functionalInterface.PredefinedFunctionalInterfaces.functionUsage;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by nitin on Tuesday, October/08/2019 at 9:01 PM
 * Converting the Strings into integers using a function
 */
public class FunctionUsage {
    public static final int DEFAULT_VALUE = 9999;

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3", "n", "", null);

        // Function to convert Strings to Int, put 9999 as default value for other cases
        Function<String, Integer> function = x -> NumberUtils.toInt(x, DEFAULT_VALUE);

        Predicate<Integer> predicate = (Integer x) -> (x == DEFAULT_VALUE);
        //MAP is used to apply a function
        list
                .stream()
                .map(function)
                .forEach(System.out::print);

        //all the numbers except for the default replacement number
        list.stream()
                .map(function)
                .filter(predicate.negate())
                .forEach(System.out::println);
    }
}

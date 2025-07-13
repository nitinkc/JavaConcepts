package nitin.LambdaExpressions;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Created by nichaurasia Created on Sunday, December/20/2020 at 5:43 PM
 */
public class LocalVarLambda {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", null);

        String result =
                list.stream()
                        // .map(x -> x.toUpperCase())
                        .filter(Objects::nonNull)
                        .map((var x) -> x.toUpperCase())
                        .collect(Collectors.joining(","));
        System.out.println(result);
    }
}

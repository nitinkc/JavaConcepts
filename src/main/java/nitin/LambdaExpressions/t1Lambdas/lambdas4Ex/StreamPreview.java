package nitin.LambdaExpressions.t1Lambdas.lambdas4Ex;

import java.util.Arrays;
import java.util.List;

public class StreamPreview {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hi", "hello", "bye", "goodbye");
        String s1 = words.stream()
                .filter(word -> word.contains("o"))
                .findFirst()
                .orElse(null);
        System.out.println(s1);
        String s2 = words.stream()
                .filter(word -> word.length() > 5)
                .findFirst()
                .orElse(null);
        System.out.println(s2);
    }
}

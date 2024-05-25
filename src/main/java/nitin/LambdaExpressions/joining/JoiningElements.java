package nitin.LambdaExpressions.joining;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nitin on Thursday, February/13/2020 at 9:50 PM
 */
public class JoiningElements {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("John", "Doe", "Jane", "Dow", "Yong", "Lee");

        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i) + ",");
        }
        System.out.println(list.get(list.size() - 1));

        System.out.println();
        // No more Off-By-One Error
        System.out.println(String.join(", ", list));

        String list2 = list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(" && "));

        System.out.println(list2);
    }
}

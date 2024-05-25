package nitin.zKnowYourJava;

import java.util.List;
import java.util.stream.Collectors;

public class T9toList {
    public static void main(String[] args) {
        //Which is better : toList or .collect(Collectors.toList())
        var result = List.of(1, 2, 3).stream()
                .map(num -> num * 2)
                //.toList();
                //.collect(Collectors.toList());//Mutable
                .collect(Collectors.toUnmodifiableList());//Immutable

        //result.add(800);
        System.out.println(result.getClass());
        System.out.println(result);
    }
}

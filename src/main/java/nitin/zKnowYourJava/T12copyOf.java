package nitin.zKnowYourJava;

import java.util.Arrays;
import java.util.List;

public class T12copyOf {
    public static void main(String[] args) {
        var list1 = Arrays.asList(1,2,3);
        var list2 = List.of(1,2);

        System.out.println(list1 == List.copyOf(list1));
        System.out.println(list2 == List.copyOf(list2));
    }
}

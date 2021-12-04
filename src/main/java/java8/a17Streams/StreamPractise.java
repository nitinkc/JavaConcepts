package java8.a17Streams;

import java.util.Arrays;
import java.util.List;

/**
 * Created by nichaurasia on Thursday, January/16/2020 at 5:16 PM
 */

public class StreamPractise {
    public static void main(String[] args) {

        m1();
    }

    private static void m1() {
        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11);

        // Double the Odd numbers and print the final sum
        int result = intList.stream()
                .filter(x->x%2 == 0)
                .map(y-> y*2)
                .reduce((a,b) -> a+b)
                .get();

        System.out.println(result);
    }
}

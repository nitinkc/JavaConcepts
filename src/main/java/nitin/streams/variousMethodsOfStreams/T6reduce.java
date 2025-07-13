package nitin.streams.variousMethodsOfStreams;

import java.util.List;

/** Created by Nitin C on 3/3/2016. */
public class T6reduce {
    public static void main(String[] args) {
        m1();
        m2();
    }

    public static void m1() {
        List<String> arr = List.of("n", "i", "t", "i", "n");

        String name = arr.stream().reduce("", String::concat);

        System.out.println(name);
    }

    public static void m2() {
        List<Integer> intStream = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Integer reduced = intStream.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduced);
    }
}

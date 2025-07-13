package sandbox;

import java.util.List;

public class AsyncFuture {

    public static void main(String[] args) {
        int[] factor = new int[] {2};

        var numbers = List.of(1, 2, 3);
        var stream = numbers.stream().map(number -> number * factor[0]);

        factor[0] = 0;

        stream.forEach(System.out::println); // Evaluates here
    }
}

package nitin.zOReiley2020SimonRoberts;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class SumIntStream {
    public static void main(String[] args) {
        OptionalInt sum = IntStream.iterate(0, x -> x + 1)
                .limit(100)
                .reduce((a, b) -> a + b);
        sum.ifPresent(v -> System.out.println("sum is " + v));
    }
}

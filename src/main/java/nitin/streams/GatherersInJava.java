package nitin.streams;

import java.util.List;
import java.util.stream.Gatherers;

public class GatherersInJava {

    public static void main(String[] args) {
        var numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        var result =
                numbers.stream()
                        .gather(Gatherers.scan(() -> 0, Integer::sum))
                        .reduce(Integer::sum)
                        .orElse(0);

        System.out.println(result);
    }
}

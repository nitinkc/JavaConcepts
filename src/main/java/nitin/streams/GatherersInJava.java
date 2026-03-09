package nitin.streams;

import java.util.List;
import java.util.stream.Gatherers;

public class GatherersInJava {

  static void main() {
    var numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9,10);
    var result = numbers.stream()
        .gather(Gatherers.scan(() -> 0, Integer::sum))
        .reduce(Integer::sum);

    System.out.println(result);
  }

}

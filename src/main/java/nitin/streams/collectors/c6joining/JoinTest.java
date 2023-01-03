package nitin.streams.collectors.c6joining;

import java.util.List;
import java.util.stream.Collectors;

public class JoinTest {
    public static void main(String[] args) {
        List<String> strings = List.of("java", "is", "cool");
        String message = String.join(" ", strings);
        System.out.println(message);//Java is cool

        String test = strings.stream()
                .collect(Collectors.joining(","));
        System.out.println(test);//java,is,cool
    }
}

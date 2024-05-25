package nitin.a6oops.interfaces.functionalInterface.PredefinedFunctionalInterfaces.consumerUsage;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;

/**
 * Created by nitin on Tuesday, October/08/2019 at 10:00 PM
 */
public class ConsumerUsage {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("test", "this", "is", "a", "test", "this", "test", "is", "not", "complex");

        //Consumer<String> c = s -> System.out.print(s + " ,");
        //Consumer<String> c = System.out::println;

        strList.stream()
                .filter(s -> s.length() < 6)
                .forEach(s -> System.out.print(s + " ,"));
        System.out.println();

        Map<String, Integer> map = new TreeMap<>();
        //BiConsumer<String,Integer> b1 = map::put;
        Consumer<String> b2 = (k) -> {
            if (map.containsKey(k)) {
                map.put(k, map.get(k) + 1);
            } else {
                map.put(k, 1);
            }
        };

        //Passing 0 as the default key, it actually gets calculated while evaluated in biConsumer
        strList.forEach(y -> b2.accept(y));

        System.out.println(map);
    }
}

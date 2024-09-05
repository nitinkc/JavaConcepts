package nitin.optionals;

import java.util.Optional;

/**
 * Created by nichaurasia on Monday, June/01/2020 at 10:52 PM
 */

public class O3applyMapWithOptional {

    public static void main(String[] args) {
        simpleDemo();
        demo2();
    }

    private static void demo2() {
        String[] cities = {("New York"), (null), ("Los Angeles"), ("Chicago")};

        for (String city : cities) {
            //Another Example, in a loop, adding city name from the Object obj and appending a comma if the city exist, else leaving the city name.
            String test1 = Optional.ofNullable(city).isPresent() ? city.toUpperCase() + "," : "NO_CITY";
            //System.out.println(test1);
        }

        System.out.println("Optional With Map");
        for (String city : cities) {
            // Using Map, avoiding ternary operator
            String str2 = Optional.ofNullable(city)
                    .map(obj -> obj.toUpperCase() + ",")//Advantage of using map
                    .orElse("NO_CITY");
            System.out.println(str2);
        }
    }

    private static void simpleDemo() {
        Optional<String> stringOptional = Optional.of("Testing");
        //map - ACCEPTS A FUNCTION, TAKES SOME ARGUMENT AND PERFORM ACTION ON IT
        Optional<String> map = stringOptional.map(x -> x.toUpperCase());
        System.out.println(map.get());

        Optional<String> emptyStringOptional = Optional.empty();
        String emptyMap = emptyStringOptional
                .map(x -> x.toUpperCase())
                .orElse("Empty Map");
        System.out.println(emptyMap);
    }
}

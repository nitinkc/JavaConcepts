package nitin.Optionals;

import java.util.HashMap;
import java.util.Map;

public class OptionalWithMap {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Nitin");
        map.put(2, "Kirti");

        String test = map.get(5);

        System.out.println((String) test);
    }
}

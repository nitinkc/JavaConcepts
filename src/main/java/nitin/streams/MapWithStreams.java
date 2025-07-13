package nitin.streams;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapWithStreams {
    public static void main(String[] args) {
        String str =
                "I felt happy because I saw the others were happy and because I knew I should feel happy, but I wasn’t really happy.";
        Map<String, Integer> map = new HashMap<>();

        for (String s : str.split(" ")) { // String array
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        Map<String, Integer> filteredMap =
                map.entrySet().stream()
                        .filter(entry -> entry.getValue() > 1)
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        // Use map.forEach to iterate over the map entries
        filteredMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}

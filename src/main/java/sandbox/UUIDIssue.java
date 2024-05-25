package sandbox;

import com.utilities.UuidUtils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class UUIDIssue {
    public static void main(String[] args) {

        String numberAsString = "00693";
        UUID uuidString = null;

        try {
            uuidString = UUID.fromString(numberAsString);
        } catch (IllegalArgumentException e) {
            System.err.println(e);
        }
        System.out.println(uuidString);

        try {
            uuidString = UUID.nameUUIDFromBytes(numberAsString.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(uuidString);

        getUuidFromList();
    }

    private static void getUuidFromList() {
        List<String> idList = Arrays.asList("00693", "12345", "11016", null, "00693");

        //Removing duplicates as Map cannot have 2 identical keys
        idList = idList
                .stream()
                .distinct()
                .collect(Collectors.toList());

        //Removing nulls
        idList.removeIf(element -> element == null);

        Map<String, String> idToIdMap = UuidUtils.getIdToIdMap(idList);
        System.out.println(idToIdMap.toString());
    }
}

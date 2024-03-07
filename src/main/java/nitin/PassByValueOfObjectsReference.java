package nitin;

import java.util.ArrayList;
import java.util.List;

public class PassByValueOfObjectsReference {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Venus");
        list.add("Earth");
        modify(list);
        System.out.println(list);
    }

    private static void modify(List<String> data) {
        String value = "Mars";
        data.add(value);
    }
}

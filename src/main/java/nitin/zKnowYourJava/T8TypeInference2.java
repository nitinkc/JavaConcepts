package nitin.zKnowYourJava;

import java.util.List;

public class T8TypeInference2 {
    public static void main(String[] args) {
        var list =
                List.<Object>of(
                        2,
                        3.14,
                        "text",
                        new StringBuilder("edit")); // Objects, Serializable and Comparable

        // Type witness or Type hint
        // var list = List.<Object>of(2, 3.14, "text", new StringBuilder("edit"));//
        // java.lang.UnsupportedOperationException
        // List<Object> list = List.of(2, 3.14, "text", new StringBuilder("edit"));//
        // java.lang.UnsupportedOperationException

        try {
            list.add(new T8TypeInference2());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

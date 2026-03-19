package nitin.a4flowControl;

import java.util.Arrays;
import java.util.List;

/** Created by Nitin Chaurasia on Friday, June/05/2020 at 2:52 AM */
public class SwitchExpressions {
    static final List<String> ANEMIA_LABS =
            Arrays.asList(
                    "HEMOGLOBIN", // Sort Order based on Array Index. 0 = lowest, array.size()-1 =
                    // biggest
                    "IRON SATURATION",
                    "FERRITIN",
                    "IRON",
                    "MCV",
                    "RETIC COUNT",
                    "ABSOLUTE RETIC COUNT",
                    "WBC");

    static void main(String[] args) {
        // testLabs();
        // testDays();
        testProcess();
    }

    private static void testProcess() {
        System.out.println(process("Nitin"));
        System.out.println(process(10));
        System.out.println(process(3));
        System.out.println(process(null));
        System.out.println(process(5.5));
        System.out.println(process(100L));
        System.out.println(process(true));
    }

    private static void testDays() {
        String day = "M";

        System.out.println(getString(day));
    }

    private static void testLabs() {
        String day = "sun";

        // System.out.println(getString(day));

        for (String lab : ANEMIA_LABS) {
            System.out.println(getString2(lab));
        }
    }

    private static String getString(String day) {
        String result =
                switch (day) {
                    case "M", "W", "F" -> "Monday Wednesday Friday";
                    case "Tuesday", "TH", "Sat" -> "Tuesday Thursday Saturday";
                    default -> {
                        if (day.isEmpty()) yield "Please insert a valid day";
                        else yield "Sunday";
                    }
                };
        return result;
    }

    private static String getString2(String str) {

        return switch (str) {
            case "IRON" -> "Iron Lab";
            case "FERRITIN" -> "FERRITIN Lab";
            default -> {
                if (ANEMIA_LABS.isEmpty()) yield "Please insert a valid day";
                else yield "Invalid Labs";
            }
        };
    }

    public static String process(Object obj) {
        return switch (obj) {
            case String s -> "It's a string: " + s;
            case Integer i when i > 5 -> "> than 5 " + i; // Guarded pattern
            case Integer i ->
                    "Integer integer: "
                            + i; // LAbel Dominance if swapped with previous line : Label is
                // dominated by a preceding case label 'Integer i'
            case null -> "It's null";
            case Double d -> "It's a double: "; // Primitive type matching
            case Long l -> "It's a long: "; // Primitive type matching
            default -> "Unknown type: " + obj.getClass().getName();
        };
    }
}

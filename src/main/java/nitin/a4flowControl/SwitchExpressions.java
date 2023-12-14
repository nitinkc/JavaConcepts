package nitin.a4flowControl;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Nitin Chaurasia on Friday, June/05/2020 at 2:52 AM
 */

public class SwitchExpressions {
    public static void main(String[] args) {
        String day = "sun";

        String result = getString(day);
        System.out.println(result);

        final List<String> ANEMIA_LABS = Arrays.asList("HEMOGLOBIN (g/dL)",//Sort Order based on Array Index. 0 = lowest, array.size()-1 = biggest
                "IRON SATURATION (%)",
                "FERRITIN (ng/mL)",
                "IRON (ug/dL)",
                "MCV (fL)",
                "RETIC COUNT (%)",
                "ABSOLUTE RETIC COUNT (x 10'6 cells/uL)",
                "WBC (x 10'3 cells/uL)");

    }

    private static String getString(String day) {
        String result = switch (day) {
            case "M", "W", "F" -> "Monday Wednesday Friday";
            case "Tuesday", "TH", "Sat" -> "Tuesday Thursday Saturday";
            default -> {
                if (day.isEmpty())
                    yield "Please insert a valid day";
                else
                    yield "Sunday";
            }
        };
        return result;
    }

    private static String getString2(List<String> str) {
        String result = switch (str) {
            case "Iron" -> "No 1";
            case  -> "Tuesday Thursday Saturday";
            default -> {
                if (day.isEmpty())
                    yield "Please insert a valid day";
                else
                    yield "Sunday";
            }
        };
        return result;
    }
}

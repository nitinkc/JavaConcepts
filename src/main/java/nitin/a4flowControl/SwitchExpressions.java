package nitin.a4flowControl;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Nitin Chaurasia on Friday, June/05/2020 at 2:52 AM
 */

public class SwitchExpressions {
    final static List<String> ANEMIA_LABS = Arrays.asList(
            "HEMOGLOBIN",//Sort Order based on Array Index. 0 = lowest, array.size()-1 = biggest
            "IRON SATURATION",
            "FERRITIN",
            "IRON",
            "MCV",
            "RETIC COUNT",
            "ABSOLUTE RETIC COUNT",
            "WBC");

    public static void main(String[] args) {
        String day = "sun";

        //System.out.println(getString(day));

        for(String lab : ANEMIA_LABS){
            System.out.println(getString2(lab));
        }
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

    private static String getString2(String str) {

        String result = switch (str) {
            case "IRON" -> "Iron Lab";
            case "FERRITIN" -> "FERRITIN Lab";
            default -> {
                if (ANEMIA_LABS.isEmpty())
                    yield "Please insert a valid day";
                else
                    yield "Invalid Labs";
            }
        };
        return result;
    }
}

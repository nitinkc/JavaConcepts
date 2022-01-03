package nitin.Optionals;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public class NullabilityTest {
    public static void main(String[] args) {

        String getOrderStopDate = null;//"Nitin";

        String result = Optional.ofNullable(getOrderStopDate)
                .map(StringUtils::upperCase)
                .orElse("Or-Else Block");
        System.out.println(result);
    }
}

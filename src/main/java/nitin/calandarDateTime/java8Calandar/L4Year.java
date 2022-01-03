package nitin.calandarDateTime.java8Calandar;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nitin on Saturday, April/25/2020 at 11:51 PM
 */
public class L4Year {
    public static void main(String[] args) {

        Year y = null;
        List<Integer> leapYear = new ArrayList<>();

        for (int i = 1300; i <= 2020; i++) {
            y = Year.of(i);
            if(y.isLeap()){
                leapYear.add(i);
            }
        }

        leapYear.stream().forEach( l -> System.out.println(l) );
    }
}

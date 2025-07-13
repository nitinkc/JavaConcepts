package nitin.calandarDateTime.old;

import com.utilities.OldDateUtilities;
import com.utilities.TimeStampUtilities;
import java.sql.Date;

/** Created by nichaurasia on Saturday, April/25/2020 at 4:15 AM */
public class GetAge {
    public static void main(String[] args) {
        int age = TimeStampUtilities.getAgeFromBrithDate("1985-06-11");
        System.out.println(age);
        Date d1 = new Date(2020, 04, 25);
        Date d2 = new Date(1985, 06, 11);

        // Timestamp d1 = DateUtilities.getDate("04252020");
        // Timestamp d2 = DateUtilities.getDate("06111985");\
        long days = OldDateUtilities.daysBetween(d2, d1);
        System.out.println(days);
    }
}

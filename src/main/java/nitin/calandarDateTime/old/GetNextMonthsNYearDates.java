package nitin.calandarDateTime.old;

import com.utilities.OldDateUtilities;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/** Created by nichaurasia on Thursday, April/23/2020 at 10:57 AM */
public class GetNextMonthsNYearDates {
    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        currentDate = OldDateUtilities.nullifyTime(currentDate);
        Timestamp authTimestamp = new Timestamp(currentDate.getTime());

        System.out.println(authTimestamp);

        /*
        If Current Date Dt: 04/17/2020
        POI -> 05/17/2020 to 05/16/2021.
        */
        // Add one month to the current Date
        calendar.add(Calendar.MONTH, 1);
        Date poiBeginDate = calendar.getTime();
        poiBeginDate = OldDateUtilities.nullifyTime(poiBeginDate);
        // Add 12 months from one month of the current Date
        calendar.add(Calendar.MONTH, 12);
        calendar.add(Calendar.DATE, -1);
        Date poiEndDate = calendar.getTime();
        poiEndDate = OldDateUtilities.nullifyTime(poiEndDate);

        Timestamp start = new Timestamp(poiBeginDate.getTime());
        Timestamp end = new Timestamp(poiEndDate.getTime());

        System.out.println();
        System.out.println(start);
        System.out.println(end);
    }
}

package nitin.calandarDateTime.old;

import com.utilities.OldDateUtilities;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/** Created by nitin on Wednesday, May/06/2020 at 5:33 PM */
public class GetFutureDates {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        currentDate = OldDateUtilities.nullifyTime(currentDate);
        Timestamp authTimestamp = new Timestamp(currentDate.getTime());

        String datePattern = "EEE, MMM, dd yyyy HH:mm:ss z Z";
        SimpleDateFormat sdf = new SimpleDateFormat(datePattern);

        System.out.println("Current Time : ");
        System.out.println(sdf.format(authTimestamp));

        // Find a date 30 days from Now and then 365 days from that day
        calendar.add(Calendar.DATE, 30);
        Date poiBeginDate = calendar.getTime();
        poiBeginDate = OldDateUtilities.nullifyTime(poiBeginDate);
        // Add 12 months from one month of the current Date
        calendar.add(Calendar.DATE, 365);
        Date poiEndDate = calendar.getTime();
        poiEndDate = OldDateUtilities.nullifyTime(poiEndDate);

        Timestamp start = new Timestamp(poiBeginDate.getTime());
        Timestamp end = new Timestamp(poiEndDate.getTime());

        System.out.println("####################################");
        System.out.println(sdf.format(start));
        System.out.println(sdf.format(end));
    }
}

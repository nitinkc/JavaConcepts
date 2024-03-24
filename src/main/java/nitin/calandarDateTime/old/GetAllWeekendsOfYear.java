package nitin.calandarDateTime.old;

import com.utilities.OldDateUtilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by nichaurasia on Saturday, April/25/2020 at 2:48 AM
 */

public class GetAllWeekendsOfYear {
    public static void main(String[] args) throws ParseException {
        List<Date> list = OldDateUtilities.getWeekendsInAYear(2008);
        String datePattern = "EEE, MMM, dd yyyy HH:mm:ss z Z";
        SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
        Date tempDate = null;
        for (Date date : list) {
            //tempDate = sdf.format(date);
            System.out.println(sdf.format(date));
        }
    }
}



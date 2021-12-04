package java8.a19CalandarNCurrency.calandarDateTime;

import com.utilities.DateUtilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by nitin on Monday, April/27/2020 at 2:45 PM
 */
public class GetPreviousNFridays {
    public static void main(String[] args) throws ParseException {
        List<Date> list = DateUtilities.getLastNFridays(15);
        String datePattern = "EEE, MMM, dd yyyy HH:mm:ss z Z";
        SimpleDateFormat sdf=new SimpleDateFormat(datePattern);
        Date tempDate = null;
        for (Date date : list) {
            //tempDate = sdf.format(date);
            System.out.println(sdf.format(date));
        }
    }
}

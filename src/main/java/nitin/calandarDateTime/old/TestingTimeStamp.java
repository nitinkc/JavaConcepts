package nitin.calandarDateTime.old;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestingTimeStamp {
    public static void main(String[] args) {
        String pattern = "E MMM dd hh:mm:ss Z yyyy";
        Timestamp asOfDate = new Timestamp(System.currentTimeMillis());
        DateFormat df = new SimpleDateFormat(pattern);

        try {
            Date date = df.parse("Tue Jun 11 12:53:10 IST 1985");
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

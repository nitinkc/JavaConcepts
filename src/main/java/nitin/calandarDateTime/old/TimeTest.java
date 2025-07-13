package nitin.calandarDateTime.old;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TimeTest {
    public static void main(String[] args) throws ParseException {
        Map<String, Object> map = new HashMap<>();
        map.put("END_DATE", "2019-11-21");
        Timestamp endDate;

        //        Optional.ofNullable((String) map.get(("END_DATE")))
        //                .map(obj -> String.valueOf(obj))
        //                .ifPresent(obj -> System.out.println(Timestamp.valueOf(obj)));

        DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        // you can change format of date
        Date date = formatter.parse((String) map.get(("END_DATE")));
        Timestamp timeStampDate = new Timestamp(date.getTime());

        System.out.println(timeStampDate);
    }
}

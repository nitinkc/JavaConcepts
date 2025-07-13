package nitin.calandarDateTime.java8Calandar;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;

public class StringToTimeStamp {
    public static void main(String[] args) {
        System.out.println(extractDate("01-01-2007"));
        System.out.println(extractDateOld("01-01-2007").toString());
    }

    private static Timestamp extractDate(String date) {
        final String dateFormat = "dd-MM-yyyy";
        if (StringUtils.isBlank(date)) {
            return null;
        }
        Date parseDate = null;
        try {
            parseDate = new SimpleDateFormat(dateFormat).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ZonedDateTime zonedDateTime = parseDate.toInstant().atZone(ZoneOffset.UTC);

        return Optional.of(Timestamp.valueOf(zonedDateTime.toLocalDateTime())).orElse(null);
    }

    private static Timestamp extractDateOld(String date) {
        final String dateFormat = "dd-MM-yyyy";
        if (StringUtils.isBlank(date)) return null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date parseDate = simpleDateFormat.parse(date);
            Timestamp tp = new Timestamp(parseDate.getTime());
            return tp;

        } catch (ParseException e) {
            System.out.println("Exception parsing date : " + date);
        }
        return null;
    }
}

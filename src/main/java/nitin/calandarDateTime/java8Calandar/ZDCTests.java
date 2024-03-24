package nitin.calandarDateTime.java8Calandar;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ZDCTests {
    public static void main(String[] args) {

        //TimeZone
        ZoneId zone    = ZoneId.systemDefault();//Uses Z for UTC
        ZoneId india   = ZoneId.of("Asia/Kolkata");//UTC+05:30
        ZoneId chicago = ZoneId.of("US/Central");
        ZoneId ny      = ZoneId.of("UTC-05:00");

        System.out.println(ZoneOffset.SHORT_IDS.get("IST"));//ZoneOffset doesn't count Daylight savings
        //ZoneId.getAvailableZoneIds().stream().forEach(x -> System.out.println(x));

        ZonedDateTime timeChicago = ZonedDateTime.now(chicago);
        System.out.println("Time in Chicago : " + timeChicago);

        ZonedDateTime timeUTC = ZonedDateTime.now(ZoneOffset.UTC);
        System.out.println("UTC Time : " + timeUTC);

        ZonedDateTime timeIndia = ZonedDateTime.now(india);
        System.out.println("Time in India : " + timeIndia);

        //ZoneOffset.SHORT_IDS.forEach((key, value) -> System.out.println(key + " : "+ value));
        System.out.println("============================================");
        System.out.println(formatZonedDateTime(timeUTC));
        System.out.println(formatZonedDateTime(null));

    }

    public static ZonedDateTime getFacilityTime(String pdInactiveDate, String facilityZone) {
        ZonedDateTime inactiveDateutc = ZonedDateTime.parse(pdInactiveDate);
        ZonedDateTime facilityTime = inactiveDateutc.withZoneSameInstant(ZoneId.of(facilityZone));
        return facilityTime
                .with(LocalTime.MAX)
                .withZoneSameInstant(ZoneId.of(ZoneOffset.UTC.getId()))
                .truncatedTo(ChronoUnit.MILLIS);
    }

    public static String formatZonedDateTime(ZonedDateTime zonedDateTime) {
        String dateTimePattern = "yyyy-MM-dd'T'HH:mm:ssz";
        String timestamp = null;
        if (null != zonedDateTime){
            timestamp = zonedDateTime.format(DateTimeFormatter.ofPattern(dateTimePattern));
        }
        return timestamp;
    }
}

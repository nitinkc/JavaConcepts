package nitin.calandarDateTime.java8Calandar;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TestingProcessors {
    public static void main(String[] args) {
        System.out.println("Processors : " + Runtime.getRuntime().availableProcessors());

        ZonedDateTime time = ZonedDateTime.now();
        System.out.println(getTimesBasedOnCity(time, time.getOffset().getId()));

        String standardTimeFormat = "2024-03-10T04:00:00+00";
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(standardTimeFormat);
        System.out.println(getTimesBasedOnCity(zonedDateTime, zonedDateTime.getOffset().getId()));

        // If time is in any other format
        String inputDateTimePattern = "yyyy-MM-dd HH:mm:ssZ";
        String timeInUserDefinedFormat = "2024-03-10 04:00:00+0530";
        ZonedDateTime zonedDateTimeUserFormatted =
                ZonedDateTime.parse(
                        timeInUserDefinedFormat, DateTimeFormatter.ofPattern(inputDateTimePattern));

        System.out.println(
                getTimesBasedOnCity(
                        zonedDateTimeUserFormatted,
                        zonedDateTimeUserFormatted.getOffset().getId()));
    }

    public static ZonedDateTime getTimesBasedOnCity(ZonedDateTime dateTime, String cityTimeZone) {

        return dateTime.with(LocalTime.MAX)
                .withZoneSameInstant(ZoneId.of(cityTimeZone))
                .truncatedTo(ChronoUnit.MILLIS);
    }
}

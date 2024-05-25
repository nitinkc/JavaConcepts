package nitin.calandarDateTime.java8Calandar;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.zone.ZoneRulesException;

public class GmtToEstFormattedConversion {
    static String outputSameDateFormat = "HH:mm zzz";
    static String outputDiffDateFormat = "MM/dd/yyyy HH:mm zzz";
    static String inputDateTimePattern = "yyyy-MM-dd HH:mm:ssX";


    //CHECK THE TEST CASES
    public static void main(String[] args) {
        String startDateTime = "2024-03-22 03:04:44.512320+00";
        String endDateTime = "2024-03-22 04:44:44.512320+00";
        String timeZoneIso = "America/New_York";

        run(startDateTime, endDateTime, timeZoneIso);
    }

    public static Result run(String startDateTime, String endDateTime, String timeZoneIso) {
        if (null == startDateTime) {
            startDateTime = "";
        }

        if (null == endDateTime) {
            endDateTime = "";
        }

        Result result = null;
        if (startDateTime.isEmpty() && endDateTime.isEmpty()) {
            result = new Result(startDateTime, endDateTime);
        }

        if (!startDateTime.isEmpty() && endDateTime.isEmpty()) {
            result = new Result(getReturnDateTimeFormat(startDateTime, timeZoneIso, outputDiffDateFormat)
                    , endDateTime);
        }

        if (startDateTime.isEmpty() && !endDateTime.isEmpty()) {
            result = new Result(startDateTime, getReturnDateTimeFormat(endDateTime, timeZoneIso, outputDiffDateFormat));
        }

        if (!startDateTime.isEmpty() && !endDateTime.isEmpty()) {
            result = getFormattedTimezoneString(startDateTime, endDateTime, timeZoneIso);
        }

        return result;
    }

    private static String getReturnDateTimeFormat(String dateTime, String timeZoneIso, String dateformat) {
        //Outgoing DateTime format
        return getZonedDateTime(dateTime, timeZoneIso).format(DateTimeFormatter.ofPattern(dateformat));
    }

    private static ZonedDateTime getZonedDateTime(String startDateTime, String timeZoneIso) {
        ZonedDateTime zonedDateTime = null;
        try {
            zonedDateTime = ZonedDateTime
                    .parse(startDateTime,
                            DateTimeFormatter.ofPattern(inputDateTimePattern)//Date Time format of incomming String
                                    .withZone(ZoneOffset.UTC))
                    .withZoneSameInstant(ZoneId.of(timeZoneIso));

        } catch (ZoneRulesException e) {
            System.out.println(e.getMessage());
            throw new ZoneRulesException("Invalid Timezone :: " + timeZoneIso);
        }
        return zonedDateTime;
    }

    public static Result getFormattedTimezoneString(String startDateTime, String endDateTime, String timeZoneIso) {
        ZonedDateTime zonedStartDateTime = getZonedDateTime(startDateTime, timeZoneIso);
        ZonedDateTime zonedEndDateTime = getZonedDateTime(endDateTime, timeZoneIso);

        String startDate;
        String endDate;
        //If there is a Difference is of One day, Show both date and Time
        if (zonedEndDateTime.toLocalDate().minusDays(1L).isEqual(zonedStartDateTime.toLocalDate())) {
            startDate = zonedStartDateTime.format(DateTimeFormatter.ofPattern(outputDiffDateFormat));
            endDate = zonedEndDateTime.format(DateTimeFormatter.ofPattern(outputDiffDateFormat));
        } else {//Else show just the time for the same dat scenario
            startDate = zonedStartDateTime.format(DateTimeFormatter.ofPattern(outputSameDateFormat));
            endDate = zonedEndDateTime.format(DateTimeFormatter.ofPattern(outputSameDateFormat));
        }

        Result result = new Result(startDate, endDate);
        return result;
    }

    public record Result(String startDate, String endDate) {
    }
}
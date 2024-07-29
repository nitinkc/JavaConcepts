package com.utilities;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.zone.ZoneRulesException;

public class ZonedDateTimeUtility {

    public static String zonedDateTimeStr(ZonedDateTime zonedDateTime) {
        String dateTimePattern = "yyyy-MM-dd'T'HH:mm:ssz";
        String timestamp = null;
        if (null != zonedDateTime) {
            timestamp = zonedDateTime.format(DateTimeFormatter.ofPattern(dateTimePattern));
        }
        return timestamp;
    }

    public static ZonedDateTime getZonedDateTime(String startDateTime, String timeZoneIso) {
        String inputDateTimePattern = "yyyy-MM-dd HH:mm:ssX";
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
         String outputDiffDateFormat = "MM/dd/yyyy HH:mm zzz";
         String outputSameDateFormat = "HH:mm zzz";

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

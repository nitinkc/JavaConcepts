package nitin.calandarDateTime.java8Calandar;

import java.text.ParseException;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ConvertGSTtoEST {
    public static void main(String[] args) throws ParseException {
        String inputDateTimePattern = "yyyy-MM-dd HH:mm:ssX"; //"yyyy-MM-dd HH:mm:ss.SSSSSSX";
        String outputDateTimeFormat = "MM/dd/yyyy HH:mm z";
        String toTimeZone = "America/New_York";

        String startTime = "2024-03-10 04:00:00+00"; // Start time in GMT
        String endTime = "2024-03-10 07:00:00+00";   // End time in GMT

        //03/09/2024 23:00 EST
        System.out.println(getFormattedOutputDateTimeString
                (startTime, inputDateTimePattern, outputDateTimeFormat, toTimeZone));
        //03/10/2024 03:00 EDT
        System.out.println(getFormattedOutputDateTimeString
                (endTime, inputDateTimePattern, outputDateTimeFormat, toTimeZone));
    }

    private static String getFormattedOutputDateTimeString(String dateTime, String inputDateTimePattern, String outputDateTimeFormat, String toTimeZone) {
        //For the INPUT STRING (from DB or other service)
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(inputDateTimePattern)
                .withZone(ZoneOffset.UTC);//redundant if the input date-time string already contains the offset information (+00)
        // useful when the String doesn't have Zone Id like mentioned "2024-03-10 07:00:00"  and is assumed to be from UTC

        //Output Formatter
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(outputDateTimeFormat);

        return ZonedDateTime
                .parse(dateTime, inputFormatter)//Returns ZonedDateTime
                .withZoneSameInstant(ZoneId.of(toTimeZone))//return converted ZonedDateTime
                .format(outputFormatter);// returns formatted String
    }
}

package nitin.calandarDateTime.java8Calandar;

import static com.utilities.ZonedDateTimeUtility.getFormattedTimezoneString;
import static com.utilities.ZonedDateTimeUtility.getZonedDateTime;

import com.utilities.ZonedDateTimeUtility;
import com.utilities.ZonedDateTimeUtility.Result;
import java.time.format.DateTimeFormatter;

public class GmtToEstFormattedConversion {
    static String outputSameDateFormat = "HH:mm zzz";
    static String outputDiffDateFormat = "MM/dd/yyyy HH:mm zzz";
    static String inputDateTimePattern = "yyyy-MM-dd HH:mm:ssX";

    // CHECK THE TEST CASES
    public static void main(String[] args) {
        String startDateTime = "2024-03-22 03:04:44.512320+00";
        String endDateTime = "2024-03-22 04:44:44.512320+00";
        String timeZoneIso = "America/New_York";

        run(startDateTime, endDateTime, timeZoneIso);
    }

    public static ZonedDateTimeUtility.Result run(
            String startDateTime, String endDateTime, String timeZoneIso) {
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
            result =
                    new ZonedDateTimeUtility.Result(
                            getReturnDateTimeFormat(
                                    startDateTime, timeZoneIso, outputDiffDateFormat),
                            endDateTime);
        }

        if (startDateTime.isEmpty() && !endDateTime.isEmpty()) {
            result =
                    new Result(
                            startDateTime,
                            getReturnDateTimeFormat(
                                    endDateTime, timeZoneIso, outputDiffDateFormat));
        }

        if (!startDateTime.isEmpty() && !endDateTime.isEmpty()) {
            result = getFormattedTimezoneString(startDateTime, endDateTime, timeZoneIso);
        }

        return result;
    }

    private static String getReturnDateTimeFormat(
            String dateTime, String timeZoneIso, String dateformat) {
        // Outgoing DateTime format
        return getZonedDateTime(dateTime, timeZoneIso)
                .format(DateTimeFormatter.ofPattern(dateformat));
    }
}

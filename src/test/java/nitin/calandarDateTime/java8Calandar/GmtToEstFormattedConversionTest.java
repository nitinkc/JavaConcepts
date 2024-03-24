package nitin.calandarDateTime.java8Calandar;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.zone.ZoneRulesException;

public class GmtToEstFormattedConversionTest {

    @Test
    public void testBothStartAndEndDateTimeProvided() {
        String startDateTime = "2024-03-22 03:04:44+00";
        String endDateTime = "2024-03-22 04:44:44+00";
        String timeZoneIso = "America/New_York";

        GmtToEstFormattedConversion.Result result = GmtToEstFormattedConversion.run(startDateTime, endDateTime,timeZoneIso);

        assertEquals("03/21/2024 23:04 EDT", result.startDate());
        assertEquals("03/22/2024 00:44 EDT", result.endDate());
    }

    @Test
    public void testOnlyStartDateTimeProvided() {
        String startDateTime = "2024-03-22 03:04:44+00";
        String endDateTime = null;
        String timeZoneIso = "America/New_York";

        GmtToEstFormattedConversion.Result result = GmtToEstFormattedConversion.run(startDateTime, endDateTime, timeZoneIso);

        assertEquals("03/21/2024 23:04 EDT", result.startDate());
        assertEquals("", result.endDate());
    }

    @Test
    public void testOnlyEndDateTimeProvided() {
        String startDateTime = null;
        String endDateTime = "2024-03-22 04:44:44+00";
        String timeZoneIso = "America/New_York";

        GmtToEstFormattedConversion.Result result = GmtToEstFormattedConversion.run(startDateTime, endDateTime,timeZoneIso);

        assertEquals("", result.startDate());
        assertEquals("03/22/2024 00:44 EDT", result.endDate());
    }

    @Test
    public void testNoDateTimesProvided() {
        String startDateTime = null;
        String endDateTime = null;
        String timeZoneIso = "America/New_York";

        GmtToEstFormattedConversion.Result result = GmtToEstFormattedConversion.run(startDateTime, endDateTime,timeZoneIso);

        assertEquals("", result.startDate());
        assertEquals("", result.endDate());
    }

    @Test
    public void testTimeZoneWithDaylightSavingTimeTransition() {
        String startDateTime = "2024-03-12 01:30:00+00";
        String endDateTime = "2024-03-12 03:30:00+00";
        String timeZoneIso = "America/New_York";

        GmtToEstFormattedConversion.Result result = GmtToEstFormattedConversion.run(startDateTime, endDateTime,timeZoneIso);

        //Same Date
        //In the Eastern Time Zone (America/New_York), the daylight saving time (DST) transition happens on March 11, 2024.
        // Therefore, the local time will transition from Eastern Standard Time (EST) to Eastern Daylight Time (EDT).
        assertEquals("21:30 EDT", result.startDate());
        assertEquals("23:30 EDT", result.endDate());
    }


    @Test
    public void testInvalidTimeZone() {
        String startDateTime = "2024-03-22 03:04:44+00";
        String endDateTime = "2024-03-22 04:44:44+00";
        String timeZoneIso = "Invalid/Timezone";

        //GmtToEstFormattedConversion.Result result = GmtToEstFormattedConversion.run(startDateTime, endDateTime,timeZoneIso);

        // Use assertThrows with the expected exception type and a lambda expression
        ZoneRulesException exception = assertThrows(ZoneRulesException.class, () -> {
            GmtToEstFormattedConversion.run(startDateTime, endDateTime, timeZoneIso);
        });

        // Verify the exception message
        assertEquals("Invalid Timezone :: Invalid/Timezone", exception.getMessage());
    }

    @Test
    public void testTimeZoneWithDaylightSavingTimeTransitionMultiDay() {
        // Scenario 1: Start in EST, End in EDT
        String startDateTime1 = "2024-03-10 04:00:00+00"; // Start time in GMT
        String endDateTime1 = "2024-03-10 07:00:00+00";   // End time in GMT
        String timeZoneIso1 = "America/New_York";
        GmtToEstFormattedConversion.Result result1 = GmtToEstFormattedConversion.run(startDateTime1, endDateTime1, timeZoneIso1);
        assertEquals("03/09/2024 23:00 EST", result1.startDate());
        assertEquals("03/10/2024 03:00 EDT", result1.endDate());

        // Scenario 2: Start in EST, End in EDT
        String startDateTime2 = "2024-03-10 06:59:00+00"; // Start time in GMT
        String endDateTime2 = "2024-03-10 07:00:00+00";   // End time in GMT
        String timeZoneIso2 = "America/New_York";
        GmtToEstFormattedConversion.Result result2 = GmtToEstFormattedConversion.run(startDateTime2, endDateTime2, timeZoneIso2);
        assertEquals("01:59 EST", result2.startDate());
        assertEquals("03:00 EDT", result2.endDate());
    }
}
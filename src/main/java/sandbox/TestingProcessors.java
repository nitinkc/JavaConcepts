package sandbox;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class TestingProcessors {
    public static void main(String[] args) {
        System.out.println("Processors : " + Runtime.getRuntime().availableProcessors());

        ZoneOffset timeZone = ZoneOffset.UTC;
        ZonedDateTime time = ZonedDateTime.now();
        System.out.println(getFacilityTime(time.toString(),time.getOffset().getId()));
    }

    public static ZonedDateTime getFacilityTime(String pdInactiveDate, String facilityZone) {
        ZonedDateTime inactiveDateutc = ZonedDateTime.parse(pdInactiveDate);
        ZonedDateTime facilityTime = inactiveDateutc.withZoneSameInstant(ZoneId.of(facilityZone));
        return facilityTime
                .with(LocalTime.MAX)
                .withZoneSameInstant(ZoneId.of(ZoneOffset.UTC.getId()))
                .truncatedTo(ChronoUnit.MILLIS);
    }
}

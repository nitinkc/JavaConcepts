package nitin.calandarDateTime.java8Calandar;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by nitin on Sunday, April/26/2020 at 12:04 AM
 */
public class L5Zone {
    public static void main(String[] args) {
        String myDateTimePattern = "E dd.MM.yyyy HH:mm z v";

        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone);

        System.out.println("Current Time here is : \n" +
                ZonedDateTime
                        .now()
                        .format(DateTimeFormatter.ofPattern(myDateTimePattern)));

        ZoneId india = ZoneId.of("Asia/Kolkata");
        ZonedDateTime timeInIndia = ZonedDateTime.now(india);

        System.out.println("Time in India");


        System.out.println(timeInIndia.format(DateTimeFormatter.ofPattern(myDateTimePattern)));

    }
}

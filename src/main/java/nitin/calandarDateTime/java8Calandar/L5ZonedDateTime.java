package nitin.calandarDateTime.java8Calandar;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/** Created by nitin on Sunday, April/26/2020 at 12:04 AM */
public class L5ZonedDateTime {
    public static void main(String[] args) {
        String myDateTimePattern = "E dd.MM.yyyy HH:MM:SSS a z v";
        // myDateTimePattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

        ZoneId zone = ZoneId.systemDefault();
        ZoneId india = ZoneId.of("Asia/Kolkata");

        ZonedDateTime timeInTheCityWhereCodeIsExecuted = ZonedDateTime.now(zone);
        ZonedDateTime timeInIndia = ZonedDateTime.now(india);

        System.out.print("Time in " + zone + " : ");
        System.out.println(
                timeInTheCityWhereCodeIsExecuted.format(
                        DateTimeFormatter.ofPattern(myDateTimePattern)));

        System.out.print("Time in India : ");
        System.out.println(timeInIndia.format(DateTimeFormatter.ofPattern(myDateTimePattern)));

        if (null != timeInTheCityWhereCodeIsExecuted
                && timeInTheCityWhereCodeIsExecuted.isAfter(timeInIndia)) {
            System.out.println("...1...EXCEPTION Start date should not less than Stop date");
        }
        if (timeInTheCityWhereCodeIsExecuted
                .toLocalDate()
                .isBefore(timeInIndia.toLocalDate())) { // Considering the Date part only
            System.out.println("...2...Start date IS BEFORE Stop date");
        }
        if (timeInTheCityWhereCodeIsExecuted
                .toLocalDate()
                .isEqual(timeInIndia.toLocalDate())) { // Considering the Date part only
            System.out.println("...3...Start date IS EQUAL Stop date");
        }
    }
}

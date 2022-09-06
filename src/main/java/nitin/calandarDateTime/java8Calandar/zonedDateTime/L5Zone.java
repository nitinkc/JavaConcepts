package nitin.calandarDateTime.java8Calandar.zonedDateTime;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by nitin on Sunday, April/26/2020 at 12:04 AM
 */
public class L5Zone {
    public static void main(String[] args) {
        String myDateTimePattern = "E dd.MM.yyyy HH:MM:SSS a z v";
        //myDateTimePattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

        ZoneId zone = ZoneId.systemDefault();
        ZoneId india = ZoneId.of("Asia/Kolkata");

        ZonedDateTime timeInNashville = ZonedDateTime.now(zone);
        ZonedDateTime timeInIndia = ZonedDateTime.now(india);

        System.out.print("Time in "+ zone+ " : ");
        System.out.println(timeInNashville.format(DateTimeFormatter.ofPattern(myDateTimePattern)));

        System.out.print("Time in India : ");
        System.out.println(timeInIndia.format(DateTimeFormatter.ofPattern(myDateTimePattern)));

        if (null != timeInNashville && timeInNashville.isAfter(timeInIndia)) {
            System.out.println("...1...EXCEPTION Start date should not less than Stop date");
        }
        if (timeInNashville.toLocalDate().isBefore(timeInIndia.toLocalDate())) {//Considering the Date part only
            System.out.println("...2...Start date IS BEFORE Stop date");
        }
        if (timeInNashville.toLocalDate().isEqual(timeInIndia.toLocalDate())) {//Considering the Date part only
            System.out.println("...3...Start date IS EQUAL Stop date");
        }

    }
}

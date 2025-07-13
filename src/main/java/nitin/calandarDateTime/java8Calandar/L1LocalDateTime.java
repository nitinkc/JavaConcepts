package nitin.calandarDateTime.java8Calandar;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/** Created by nichaurasia on Saturday, April/25/2020 at 9:57 PM */
public class L1LocalDateTime {
    public static void main(String[] args) {
        LocalDateTime d = LocalDateTime.now();

        int date = d.getDayOfMonth();
        Month mon = d.getMonth();
        int mm = d.getMonthValue();
        int year = d.getYear();
        DayOfWeek dayOfWeek = d.getDayOfWeek();
        int hour = d.getHour();
        int min = d.getMinute();
        int sec = d.getSecond();
        int nanoSec = d.getNano();
        System.out.println(
                dayOfWeek + ", " + date + "/" + mon + "(" + mm + ")/" + year + " T " + hour + ":"
                        + min + ":" + sec + "." + nanoSec);

        LocalDateTime now = LocalDateTime.now();
        String formattedDateTime =
                now.format(DateTimeFormatter.ofPattern("EEEE, dd/MMM(yyyy) HH:mm:ss.n"));
        System.out.println(formattedDateTime);
    }
}

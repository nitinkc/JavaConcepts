package java.calandarDateTime.java8Calandar;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/**
 * Created by nichaurasia on Saturday, April/25/2020 at 10:37 PM
 */

public class L3Period {
    public static void main(String[] args) {
        LocalDate birthday = LocalDate.of(1985, Month.JUNE,11);
        LocalDate now = LocalDate.now();
        Period p = Period.between(birthday,now);

        System.out.println("Number of days");
        System.out.println(p.getYears() + " Years "+ p.getMonths() + " Months "+ p.getDays() + " Days");
        System.out.println(p.toString());
    }
}

package com.nitin.a19CalandarNCurrency.java8Calandar;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;

/**
 * Created by nichaurasia on Saturday, April/25/2020 at 10:37 PM
 */

public class L3Period {
    public static void main(String[] args) {
        LocalDate bithday = LocalDate.of(1985, Month.JUNE,11);
        LocalDate now = LocalDate.now();

        Period p = Period.between(bithday,now);

        System.out.println(p.getYears() + " Years "+ p.getMonths() + " Months "+ p.getDays() + " Days");
    }
}

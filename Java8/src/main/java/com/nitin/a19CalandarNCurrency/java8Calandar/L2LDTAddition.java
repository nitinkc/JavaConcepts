package com.nitin.a19CalandarNCurrency.java8Calandar;

import java.time.LocalDateTime;
import java.time.Month;

/**
 * Created by nichaurasia on Saturday, April/25/2020 at 10:29 PM
 */

public class L2LDTAddition {
    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.of(1985, Month.JUNE,11,0,0,0);
        dt = dt.plusMonths(6);
        dt = dt.minusMinutes(6);
        System.out.println(dt);
    }
}

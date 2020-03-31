package com.nitin.a19CalanderNCurrency.calanderDateTime;

import java.util.Calendar;
import java.util.Date;

public class GetFirstNLastDayOfMonth {

    public static void main(String... args) {

        for (int i = 1; i < 13 ; i++) {
            System.out.println("First day of the month: " + getFirstDateOfMonth(i));
            System.out.println("Last day of the month: " + getLastDateOfMonth(i));
            System.out.println("**************************************************");
        }
    }

    public static Date getFirstDateOfMonth(int beginMonth) {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();

        //Find out the First day of the begin month
        calendar.set(calendar.YEAR, beginMonth-1, 1);

        //calendar.setTime(date);
        int day = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

//    private static Date getLastDateOfMonth(int endMonth) {
private static Date getLastDateOfMonth(int endMonth) {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();

        calendar.set(calendar.YEAR, endMonth-1, 1);

        //calendar.setTime(date);
        int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        //calendar.set(Calendar.YEAR, year);

        //return SimpleDateFormat("MM/dd/yyyy").format(calendar.getTime());
        return calendar.getTime();
    }
}
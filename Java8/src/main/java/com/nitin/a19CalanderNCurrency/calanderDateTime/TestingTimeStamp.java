package com.nitin.a19CalanderNCurrency.calanderDateTime;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestingTimeStamp {
    public static void main(String[] args) {
        Timestamp asOfDate = new Timestamp(System.currentTimeMillis());
        DateFormat df = new SimpleDateFormat("E MMM dd hh:mm:ss Z yyyy");

        try {
            System.out.println(df.parse("11-jun-1985"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

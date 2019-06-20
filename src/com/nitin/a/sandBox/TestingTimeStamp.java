package com.nitin.a.sandBox;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestingTimeStamp {
    public static void main(String[] args) {
        Timestamp asOfDate = new Timestamp(System.currentTimeMillis());

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        try {
            System.out.println(df.parse("11-jun-85"));
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}

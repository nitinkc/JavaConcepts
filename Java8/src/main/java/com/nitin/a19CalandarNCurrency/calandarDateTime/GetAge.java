package com.nitin.a19CalandarNCurrency.calandarDateTime;

import com.utilities.DateUtilities;
import com.utilities.StringUtils;

import java.sql.Date;

/**
 * Created by nichaurasia on Saturday, April/25/2020 at 4:15 AM
 */

public class GetAge {
    public static void main(String[] args) {
       int age =  StringUtils.getAgeFromBrithDate("1985-06-11");
        System.out.println(age);
        Date d1 = new Date(2020,04,25);
        Date d2 = new Date(1985,06,11);

        //Timestamp d1 = DateUtilities.getDate("04252020");
        //Timestamp d2 = DateUtilities.getDate("06111985");\
        long days = DateUtilities.daysBetween(d2,d1);
        System.out.println(days);
    }
}

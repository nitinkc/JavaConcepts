package com.utilities;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by nichaurasia on Saturday, April/25/2020 at 3:46 AM
 */

public class StringUtils {
    public static boolean isEmpty(String obj) {
        if (obj != null && !"".equals(obj.trim())) return false;
        return true;
    }

    public static boolean isNotEmpty(String obj) {
        if (obj != null && !"".equals(obj.trim())) return true;
        return false;
    }

    public String convertDateToString(Date aDate, String pattern) {

        String aDateStr = null;

        if ((aDate != null)) {
            Format formatter = new SimpleDateFormat(pattern);
            aDateStr = formatter.format(aDate);
        }
        return aDateStr;
    }


    public String convertTimestampToString(Timestamp aTimestamp, String pattern) {

        String aDateStr = null;

        if ((aTimestamp != null)) {
            Format formatter = new SimpleDateFormat(pattern);
            aDateStr = formatter.format(aTimestamp);
        }
        return aDateStr;
    }

    public static Timestamp convertStringToTimeStampWithFormat(String time, String format) {

        Timestamp aTimestamp = null;

        if ((time != null) && (format != null)) {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            try {
                Date aDate = (Date) formatter.parse(time);

                aTimestamp = new Timestamp(aDate.getTime());
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return aTimestamp;
    }


    public static int getAgeFromBrithDate(String aBirthDate) {
        int age = 0;
        try {

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            java.util.Date date = calendar.getTime();

            String currentDate = dateFormat.format(date);

            Calendar cal1 = new GregorianCalendar();
            Calendar cal2 = new GregorianCalendar();

            int factor = 0;
            java.util.Date date1 =  new SimpleDateFormat("yyyy-MM-dd").parse(aBirthDate);
            java.util.Date date2 =  new SimpleDateFormat("yyyy-MM-dd").parse(currentDate);
            cal1.setTime(date1);
            cal2.setTime(date2);
            if (cal2.get(Calendar.DAY_OF_YEAR) < cal1.get(Calendar.DAY_OF_YEAR)) {
                factor = -1;
            }
            age = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR) + factor;

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return age;
    }

    public static Timestamp convertDateToTimestamp(Date aDate) {


        Timestamp timestamp = new Timestamp(aDate.getTime());

        return timestamp;
    }


    public static Timestamp addingMonthToTimestamp(Timestamp aDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(aDate.getTime());
        calendar.add(Calendar.MONTH, 11);
        return new Timestamp(calendar.getTimeInMillis());
    }

    public static String trimToLength(String input, int length) {
        if (!isEmpty(input)) {
            input = input.trim();
            if (input.length() > length) {
                return input.substring(0, length);
            }
        }
        return input;
    }
}
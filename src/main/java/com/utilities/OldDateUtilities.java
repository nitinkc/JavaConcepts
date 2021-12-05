package com.utilities;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class OldDateUtilities implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final int NULL = -111;

    public static long numberOfMonthsBetween(Date d1, Date d2) {
        int diffrence = 0;
        if (d1 != null && d2 != null) {
            Calendar earlier = Calendar.getInstance();
            Calendar later = Calendar.getInstance();
            if (d1.compareTo(d2) < 0) {
                earlier.setTime(nullifyTime(d1));
                later.setTime(nullifyTime(d2));
            } else {
                earlier.setTime(nullifyTime(d2));
                later.setTime(nullifyTime(d1));
            }
            diffrence = (later.get(Calendar.YEAR) - earlier.get(Calendar.YEAR))
                    * 12
                    + (later.get(Calendar.MONTH) - earlier.get(Calendar.MONTH))
                    + (later.get(Calendar.DAY_OF_MONTH) >= earlier
                    .get(Calendar.DAY_OF_MONTH) ? 0 : -1);
        }
        return diffrence;
    }

    public static long daysBetween(Date d1, Date d2) {
        int difference = 0;
        if (d1 != null && d2 != null) {
            Calendar earlier = Calendar.getInstance();
            Calendar later = Calendar.getInstance();
            if (d1.compareTo(d2) < 0) {
                earlier.setTime(nullifyTime(d1));
                later.setTime(nullifyTime(d2));
            } else {
                earlier.setTime(nullifyTime(d2));
                later.setTime(nullifyTime(d1));
            }
            while (earlier.before(later)) {
                earlier.add(Calendar.DAY_OF_MONTH, 1);
                difference++;
            }
        }
        return difference;
    }

    public static int inMonths(Date inDate) {
        if (inDate != null) {
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(inDate);
            return cal.get(GregorianCalendar.MONTH);
        }
        return NULL;
    }

    public static int inYear(Date inDate) {
        if (inDate != null) {
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(inDate);
            return cal.get(GregorianCalendar.YEAR);
        }
        return NULL;
    }

    public static int inDays(Date inDate) {
        if (inDate != null) {
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(inDate);
            return cal.get(GregorianCalendar.DAY_OF_YEAR);
        }
        return NULL;
    }

    public static int inWeeks(Date inDate) {
        if (inDate != null) {
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(inDate);
            return cal.get(GregorianCalendar.WEEK_OF_YEAR);
        }
        return NULL;
    }

    public static int daysInMonth(Date inDate) {
        if (inDate != null) {
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(inDate);
            return cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        }
        return 0;
    }

    public static Date getLastDayOfMonth(Date inDate) {
        if (inDate == null) {
            return null;
        } else {
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(inDate);
            cal.set(GregorianCalendar.DAY_OF_MONTH, cal
                    .getActualMaximum(GregorianCalendar.DAY_OF_MONTH));
            return nullifyTime(cal.getTime());
        }
    }

    public static Date getFirstDayOfMonth(Date inDate) {
        if (inDate == null) {
            return null;
        } else {
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(inDate);
            cal.set(GregorianCalendar.DAY_OF_MONTH, cal
                    .getActualMinimum(GregorianCalendar.DAY_OF_MONTH));
            return nullifyTime(cal.getTime());
        }
    }

    public static Date addDaysToDate(Date inDate1, int days) {
        Date returnDate = null;
        if (inDate1 != null) {
            Calendar c1 = Calendar.getInstance();
            c1.setTime(inDate1);
            c1.add(Calendar.DAY_OF_MONTH, days);

            returnDate = c1.getTime();
        }
        return returnDate;
    }

    public static Date addMonthsToDate(Date inDate1, int months) {
        Date returnDate = null;
        if (inDate1 != null) {
            Calendar c1 = Calendar.getInstance();
            c1.setTime(inDate1);
            c1.add(Calendar.MONTH, months);

            returnDate = nullifyTime(c1.getTime());
        }
        return returnDate;
    }

    public static Date addYearsToDate(Date inDate1, int years) {
        Date returnDate = null;
        if (inDate1 != null) {
            Calendar c1 = Calendar.getInstance();
            c1.setTime(inDate1);
            c1.add(Calendar.YEAR, years);

            returnDate = nullifyTime(c1.getTime());
        }
        return returnDate;
    }

    public static Date nullifyTime(Date a) {
        Calendar c = Calendar.getInstance();
        c.setTime(a);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    public static boolean compareDates(Date inDate1, Date inDate2) {
        return (inDate1.compareTo(inDate2) >= 0);
    }

    public static Date inititalizeDate(String mmddyy) {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date myDate = new Date();
        try {
            myDate = dateFormat.parse(mmddyy);
            myDate.setHours(00);
            myDate.setMinutes(00);
            myDate.setSeconds(00);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return myDate;
    }

    public static String getMonthAndYear(Date paymentDate) {
        StringBuilder stringBuilder = new StringBuilder();
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(paymentDate);
        stringBuilder.append(cal.get(Calendar.MONTH));
        stringBuilder.append(cal.get(Calendar.YEAR));
        return stringBuilder.toString();
    }

    public static int monthsBetweenInclusiveBothMonth(Date fromDate, Date toDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fromDate);
        int fromDateMonth = cal.get(Calendar.MONTH);
        int fromDateYear = cal.get(Calendar.YEAR);
        cal.setTime(toDate);
        int toDateMonth = cal.get(Calendar.MONTH);
        int toDateYear = cal.get(Calendar.YEAR);

        int noofmonths = (toDateYear - fromDateYear) * 12;
        noofmonths = noofmonths + (toDateMonth - fromDateMonth) + 1;
        return noofmonths;
    }

    public static String getAlphaMonthOfTheDate(Date date) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        date = cal.getTime();
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("MMM");
        String month = simpleDateformat.format(date);
        return month;
    }

    public static Timestamp addDays(Timestamp tsTimestamp1, int iNoOfDays) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(tsTimestamp1);
        calendar.add(Calendar.DATE, iNoOfDays);
        return (new Timestamp(calendar.getTimeInMillis()));
    }

    public static Timestamp addMonths(
            Timestamp tsTimestamp1,
            int iNoOfMonths) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(tsTimestamp1);
        calendar.add(Calendar.MONTH, iNoOfMonths);
        return (new Timestamp(calendar.getTimeInMillis()));
    }

    public static Timestamp addYears(Timestamp tsTimestamp1, int iNoOfYears) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(tsTimestamp1);
        calendar.add(Calendar.YEAR, iNoOfYears);
        return (new Timestamp(calendar.getTimeInMillis()));
    }

    public static boolean dateEqualsDateInTimestamp(Timestamp ts, Timestamp ts1) {
        return compareDate(ts, ts1) == 0;
    }

    public static String getStringDate(Timestamp tsTimestamp1) {
        StringBuffer sbDate = new StringBuffer();
        String sDate = null;
        Calendar calendar = new GregorianCalendar();
        if (tsTimestamp1 != null) {
            calendar.setTime(tsTimestamp1);
            int year = (calendar.get(Calendar.YEAR));
            int month = (calendar.get(Calendar.MONTH)) + 1;
            int date = (calendar.get(Calendar.DATE));
            sbDate.append(month);
            sbDate.append("/");
            sbDate.append(date);
            sbDate.append("/");
            sbDate.append(year);
            sDate = sbDate.toString();
        }
        return sDate;
    }

    public static int getDD(Timestamp tsTimestamp1) {
        int iDate = 0;
        Calendar calendar = new GregorianCalendar();
        if (tsTimestamp1 != null) {
            calendar.setTime(tsTimestamp1);
            iDate = (calendar.get(Calendar.DATE));
        }
        return iDate;
    }

    public static int getMM(Timestamp tsTimestamp1) {
        int iMonth = 0;
        Calendar calendar = new GregorianCalendar();
        if (tsTimestamp1 != null) {
            calendar.setTime(tsTimestamp1);
            iMonth = (calendar.get(Calendar.MONTH)) + 1;
        }
        return iMonth;
    }

    public static int getYYYY(Timestamp tsTimestamp1) {
        int iYear = 0;
        Calendar calendar = new GregorianCalendar();
        if (tsTimestamp1 != null) {
            calendar.setTime(tsTimestamp1);
            iYear = (calendar.get(Calendar.YEAR));
        }
        return iYear;
    }

    public static String getStringMMYYYY(Timestamp tsTimestamp1) {
        Calendar calendarInstance1 = Calendar.getInstance();
        StringBuffer sbMMYYYY = new StringBuffer();
        String sMMYYYY = null;
        if (tsTimestamp1 != null) {
            calendarInstance1.setTime(tsTimestamp1);
            sbMMYYYY.append(calendarInstance1.get(Calendar.MONTH) + 1);
            sbMMYYYY.append("/");
            sbMMYYYY.append(calendarInstance1.get(Calendar.YEAR));
            sMMYYYY = sbMMYYYY.toString();
        }
        return sMMYYYY;
    }

    public static String getStringMMDD(Timestamp tsTimestamp1) {
        Calendar calendarInstance1 = Calendar.getInstance();
        StringBuffer sbMMDD = new StringBuffer();
        String sMMDD = null;
        if (tsTimestamp1 != null) {
            calendarInstance1.setTime(tsTimestamp1);
            sbMMDD.append(calendarInstance1.get(Calendar.MONTH) + 1);
            sbMMDD.append("/");
            sbMMDD.append(calendarInstance1.get(Calendar.DATE));
            sMMDD = sbMMDD.toString();
        }
        return sMMDD;
    }

    public static String getStringYYYYMM(Timestamp tsTimestamp1) {
        StringBuffer sbYYYYMM = new StringBuffer();
        String sYYYYMM = null;
        Calendar calendarInstance1 = Calendar.getInstance();
        if (tsTimestamp1 != null) {
            calendarInstance1.setTime(tsTimestamp1);
            int iMonth = (calendarInstance1.get(Calendar.MONTH) + 1);
            StringBuffer sbMonth = new StringBuffer();
            if (iMonth < 10) {
                sbMonth.append("0");
                sbMonth.append(iMonth);
            } else {
                sbMonth.append(iMonth);
            }
            sbYYYYMM.append(calendarInstance1.get(Calendar.YEAR));
            sbYYYYMM.append(sbMonth.toString());
            sYYYYMM = sbYYYYMM.toString();
        }
        return sYYYYMM;
    }

    public static String getStringYYYYMM(Timestamp tsTimestamp1, boolean slash) {
        StringBuffer sbYYYYMM = new StringBuffer();
        String sYYYYMM = null;
        Calendar calendarInstance1 = Calendar.getInstance();
        if (tsTimestamp1 != null) {
            calendarInstance1.setTime(tsTimestamp1);
            int iMonth = (calendarInstance1.get(Calendar.MONTH) + 1);
            StringBuffer sbMonth = new StringBuffer();
            if (iMonth < 10) {
                sbMonth.append("0");
                sbMonth.append(iMonth);
            } else {
                sbMonth.append(iMonth);
            }
            if (slash) {
                sbYYYYMM.append(calendarInstance1.get(Calendar.YEAR));
                sbYYYYMM.append("/");
                sbYYYYMM.append(sbMonth.toString());
                sYYYYMM = sbYYYYMM.toString();
            } else {
                sbYYYYMM.append(calendarInstance1.get(Calendar.YEAR));
                sbYYYYMM.append(sbMonth.toString());
                sYYYYMM = sbYYYYMM.toString();
            }
        }
        return sYYYYMM;
    }

    public static java.sql.Timestamp getFirstDayOfYear(Timestamp tsTimestamp1) {
        int strDay = 01;
        int strMonth = 0;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(tsTimestamp1);
        gregorianCalendar.set((Calendar.DATE), strDay);
        gregorianCalendar.set((Calendar.MONTH), strMonth);
        return new Timestamp(gregorianCalendar.getTimeInMillis());
    }

    public static java.sql.Timestamp resetDate(Timestamp tsTimestamp1) {
        int strDate = 01;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(tsTimestamp1);
        gregorianCalendar.set((Calendar.DATE), strDate);
        return new Timestamp(gregorianCalendar.getTimeInMillis());
    }

    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }

    public static Timestamp getLocalesDate() {
        Locale lCurrentLocale = new Locale("en", "US");
        String dateOut = null;
        DateFormat dateFormatter =
                DateFormat.getDateInstance(DateFormat.DEFAULT, lCurrentLocale);
        dateOut = dateFormatter.format(Calendar.getInstance().getTime());
        Timestamp tsLocalesDate = null;
        try {
            tsLocalesDate = new Timestamp(dateFormatter.parse(dateOut).getTime());
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return tsLocalesDate;
    }

    public static Timestamp getLocalesTimestamp() {
        Locale lCurrentLocale = new Locale("en", "US");
        String dateOut = null;
        DateFormat dateFormatter =
                DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, lCurrentLocale);
        dateOut = dateFormatter.format(Calendar.getInstance().getTime());
        Timestamp tsLocalesDate = null;
        try {
            tsLocalesDate = new Timestamp(dateFormatter.parse(dateOut).getTime());
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return tsLocalesDate;
    }

    public static java.math.BigDecimal getAgeInYearsNMonths(
            Timestamp tsTimestamp1,
            Timestamp tsTimestamp2) {
        int iAge = getMonthsBetween(tsTimestamp1, tsTimestamp2);
        Integer IAge = new Integer(iAge);
        java.math.BigDecimal bdYear =
                new java.math.BigDecimal(IAge.doubleValue() / 12.0);
        return bdYear;
    }

    public static int getMonthsBetween(
            Timestamp tsTimestamp1,
            Timestamp tsTimestamp2) {
        Calendar calendarInstance1 = Calendar.getInstance();
        Calendar calendarInstance2 = Calendar.getInstance();

        java.util.HashMap hmSetDates = setDates(tsTimestamp1, tsTimestamp2);

        Timestamp tsEarlyDate = (Timestamp) hmSetDates.get("dEarlyDate");
        Timestamp tsLateDate = (Timestamp) hmSetDates.get("dLateDate");
        calendarInstance1.setTime(tsEarlyDate);
        calendarInstance2.setTime(tsLateDate);
        return (
                (calendarInstance2.get(Calendar.YEAR) - calendarInstance1.get(Calendar.YEAR))
                        * 12
                        + (calendarInstance2.get(Calendar.MONTH)
                        - calendarInstance1.get(Calendar.MONTH)));
    }

    public static Timestamp getTimeStampFromString(String YYYYMMDD) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        Timestamp tsDate = null;
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(YYYYMMDD));
            tsDate = new Timestamp(cal.getTimeInMillis());
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return tsDate;
    }

    public static long getDaysBetween(
            Timestamp tsTimestamp1,
            Timestamp tsTimestamp2) {
        Calendar calendarInstance1 = Calendar.getInstance();
        Calendar calendarInstance2 = Calendar.getInstance();

        calendarInstance1.setTime(tsTimestamp1);
        calendarInstance2.setTime(tsTimestamp2);
        int year1 = (calendarInstance1.get(Calendar.YEAR));
        int month1 = (calendarInstance1.get(Calendar.MONTH)) + 1;
        int date1 = (calendarInstance1.get(Calendar.DATE));
        int year2 = (calendarInstance2.get(Calendar.YEAR));
        int month2 = (calendarInstance2.get(Calendar.MONTH)) + 1;
        int date2 = (calendarInstance2.get(Calendar.DATE));
        Double julian1 = getJulianDay(year1, month1, date1);
        Double julian2 = getJulianDay(year2, month2, date2);
        Double dJulianDay = new Double(julian2.intValue() - julian1.intValue());
        return Math.abs(dJulianDay.longValue());
    }

    public static Double getJulianDay(int iYear, int iMonth, int iDay) {
        if (iMonth < 3) {
            iYear--;
            iMonth += 12;
        }
        Double A = new Double(Math.floor(iYear / 100.0));
        int a1 = A.intValue();
        Double B = new Double(Math.floor(a1 / 4.0));
        int C = 2 - a1 + B.intValue();
        Double E = new Double(Math.floor(365.25 * (iYear + 4716)));
        Double F = new Double(Math.floor(30.6001 * (iMonth + 1)));
        Double julianDay = new Double((double) C + iDay + E.intValue() + F.intValue() - 1524.5);
        if (julianDay.compareTo(new Double(2299160.5)) < 0) {
            System.out.println("Throw some exception");
        }
        return julianDay;
    }

    public static Timestamp getFirstDayOfDate(Timestamp tsTimestamp1) {
        int strDay = 01;

        GregorianCalendar gregorianCalendar = new GregorianCalendar();

        gregorianCalendar.setTime(tsTimestamp1);
        gregorianCalendar.set((Calendar.DATE), strDay);

        return (new Timestamp(gregorianCalendar.getTimeInMillis()));
    }

    public static Timestamp getFirstDayOfNextMonth(Timestamp tsTimestamp1) {
        int iFirstDate = 01;

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(tsTimestamp1);
        int iNextMonth = gregorianCalendar.get(Calendar.MONTH) + 1;
        gregorianCalendar.set((Calendar.DATE), iFirstDate);
        gregorianCalendar.set((Calendar.MONTH), iNextMonth);
        return (new Timestamp(gregorianCalendar.getTimeInMillis()));
    }

    public static Timestamp getFirstDayOfCurrentMonth(Timestamp tsTimestamp1) {
        int iFirstDate = 01;

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(tsTimestamp1);
        int iNextMonth = gregorianCalendar.get(Calendar.MONTH);
        gregorianCalendar.set((Calendar.DATE), iFirstDate);
        gregorianCalendar.set((Calendar.MONTH), iNextMonth);
        return (new Timestamp(gregorianCalendar.getTimeInMillis()));
    }

    public static Timestamp getLastDayOfDate(Timestamp tsTimestamp1) {

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (tsTimestamp1 != null) {
            gregorianCalendar.setTime(tsTimestamp1);
        }
        int nDay = gregorianCalendar.get(Calendar.DATE);
        int nMonthIndex = gregorianCalendar.get(Calendar.MONTH);
        int nYear = gregorianCalendar.get(Calendar.YEAR);
        int strDay = 0;
        if ((nMonthIndex == 1) && (gregorianCalendar.isLeapYear(nYear))) {
            strDay = 29;
        } else if (nMonthIndex == 1) {
            strDay = 28;
        } else if (
                (nMonthIndex == 3)
                        || (nMonthIndex == 5)
                        || (nMonthIndex == 8)
                        || (nMonthIndex == 10)) {
            strDay = 30;
        } else {
            strDay = 31;
        }
        gregorianCalendar.set((Calendar.DATE), strDay);
        return (new Timestamp(gregorianCalendar.getTimeInMillis()));
    }

    public static Timestamp getLastDayOfPreviousMonth(
            Timestamp tsTimestamp1) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();

        gregorianCalendar.setTime(tsTimestamp1);
        int iDay = gregorianCalendar.get(Calendar.DATE);
        int iMonthIndex = gregorianCalendar.get(Calendar.MONTH);
        int iYear = gregorianCalendar.get(Calendar.YEAR);
        int iLastDay = 0;
        if (iMonthIndex == 0) {
            iMonthIndex = 11;
            iYear = iYear - 1;
        } else {
            iMonthIndex = iMonthIndex - 1;
        }
        if ((iMonthIndex == 1) && (gregorianCalendar.isLeapYear(iYear))) {
            iLastDay = 29;
        } else if (iMonthIndex == 1) {
            iLastDay = 28;
        } else if (
                (iMonthIndex == 3)
                        || (iMonthIndex == 5)
                        || (iMonthIndex == 8)
                        || (iMonthIndex == 10)) {
            iLastDay = 30;
        } else {
            iLastDay = 31;
        }
        gregorianCalendar.set((Calendar.DATE), iLastDay);
        gregorianCalendar.set((Calendar.MONTH), iMonthIndex);
        gregorianCalendar.set((Calendar.YEAR), iYear);

        return new Timestamp(gregorianCalendar.getTimeInMillis());
    }

    public static Timestamp getLastDayOfCurrentMonth(
            Timestamp tsTimestamp1) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();

        gregorianCalendar.setTime(tsTimestamp1);
        int iDay = gregorianCalendar.get(Calendar.DATE);
        int iMonthIndex = gregorianCalendar.get(Calendar.MONTH);
        int iYear = gregorianCalendar.get(Calendar.YEAR);
        int iLastDay = 0;
        if (iMonthIndex == 0) {
            iMonthIndex = 11;
            iYear = iYear - 1;
        } else {
            iMonthIndex = iMonthIndex;
        }
        if ((iMonthIndex == 1) && (gregorianCalendar.isLeapYear(iYear))) {
            iLastDay = 29;
        } else if (iMonthIndex == 1) {
            iLastDay = 28;
        } else if (
                (iMonthIndex == 3)
                        || (iMonthIndex == 5)
                        || (iMonthIndex == 8)
                        || (iMonthIndex == 10)) {
            iLastDay = 30;
        } else {
            iLastDay = 31;
        }
        gregorianCalendar.set((Calendar.DATE), iLastDay);
        gregorianCalendar.set((Calendar.MONTH), iMonthIndex);
        gregorianCalendar.set((Calendar.YEAR), iYear);

        return new Timestamp(gregorianCalendar.getTimeInMillis());
    }

    public static ArrayList getMonthsArrayBetween(
            Timestamp tsTimestamp1,
            Timestamp tsTimestamp2) {
        Calendar calendarInstance1 = Calendar.getInstance();
        Calendar calendarInstance2 = Calendar.getInstance();

        ArrayList arrayList = new ArrayList();
        ArrayList arrayList1 = new ArrayList();

        if (tsTimestamp2 == null) {
            calendarInstance1.setTime(tsTimestamp1);
            StringBuffer sbMonth = new StringBuffer();
            sbMonth.append(calendarInstance1.get(Calendar.MONTH) + 1);
            sbMonth.append("/");
            sbMonth.append(calendarInstance1.get(Calendar.YEAR));
            arrayList.add(sbMonth);
        } else {
            java.util.HashMap hmSetDates = setDates(tsTimestamp1, tsTimestamp2);

            Timestamp tsEarlyDate = (Timestamp) hmSetDates.get("dEarlyDate");
            Timestamp tsLateDate = (Timestamp) hmSetDates.get("dLateDate");
            calendarInstance1.setTime(tsEarlyDate);
            calendarInstance2.setTime(tsLateDate);
            int iMonth2 = calendarInstance2.get(Calendar.MONTH) + 1;
            int iYear2 = calendarInstance2.get(Calendar.YEAR);
            int iMonth1 = calendarInstance1.get(Calendar.MONTH) + 1;
            int iYear1 = calendarInstance1.get(Calendar.YEAR);
            int temp = 1;
            if (iYear2 == iYear1) {
                StringBuffer sbMonth = null;
                for (int j = iYear2; j >= iYear1; j--) {
                    for (int k = iMonth2; k >= iMonth1; k--) {
                        sbMonth = new StringBuffer();
                        sbMonth.append(k);
                        sbMonth.append("/");
                        sbMonth.append(j);
                        arrayList.add(sbMonth.toString());
                    }
                }
            } else {
                for (int j = iYear2; j >= iYear1; j--) {
                    if (j != iYear1) {
                        temp = 1;
                    } else {
                        temp = iMonth1;
                    }
                    StringBuffer sbMonth = null;
                    for (int k = iMonth2; k >= temp; k--) {
                        sbMonth = new StringBuffer();
                        sbMonth.append(k);
                        sbMonth.append("/");
                        sbMonth.append(j);
                        arrayList.add(sbMonth.toString());
                    }
                    iMonth2 = 12;
                }
            }
        }
        int si = arrayList.size();
        for (int i = (si - 1); i >= 0; i--) {
            arrayList1.add(arrayList.get(i).toString());
        }
        return arrayList1;
    }

    public static int getMonthsIncludedBetween(
            Timestamp tsTimestamp1,
            Timestamp tsTimestamp2) {
        Calendar calendarInstance1 = Calendar.getInstance();
        Calendar calendarInstance2 = Calendar.getInstance();

        java.util.HashMap hmSetDates = setDates(tsTimestamp1, tsTimestamp2);
        Timestamp tsEarlyDate = (Timestamp) hmSetDates.get("dEarlyDate");
        Timestamp tsLateDate = (Timestamp) hmSetDates.get("dLateDate");
        calendarInstance1.setTime(tsEarlyDate);
        calendarInstance2.setTime(tsLateDate);
        return (
                (calendarInstance2.get(Calendar.YEAR) - calendarInstance1.get(Calendar.YEAR))
                        * 12
                        + ((calendarInstance2.get(Calendar.MONTH)
                        - calendarInstance1.get(Calendar.MONTH))
                        + 1));
    }

    public static Timestamp getPreviousDay(Timestamp tsFromThisDate) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();

        gregorianCalendar.setTime(tsFromThisDate);
        int iDay = gregorianCalendar.get(Calendar.DATE);
        gregorianCalendar.set((Calendar.DATE), iDay - 1);
        return new Timestamp(gregorianCalendar.getTimeInMillis());
    }

    public static String getPreviousDate(Timestamp tsFromThisDate) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();

        gregorianCalendar.setTime(tsFromThisDate);
        int iDay = gregorianCalendar.get(Calendar.DATE);
        gregorianCalendar.set((Calendar.DATE), iDay - 1);
        StringBuffer sbPreviousDate = new StringBuffer();
        sbPreviousDate.append(gregorianCalendar.get(Calendar.MONTH) + 1);
        sbPreviousDate.append("-");
        sbPreviousDate.append(gregorianCalendar.get(Calendar.DATE));
        sbPreviousDate.append("-");
        sbPreviousDate.append(gregorianCalendar.get(Calendar.YEAR));
        return sbPreviousDate.toString();
    }

    public static String getPreviousTimeStamp(Timestamp tsFromThisDate) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();

        gregorianCalendar.setTime(tsFromThisDate);
        int iDay = gregorianCalendar.get(Calendar.DATE);
        gregorianCalendar.set((Calendar.DATE), iDay - 1);
        StringBuffer sbPreviousDate = new StringBuffer();
        sbPreviousDate.append(gregorianCalendar.get(Calendar.MONTH) + 1);
        sbPreviousDate.append("/");
        sbPreviousDate.append(gregorianCalendar.get(Calendar.DATE));
        sbPreviousDate.append("/");
        sbPreviousDate.append(gregorianCalendar.get(Calendar.YEAR));
        return sbPreviousDate.toString();
    }

    public static String getPreviousMonth(Timestamp tsGivenTimestamp) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();

        gregorianCalendar.setTime(tsGivenTimestamp);
        int iMonth = gregorianCalendar.get(Calendar.MONTH);
        gregorianCalendar.set((Calendar.MONTH), iMonth - 1);
        StringBuffer sbPreviousMonth = new StringBuffer();
        sbPreviousMonth.append(gregorianCalendar.get(Calendar.MONTH) + 1);
        sbPreviousMonth.append("/");
        sbPreviousMonth.append(gregorianCalendar.get(Calendar.DATE));
        sbPreviousMonth.append("/");
        sbPreviousMonth.append(gregorianCalendar.get(Calendar.YEAR));
        return sbPreviousMonth.toString();
    }

    public static Timestamp getTimestamp(java.util.Date dDate1) {
        return new Timestamp(dDate1.getTime());
    }

    public static Timestamp getTimestamp(Timestamp tsDate1) {
        return tsDate1;
    }

    public static int getYearsBetween(
            java.sql.Timestamp tsYearsBetween1,
            java.sql.Timestamp tsYearsBetween2) {
        Calendar calendarInstance1 = Calendar.getInstance();
        Calendar calendarInstance2 = Calendar.getInstance();

        int iYearsBetweenDates = 0;
        java.util.HashMap hmSetDates = setDates(tsYearsBetween1, tsYearsBetween2);

        Timestamp tsEarlyDate = (Timestamp) hmSetDates.get("dEarlyDate");
        Timestamp tsLateDate = (Timestamp) hmSetDates.get("dLateDate");
        calendarInstance1.setTime(tsEarlyDate);
        calendarInstance2.setTime(tsLateDate);
        iYearsBetweenDates =
                calendarInstance2.get(Calendar.YEAR) - calendarInstance1.get(Calendar.YEAR);
        calendarInstance1.add(Calendar.YEAR, iYearsBetweenDates);
        if ((calendarInstance1.getTime()).getTime()
                > (calendarInstance2.getTime()).getTime()) {
            return (iYearsBetweenDates - 1);
        } else {
            return (iYearsBetweenDates);
        }
    }

    private static HashMap setDates(Timestamp tsSetDate1, Timestamp tsSetDate2) {
        HashMap hmSetDates = new HashMap();

        Timestamp tsEarlyDate = null;

        Timestamp tsLateDate = null;
        if (tsSetDate1.after(tsSetDate2)) {
            tsEarlyDate = tsSetDate2;
            tsLateDate = tsSetDate1;
        } else {
            tsEarlyDate = tsSetDate1;
            tsLateDate = tsSetDate2;
        }
        hmSetDates.put("dEarlyDate", tsEarlyDate);
        hmSetDates.put("dLateDate", tsLateDate);
        return hmSetDates;
    }

    public static Timestamp subDays(Timestamp tsTimestamp1, int iNoOfDays) {

        Calendar calendar = new GregorianCalendar();

        calendar.setTime(tsTimestamp1);
        calendar.add(Calendar.DATE, -iNoOfDays);
        return (new Timestamp(calendar.getTimeInMillis()));
    }

    public static Timestamp subMonths(
            Timestamp tsTimestamp1,
            int iNoOfMonths) {

        Calendar calendar = new GregorianCalendar();

        calendar.setTime(tsTimestamp1);
        calendar.add(Calendar.MONTH, -iNoOfMonths);
        return (new Timestamp(calendar.getTimeInMillis()));
    }

    public static Timestamp subYears(Timestamp tsTimestamp1, int iNoOfYears) {

        Calendar calendar = new GregorianCalendar();

        calendar.setTime(tsTimestamp1);
        calendar.add(Calendar.YEAR, -iNoOfYears);
        return (new Timestamp(calendar.getTimeInMillis()));
    }

    public static java.sql.Timestamp getTimestamp(String sMonth, String sYear) {
        int imonth = 0;
        int iday = 1;
        if (sMonth.equals("January")) {
            imonth = 1;
        } else if (sMonth.equals("February")) {
            imonth = 2;
        } else if (sMonth.equals("March")) {
            imonth = 3;
        } else if (sMonth.equals("April")) {
            imonth = 4;
        } else if (sMonth.equals("May")) {
            imonth = 5;
        } else if (sMonth.equals("June")) {
            imonth = 6;
        } else if (sMonth.equals("July")) {
            imonth = 7;
        } else if (sMonth.equals("August")) {
            imonth = 8;
        } else if (sMonth.equals("September")) {
            imonth = 9;
        } else if (sMonth.equals("October")) {
            imonth = 10;
        } else if (sMonth.equals("November")) {
            imonth = 11;
        } else if (sMonth.equals("December")) {
            imonth = 12;
        }
        StringBuffer sbDate = new StringBuffer();
        sbDate.append(imonth);
        sbDate.append("/");
        sbDate.append(iday);
        sbDate.append("/");
        sbDate.append(sYear);
        return getTimestamp(sbDate.toString());
    }

    public static java.sql.Timestamp getMinTimestamp(ArrayList alTimestamp) {
        java.sql.Timestamp tsMinTimestamp = null;
        java.sql.Timestamp tsFirstTimestamp = null;
        java.sql.Timestamp tsNextTimestamp = null;
        int iTimestampSize = alTimestamp.size();
        for (int i = 0; i < iTimestampSize; i++) {
            if (i <= iTimestampSize - 2) {
                tsFirstTimestamp = (Timestamp) alTimestamp.get(i);
                tsNextTimestamp = (Timestamp) alTimestamp.get(i + 1);
                if (i == 0) {
                    tsMinTimestamp = tsFirstTimestamp;
                }
                if (dateLTDateInTimestamp(tsNextTimestamp, tsMinTimestamp)
                        == true) {
                    tsMinTimestamp = tsNextTimestamp;
                }
            }
        }
        return tsMinTimestamp;
    }

    public static java.sql.Timestamp getMaxTimestamp(ArrayList alTimestamp) {
        java.sql.Timestamp tsMaxTimestamp = null;
        java.sql.Timestamp tsFirstTimestamp = null;
        java.sql.Timestamp tsNextTimestamp = null;
        int iTimestampSize = alTimestamp.size();
        for (int i = 0; i < iTimestampSize; i++) {
            if (iTimestampSize == 1) {
                tsMaxTimestamp = (Timestamp) alTimestamp.get(0);
            } else if (i <= iTimestampSize - 2) {
                tsFirstTimestamp = (Timestamp) alTimestamp.get(i);
                tsNextTimestamp = (Timestamp) alTimestamp.get(i + 1);
                if (i == 0) {
                    tsMaxTimestamp = tsFirstTimestamp;
                }
                if (dateGTDateInTimestamp(tsNextTimestamp, tsMaxTimestamp)
                        == true) {
                    tsMaxTimestamp = tsNextTimestamp;
                }
            }
        }
        return tsMaxTimestamp;
    }

    public static boolean dateGTDateInTimestamp(Timestamp ts, Timestamp ts1) {
        return compareDate(ts, ts1) > 0;
    }

    private static HashMap setConvertedDates(
            java.sql.Timestamp tsTimestamp1,
            java.sql.Timestamp tsTimestamp2) {

        Timestamp dConvertedDate1 = null;
        Timestamp dConvertedDate2 = null;
        HashMap hmConvertedDates = new HashMap();

        Locale currentLocale = new Locale("en", "US");
        int style = DateFormat.MEDIUM;
        DateFormat formatter = DateFormat.getDateInstance(style, currentLocale);

        String sDate1 = formatter.format(tsTimestamp1);
        String sConvertedDate1 = getConvertedDate(sDate1);
        dConvertedDate1 = getDate(sConvertedDate1);

        String sDate2 = formatter.format(tsTimestamp2);
        String sConvertedDate2 = getConvertedDate(sDate2);
        dConvertedDate2 = getDate(sConvertedDate2);
        hmConvertedDates.put("dConvertedDate1", dConvertedDate1);
        hmConvertedDates.put("dConvertedDate2", dConvertedDate2);
        return hmConvertedDates;
    }

    public static String getConvertedDate(String sMediumDate) {

        char[] outDate = new char[10];
        int len = sMediumDate.length();

        if (len == 12) {
            sMediumDate.getChars(4, 6, outDate, 3);
            sMediumDate.getChars(8, 12, outDate, 6);

        } else if (len == 11) {
            outDate[3] = '0';
            sMediumDate.getChars(4, 5, outDate, 4);
            sMediumDate.getChars(7, 11, outDate, 6);
        }
        outDate[2] = '/';
        outDate[5] = '/';
        char[] monthName = new char[3];
        sMediumDate.getChars(0, 3, monthName, 0);
        if (monthName[0] == 'J' && monthName[1] == 'a' && monthName[2] == 'n') {
            outDate[0] = '0';
            outDate[1] = '1';
        } else if (monthName[0] == 'F' && monthName[1] == 'e' && monthName[2] == 'b') {
            outDate[0] = '0';
            outDate[1] = '2';
        } else if (monthName[0] == 'M' && monthName[1] == 'a' && monthName[2] == 'r') {
            outDate[0] = '0';
            outDate[1] = '3';
        } else if (monthName[0] == 'A' && monthName[1] == 'p' && monthName[2] == 'r') {
            outDate[0] = '0';
            outDate[1] = '4';
        } else if (monthName[0] == 'M' && monthName[1] == 'a' && monthName[2] == 'y') {
            outDate[0] = '0';
            outDate[1] = '5';
        } else if (monthName[0] == 'J' && monthName[1] == 'u' && monthName[2] == 'n') {
            outDate[0] = '0';
            outDate[1] = '6';
        } else if (monthName[0] == 'J' && monthName[1] == 'u' && monthName[2] == 'l') {
            outDate[0] = '0';
            outDate[1] = '7';
        } else if (monthName[0] == 'A' && monthName[1] == 'u' && monthName[2] == 'g') {
            outDate[0] = '0';
            outDate[1] = '8';
        } else if (monthName[0] == 'S' && monthName[1] == 'e' && monthName[2] == 'p') {
            outDate[0] = '0';
            outDate[1] = '9';
        } else if (monthName[0] == 'O' && monthName[1] == 'c' && monthName[2] == 't') {
            outDate[0] = '1';
            outDate[1] = '0';
        } else if (monthName[0] == 'N' && monthName[1] == 'o' && monthName[2] == 'v') {
            outDate[0] = '1';
            outDate[1] = '1';
        } else if (monthName[0] == 'D' && monthName[1] == 'e' && monthName[2] == 'c') {
            outDate[0] = '1';
            outDate[1] = '2';
        }
        return new String(outDate);
    }

    public static String getStringDateWithZero(Timestamp tsTimestamp1) {
        StringBuffer sbDate = new StringBuffer();
        String sDate = null;

        Calendar calendar = new GregorianCalendar();
        if (tsTimestamp1 != null) {
            calendar.setTime(tsTimestamp1);
            int iYear = (calendar.get(Calendar.YEAR));
            int iMonth = (calendar.get(Calendar.MONTH)) + 1;
            int iDate = (calendar.get(Calendar.DATE));
            StringBuffer sbMonth = new StringBuffer();
            if (iMonth < 10) {
                sbMonth.append("0");
                sbMonth.append(iMonth);
            } else {
                sbMonth.append(iMonth);
            }
            StringBuffer sbDay = new StringBuffer();
            if (iDate < 10) {
                sbDay.append("0");
                sbDay.append(iDate);
            } else {
                sbDay.append(iDate);
            }
            sbDate.append(sbMonth);
            sbDate.append("/");
            sbDate.append(sbDay);
            sbDate.append("/");
            sbDate.append(iYear);
            sDate = sbDate.toString();
        }
        return sDate;
    }

    private static boolean isSaturdaySunday(Timestamp tsIsSaturdaySunday) {
        boolean bIsSaturdaySunday = false;
        try {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(tsIsSaturdaySunday);
            int iDayOfWeek = gregorianCalendar.get(Calendar.DAY_OF_WEEK);
            if ((iDayOfWeek == Calendar.SATURDAY) || (iDayOfWeek == Calendar.SUNDAY)) {
                bIsSaturdaySunday = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bIsSaturdaySunday;
    }

    public static Timestamp getTimestampFromCustomTags(String sYYYYMMDD) {
        StringBuffer sbMMDDYYYY = new StringBuffer();
        try {
            if (sYYYYMMDD != null) {
                sbMMDDYYYY.append(sYYYYMMDD, 5, 7);
                sbMMDDYYYY.append("/");
                sbMMDDYYYY.append(sYYYYMMDD, 8, 10);
                sbMMDDYYYY.append("/");
                sbMMDDYYYY.append(sYYYYMMDD, 0, 4);
            }
        } catch (Exception e) {
          e.printStackTrace();
        }
        return getTimestamp(sbMMDDYYYY.toString());
    }

    public static Timestamp getTimestamp(String sMMDDYYYY) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(false);
        Timestamp tsDate = null;
        if (!(sMMDDYYYY.equals(""))) {
            try {
                tsDate = new Timestamp(sdf.parse(sMMDDYYYY).getTime());
            } catch (java.text.ParseException e) {
              e.printStackTrace();
            }
            return tsDate;
        } else {
            return null;
        }
    }

    public static String getStringYYYYMMDD(Timestamp tsTimestamp1) {
        StringBuffer sbYYYYMM = new StringBuffer();
        String sYYYYMM = null;
        Calendar calendarInstance1 = Calendar.getInstance();
        if (tsTimestamp1 != null) {

            calendarInstance1.setTime(tsTimestamp1);
            int iMonth = (calendarInstance1.get(Calendar.MONTH) + 1);

            StringBuffer sbMonth = new StringBuffer();
            if (iMonth < 10) {
                sbMonth.append("0");
                sbMonth.append(iMonth);
            } else {
                sbMonth.append(iMonth);
            }
            sbYYYYMM.append(calendarInstance1.get(Calendar.YEAR));
            sbYYYYMM.append("/");
            sbYYYYMM.append(sbMonth.toString());
            sbYYYYMM.append("/");
            sbYYYYMM.append(calendarInstance1.get(Calendar.DATE));
            sYYYYMM = sbYYYYMM.toString();
        }
        return sYYYYMM;
    }

    public static boolean isRangeOverlapping(Timestamp[] datesToCompare, ArrayList<Timestamp[]> rangeDates) {
        Timestamp begDate = datesToCompare[0];
        Timestamp endDate = datesToCompare[1];
        if (endDate == null) {
            endDate = getDate("12312999");
        }

        if (dateLTDateInTimestamp(endDate, begDate)) {
            return true;
        }
        for (int i = 0; i < rangeDates.size(); i++) {
            Timestamp rangeBegDate = rangeDates.get(i)[0];
            Timestamp rangeEndDate = rangeDates.get(i)[1];
            if (rangeBegDate == null) {
                rangeBegDate = getDate("12311900");
            }
            if (rangeEndDate == null) {
                rangeEndDate = getDate("12312999");
            }
            if ((dateGTEQDateInTimestamp(begDate, rangeBegDate) && dateLTEQDateInTimestamp(begDate, rangeEndDate))
                    || (dateGTEQDateInTimestamp(endDate, rangeBegDate) && dateLTEQDateInTimestamp(endDate, rangeEndDate))) {
                return true;
            }
        }
        return false;
    }

    public static Timestamp getDate(String MMDDYYYY) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(false);
        java.util.Date date = null;
        Timestamp tsDate = null;
        Calendar cal = Calendar.getInstance();
        try {
            date = sdf.parse(MMDDYYYY);
            cal.setTime(sdf.parse(MMDDYYYY));
            tsDate = new Timestamp(cal.getTimeInMillis());
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return tsDate;
    }

    public static boolean dateLTDateInTimestamp(Timestamp ts, Timestamp ts1) {
        boolean breturn = compareDate(ts, ts1) < 0;
        return breturn;
    }

    public static boolean dateGTEQDateInTimestamp(Timestamp ts, Timestamp ts1) {
        return compareDate(ts, ts1) >= 0;
    }

    public static boolean dateLTEQDateInTimestamp(Timestamp ts, Timestamp ts1) {
        return compareDate(ts, ts1) <= 0;
    }

    private static int compareDate(Timestamp ts, Timestamp ts1) {
        if (ts.getYear() < ts1.getYear()) return -1;
        if (ts.getYear() > ts1.getYear()) return 1;
        if (ts.getMonth() < ts1.getMonth()) return -1;
        if (ts.getMonth() > ts1.getMonth()) return 1;
        if (ts.getDate() < ts1.getDate()) return -1;
        if (ts.getDate() > ts1.getDate()) return 1;
        return 0;
    }

    public static List<Date> getWeekendsInAYear(int year) throws ParseException {
        // create a Calendar for the 1st of the required month
        List<Date> date = new ArrayList<>();
        for (int month = Calendar.JANUARY; month < Calendar.DECEMBER; month++) {
            Calendar cal = new GregorianCalendar(year, month, 1);
            do {
                // get the day of the week for the current day
                int day = cal.get(Calendar.DAY_OF_WEEK);
                // check if it is a Saturday or Sunday
                if (day == Calendar.SATURDAY || day == Calendar.SUNDAY) {
                    date.add(OldDateUtilities.nullifyTime(cal.getTime()));
                }
                // advance to the next day
                cal.add(Calendar.DAY_OF_YEAR, 1);
            } while (cal.get(Calendar.MONTH) == month);
            // stop when we reach the start of the next month
        }
        return date;
    }

    public static List<Date> getLastNFridays(int n) throws ParseException {
        // create a Calendar for the 1st of the required month
        List<Date> lastNFridayDates = new ArrayList<>();
        //Calendar cal = new GregorianCalendar(year, month, 1);
        Calendar calendar = Calendar.getInstance();
        int daysBackToFriday = 0;
        //System.out.println(authTimestamp);
        for (int i = 0; i < n; i++) {
            daysBackToFriday = calendar.get(Calendar.DAY_OF_WEEK) + 1;
            calendar.add(Calendar.DATE, daysBackToFriday*-1);
            //System.out.println(sdf.format(calendar.getTime()));
            lastNFridayDates.add(OldDateUtilities.nullifyTime(calendar.getTime()));
        }
            return lastNFridayDates;
    }

    public static List<DateTime> findLastNFridaysJodaTime(int N) {
        if(N < 1)
            return null;

        List<DateTime> ret = new ArrayList<DateTime>();
        DateTime today = DateTime.now();
        DateTime sameDayLastWeek = today.minusWeeks(1);

        //Friday of last week
        DateTime fridayOfWeek = sameDayLastWeek.withDayOfWeek(DateTimeConstants.FRIDAY);
        //DateTime saturdayOfLastWeek = fridayOfWeek.plusDays(1);
        ret.add(fridayOfWeek);
        //ret.add(saturdayOfLastWeek);
        for (int i = 0; i < N-1; i++) {
            fridayOfWeek = fridayOfWeek.minusWeeks(1);
            ret.add(fridayOfWeek);
        }
        return ret;
    }
}

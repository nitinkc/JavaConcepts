package com.nitin.a19CalandarNCurrency.jodaTime;

/**
 * Created by nichaurasia on Wednesday, May/06/2020 at 5:54 PM
 */

public class NFridays {
    public static void main(String[] args) {
        [‎5/‎6/‎2020 5:34 PM]  Shah, Karan:
        DateTime today = DateTime.now();
        DateTime sameDayLastWeek = today.minusWeeks(1);
        fridayOfWeek = sameDayLastWeek.withDayOfWeek(DateTimeConstants.FRIDAY);

[‎5/‎6/‎2020 5:35 PM]
        ok thanks

[‎5/‎6/‎2020 5:35 PM]  Shah, Karan:
        while(dashboardStart.isBefore(fridayOfWeek)){

            lastWeekMonth = fridayOfWeek.toString("MM");
            lastWeekDay = fridayOfWeek.toString("dd");
            lastWeekYear = fridayOfWeek.toString("yyyy");
            weeksDropdownList.add(lastWeekMonth + "/" + lastWeekDay + "/" + lastWeekYear);

            fridayOfWeek = fridayOfWeek.minusWeeks(1);
            saturdayOfLastWeek = saturdayOfLastWeek.minusWeeks(1);

        }


    }
}

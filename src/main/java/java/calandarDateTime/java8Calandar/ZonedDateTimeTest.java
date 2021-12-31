package java.calandarDateTime.java8Calandar;

import java.time.ZonedDateTime;

public class ZonedDateTimeTest {
    public static void main(String[] args) {
        ZonedDateTime orderEnterDate = ZonedDateTime.parse("2021-05-05T23:55:48.772Z");
        ZonedDateTime orderStartDate = ZonedDateTime.parse("2021-05-05T23:55:19.413Z");
        ZonedDateTime orderStopDate = ZonedDateTime.parse("2021-05-05T23:55:19.413Z");

        System.out.println(orderEnterDate.toLocalDate());//Taking only the date part
        System.out.println(orderStartDate);
        System.out.println(orderStopDate);


        retroFlagUpdate(orderEnterDate,orderStartDate,orderStopDate );

    }

    public static void retroFlagUpdate(ZonedDateTime orderEnterDate, ZonedDateTime orderStartDate, ZonedDateTime orderStopDate){
        if (null !=orderStopDate &&  orderStartDate.isAfter(orderStopDate)){
            System.out.println("...1...EXCEPTION Start date should not less than Stop date");
        }
        if (orderStartDate.toLocalDate().isBefore(orderEnterDate.toLocalDate())){//Considering the Date part only
            System.out.println("...2...Start date IS BEFORE Stop date");
            System.out.println("Setting retro active flag");
        }
        if (orderStartDate.toLocalDate().isEqual(orderEnterDate.toLocalDate())){//Considering the Date part only
            System.out.println("...3...Start date IS EQUAL Stop date");
            System.out.println("Setting retro active flag");
        }

    }
}

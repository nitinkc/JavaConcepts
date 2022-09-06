package nitin.calandarDateTime.java8Calandar.zonedDateTime;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class ZonedDateTimeTest {
    public static void main(String[] args) {
        ZonedDateTime enterDate = ZonedDateTime.parse("2021-05-05T23:55:48.772Z");
        ZonedDateTime startDate = ZonedDateTime.parse("2021-05-05T23:55:19.413Z");
        ZonedDateTime stopDate = ZonedDateTime.parse("2021-05-05T23:55:19.413Z");

        System.out.println(enterDate.toLocalDate());//Taking only the date part

        if (null != stopDate && startDate.isAfter(stopDate)) {
            System.out.println("...1...EXCEPTION Start date should not less than Stop date");
        }
        if (startDate.toLocalDate().isBefore(enterDate.toLocalDate())) {//Considering the Date part only
            System.out.println("...2...Start date IS BEFORE Stop date");
        }
        if (startDate.toLocalDate().isEqual(enterDate.toLocalDate())) {//Considering the Date part only
            System.out.println("...3...Start date IS EQUAL Stop date");
        }

        ZonedDateTime start = ZonedDateTime.parse("2022-03-08T11:20:48.854+0530", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
        ZonedDateTime stop = ZonedDateTime.parse("2022-03-07T23:50:48.854-0600", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));

        if (startDate.toLocalDate().isEqual(enterDate.toLocalDate())) {
            System.out.println("...1...EXCEPTION Start date should not less than Stop date");
        }

        if(start.isEqual(stop)){
            System.out.println("...2...EXCEPTION Start date equals Stop date");
        }

        System.out.println("###################################################");
        ZonedDateTime approvalStartDate = ZonedDateTime.parse("2022-03-01T23:00:00.000-0530",DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));//2022-03-31 22:59:59.999, 2022-02-28 23:00:00.000
        ZonedDateTime approvalEndDate    = ZonedDateTime.parse("2022-04-01T03:59:59.999Z");

        System.out.println("Approval Start Date: " + approvalStartDate.toLocalDate().toString().replace("-", "/"));
        System.out.println("Approval Start Date: " + approvalStartDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));

        System.out.println("###################################################");

        System.out.println(fromDate(approvalEndDate));
    }

    public static Timestamp fromDate(ZonedDateTime date) {
        return Optional.of(Timestamp.valueOf(date.toLocalDateTime())).orElse(null);
    }
}

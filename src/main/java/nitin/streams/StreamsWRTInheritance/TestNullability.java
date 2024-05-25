package nitin.streams.StreamsWRTInheritance;


import com.entity.Student;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class TestNullability {
    public static void main(String[] args) {
        /* Using map to modify a5object */
        String myDateTimePattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

        ZoneId zone = ZoneId.systemDefault();
        ZoneId india = ZoneId.of("Asia/Kolkata");

        ZonedDateTime timeInNashville = ZonedDateTime.now(zone);

        String zonedDateTime = Optional.ofNullable(timeInNashville)
                .map(time -> {
                    String sb = "Time in " + zone + " : " +
                            time.format(DateTimeFormatter.ofPattern(myDateTimePattern)) +
                            "\n" +
                            "Time in " + india + " : " +
                            ZonedDateTime.now(india).format(DateTimeFormatter.ofPattern(myDateTimePattern));
                    return sb;
                })
                .orElse("");

        System.out.println(zonedDateTime);
    }

    public static void logStudent(Student student) {

        String sb = "Result is " +
                Optional.of(student.getFirstName()).orElse("") + "," +
                (null != student.getLastName() ? student.getLastName() : "") + "," +
                (null != student.getAddress() ? student.getAddress() : "") + "," +
                (null != student.getDob() ? student.getDob() : "");

        System.out.println(sb);
    }
}

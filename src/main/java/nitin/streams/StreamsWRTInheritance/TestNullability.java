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
                    StringBuilder sb = new StringBuilder();
                    sb.append("Time in "+ zone+ " : ");
                    sb.append(time.format(DateTimeFormatter.ofPattern(myDateTimePattern)));
                    sb.append("\n");
                    sb.append("Time in "+ india+ " : ");
                    sb.append(ZonedDateTime.now(india).format(DateTimeFormatter.ofPattern(myDateTimePattern)));
                    return sb.toString();
                })
                .orElse(new StringBuilder().toString());

        System.out.println(zonedDateTime);
    }

    public static void logStudent(Student student) {

        StringBuilder sb = new StringBuilder();
        sb.append("Result is ")
                .append(Optional.of(student.getFirstName()).orElse("")).append(",")
                .append(null != student.getLastName() ? student.getLastName()  :"").append(",")
                .append(null != student.getAddress() ? student.getAddress()  :"").append(",")
                .append(null != student.getDob()? student.getDob():"");

        System.out.println(sb.toString());
    }
}

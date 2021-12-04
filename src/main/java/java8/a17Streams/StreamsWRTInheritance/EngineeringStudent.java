package java8.a17Streams.StreamsWRTInheritance;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author Created by nichaurasia
 * @create on Tuesday, September/29/2020 at 3:20 AM
 */

@Getter
@Setter
public class EngineeringStudent extends Student {
    private int yearEnrolled;

    public EngineeringStudent(String firstName, String lastName, Date dob, Ethnicity ethnicity, Address address,
                              Long enrollmentNumber, StudentOf studentOf, int yearEnrolled) {
        super(firstName, lastName, dob, ethnicity, address, enrollmentNumber, studentOf);
        this.yearEnrolled = yearEnrolled;
    }
}

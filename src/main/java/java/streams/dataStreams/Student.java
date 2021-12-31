package java.streams.dataStreams;

import lombok.*;

import java.util.Date;

/**
 * Created by nitin on Sunday, January/05/2020 at 12:00 AM
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Student {
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;
    private Date dob;
    private int salary;
}

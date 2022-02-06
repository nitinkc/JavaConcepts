package nitin.streams.StreamsWRTInheritance;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Created by nichaurasia
 * Created on Tuesday, September/29/2020 at 7:36 PM
 */

@Getter
@Setter
public class Employee extends Person {
    private String employer;
    private double salary;
    private char level;
    private int experience;

    public Employee(String firstName, String lastName, Date dob, Ethnicity ethnicity, Address address,
                    String employer, double salary, char level, int experience) {
        super(firstName, lastName, dob, ethnicity, address);
        this.employer = employer;
        this.experience = experience;
        this.level = level;
        this.experience = experience;
    }
}

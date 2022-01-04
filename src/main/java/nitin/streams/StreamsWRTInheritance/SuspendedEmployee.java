package nitin.streams.StreamsWRTInheritance;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Created by nichaurasia
 * Created on Tuesday, September/29/2020 at 7:39 PM
 */

@Getter
@Setter
public class SuspendedEmployee extends Employee {
    private String suspensionReasonCode;
    private String suspensionDuration;

    public SuspendedEmployee(String firstName, String lastName, Date dob, Ethnicity ethnicity, Address address,
                             String employer, double salary, char level, int experience, String suspensionReasonCode,
                             String suspensionDuration) {
        super(firstName, lastName, dob, ethnicity, address, employer, salary, level, experience);
        this.suspensionReasonCode = suspensionReasonCode;
        this.suspensionDuration = suspensionDuration;
    }
}

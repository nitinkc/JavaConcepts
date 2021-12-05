package sandbox.test;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;
    private double salary;
}



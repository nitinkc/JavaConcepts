package nitin.generic.oReilly.a3Max;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Employee {

    // Provide a default value for the orElse method
    public static final Employee DEFAULT_EMPLOYEE = new Employee(0, "No Name");

    private final int id;
    private final String name;
}

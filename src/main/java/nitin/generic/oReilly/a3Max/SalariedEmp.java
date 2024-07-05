package nitin.generic.oReilly.a3Max;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalariedEmp extends Employee {
    private double salary;

    public SalariedEmp(int id, String name) {
        super(id, name);
    }
}

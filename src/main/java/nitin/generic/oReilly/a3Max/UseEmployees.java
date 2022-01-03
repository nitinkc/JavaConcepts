package nitin.generic.oReilly.a3Max;

import java.util.ArrayList;
import java.util.List;

public class UseEmployees {
    public static void main(String[] args) {
        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee(1, "Fred"));

        Salaried salaried = new Salaried(2, "Barney");
        emps.add(salaried);

        System.out.println(emps);
    }
}

package java11.test;

import java.util.ArrayList;
import java.util.List;

public class EmpTest {
    public static void main(String[] args) {
        Employee e1 = new Employee("Jane","","Joe",34,90000);
        Employee e2 = new Employee("Andrew","J","Smith",29,80000);
        Employee e3 = new Employee("Dustin","John","Zimmerman",37,85000);
        Employee e4 = new Employee("John","","Joe",34,70000);
        Employee e5 = new Employee("Henry","David","Thoreau",34,69000);

        List<Employee> list = new ArrayList<>();

        list.add(e1);list.add(e2);list.add(e3);list.add(e4);list.add(e5);

    }
}

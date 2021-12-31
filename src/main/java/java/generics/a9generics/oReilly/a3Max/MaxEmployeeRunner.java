package java.generics.a9generics.oReilly.a3Max;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

public class MaxEmployeeRunner {

    private Employee maxId1;

    public static void main(String[] args) {
        List<Employee> employees = createEmployees();

        System.out.println("With Comparator of T, Employee");
        Employee maxId0 = employees.stream()
                //Since no comparator is implemented by Employee class, we can still find max by providing the implementation here
                .max(new Comparator<Employee>() {// Anonymous Class
                    @Override
                    public int compare(Employee o1, Employee o2) {
                        return o1.getId() - o2.getId();
                    }
                })
                .orElse(Employee.DEFAULT_EMPLOYEE);

        System.out.println(maxId0);

        // LAMBDA-FICATION
        Employee maxId = employees.stream()
                .max((Employee e1, Employee e2) -> e1.getId() - e2.getId())
                .orElse(Employee.DEFAULT_EMPLOYEE);

        System.out.println(maxId);

        System.out.println("**************************************************");

        System.out.println("With Comparator of Super T i.e Object");

        // For Object Class only toString option is present
        Employee maxId1 = employees.stream()
                //Since no comparator is implemented by Employee class, we can still find max by providing the implementation here
                .max(new Comparator<Object>() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        return o1.toString().compareTo(o2.toString());
                    }
                })
                .orElse(Employee.DEFAULT_EMPLOYEE);

        System.out.println(maxId1);

        Employee maxName = employees.stream()
                .max((Object o1, Object o2) -> o2.toString().compareTo(o1.toString()))
                .orElse(Employee.DEFAULT_EMPLOYEE);


        System.out.println(maxName + " : Name has characters : " + maxName.getName().length());

        System.out.println("***************************** Using Static Method reference *****************************");

        // Using Static Method reference
        maxId = employees.stream()
                //Have a look at ComparingInt method
                .max(comparingInt(Employee::getId))
                .orElse(Employee.DEFAULT_EMPLOYEE);

        maxName = employees.stream()
                .max(comparing(Object::toString))
                .orElse(Employee.DEFAULT_EMPLOYEE);
        System.out.println(maxId);
        System.out.println(maxName);
    }

    public static List<Employee> createEmployees() {
        return Arrays.asList(
                new Employee(1, "Haradanahalli Doddegowda Deve Gowda"),
                new Employee(2, "Avul Pakir Jainulabdeen Abdul Kalam"),
                new Employee(3, "Dr. Sarvepalli Radhakrishnan"),
                new Employee(4, "Kocheril Raman Narayanan")
        );
    }
}

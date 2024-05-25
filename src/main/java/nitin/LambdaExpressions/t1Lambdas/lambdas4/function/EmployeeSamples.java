package nitin.LambdaExpressions.t1Lambdas.lambdas4.function;

import java.util.Arrays;
import java.util.List;

public class EmployeeSamples {
    private static final Employee[] sampleEmployees = {
            new Employee("Harry", "Hacker", 1, 234_567),
            new Employee("Polly", "Programmer", 2, 333_333),
            new Employee("Cody", "Coder", 8, 199_999),
            new Employee("Devon", "Developer", 11, 175_000),
            new Employee("Desiree", "Designer", 14, 212_000),
            new Employee("Archie", "Architect", 16, 144_444),
            new Employee("Tammy", "Tester", 19, 166_777),
            new Employee("Sammy", "Sales", 21, 45_000),
            new Employee("Larry", "Lawyer", 22, 33_000),
            new Employee("Amy", "Accountant", 25, 85_000)
    };

    private EmployeeSamples() {
    } // Uninstantiatable class

    public static List<Employee> getSampleEmployees() {
        return (Arrays.asList(sampleEmployees));
    }

    public static Employee randomEmployee() {
        return (RandomUtils.randomElement(sampleEmployees));
    }
}

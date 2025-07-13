package nitin.streams.collectors;

import com.entity.EmployeeSimple;
import com.entity.SampleData;
import java.util.*;
import java.util.stream.Collectors;

public class C1Introduction {

    public static void main(String[] args) {
        sharedMutabilityWrapper(); // DO NOT DO THIS
        sharedMutabilityClass(); // Do not Do
        sharedMutabilityReduce(); // Thread safe with reduce
        usingCollector(); // Thread safe with collectors
        creatingMap(); // using key mapper adn value mapper FUNCTION
        unmodifiableList();
        commaSeparatedList();
    }

    private static void commaSeparatedList() {
        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        // Off-by-one error
        String commaSeparatedNamesWithExtra = "";
        for (EmployeeSimple employeeSimple : employees) {
            commaSeparatedNamesWithExtra =
                    commaSeparatedNamesWithExtra + employeeSimple.getName() + " ,";
        }

        System.out.println(commaSeparatedNamesWithExtra);
        // Remove the last comma -> unnecessary smell in the code
        // Write logic to remove

        // Avoid off-by-one error,mm using joining
        String commaSeparatedNames = "";
        commaSeparatedNames =
                employees.stream()
                        .map(employeeSimple -> employeeSimple.getName())
                        .filter(Objects::nonNull)
                        // .map(String::toUpperCase)
                        .collect(Collectors.joining(", "));

        System.out.println(commaSeparatedNames);
    }

    private static void unmodifiableList() {
        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        // Return a map with name as key and age as value
        List<Integer> ages = new ArrayList<>();
        ages = Collections.unmodifiableList(ages);

        ages =
                employees.stream()
                        .filter(Objects::nonNull)
                        .filter(employee -> null != employee.getAge())
                        .map(employeeSimple -> employeeSimple.getAge())
                        // .collect(Collectors.toList());
                        .collect(Collectors.toUnmodifiableList());

        // Boom
        ages.add(999); // mutability with regular collection, can be avoided by using unmodifiable
        // list

        System.out.println(ages);
    }

    private static void creatingMap() {
        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        // Return a map with name as key and age as value
        Map<String, Integer> nameAgeMap = new HashMap<>();

        nameAgeMap =
                employees.stream()
                        .parallel()
                        .filter(employee -> null != employee.getAge())
                        // .collect(Collectors.toMap(keyFunction, valueFunction));
                        // .collect(Collectors.toMap(employee -> employee.getName(),employee ->
                        // employee.getAge()))
                        .collect(Collectors.toMap(EmployeeSimple::getName, EmployeeSimple::getAge));

        System.out.println(nameAgeMap);
    }

    private static void usingCollector() {
        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        // Return the list of names of employees, in upper case, younger than 25
        List<String> youngEmployees = new ArrayList<>();

        youngEmployees =
                employees.stream()
                        .filter(Objects::nonNull)
                        .filter(employee -> null != employee.getAge())
                        .filter(employee -> employee.getAge() < 25)
                        .map(EmployeeSimple::getName) // get the name
                        // .map(str -> str.toUpperCase())
                        .map(String::toUpperCase) // convert to upper case
                        .collect(
                                Collectors
                                        .toList()); // ThreadSafe and can handle concurrency easily
        // toSet can also be done with just one change
    }

    private static void sharedMutabilityReduce() {
        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        // Return the list of names of employees, in upper case, younger than 25
        List<String> youngEmployees = new ArrayList<>();

        youngEmployees =
                employees.stream()
                        .parallel()
                        .filter(Objects::isNull)
                        .filter(employee -> employee.getAge() < 25)
                        .map(EmployeeSimple::getName) // get the name
                        .map(String::toUpperCase) // convert to upper case
                        .reduce( // Can work with parallel streams
                                new ArrayList<
                                        String>(), // Local mutability, internal mutability, no
                                // outside arrayList is used
                                (names, name) -> { // there is no side effect
                                    names.add(name);
                                    return names;
                                },
                                (names1, names2) -> { // Add all the mini lists into a bigger list
                                    names1.addAll(names2);
                                    return names1;
                                });
    }

    private static void sharedMutabilityWrapper() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Create a list of double of even numbers
        List<Integer> doubleOfEven = new ArrayList<>();

        numbers.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .forEach(e -> doubleOfEven.add(e)); // Shared mutability.

        System.out.println(doubleOfEven);
    }

    private static void sharedMutabilityClass() {
        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        // Return the list of names of employees, in upper case, younger than 25
        List<String> youngEmployees = new ArrayList<>();

        employees.stream()
                .parallel()
                .filter(Objects::isNull)
                .filter(employee -> employee.getAge() < 25)
                .map(EmployeeSimple::getName) // get the name
                .map(String::toUpperCase) // convert to upper case
                .forEach(
                        upprCaseEmp ->
                                youngEmployees.add(
                                        upprCaseEmp)); // Don't do this. Shared mutabilty is evil.
        // This code can't ever be parallelized and it will misbehave.
    }
}

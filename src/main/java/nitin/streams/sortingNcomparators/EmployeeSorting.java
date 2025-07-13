package nitin.streams.sortingNcomparators;

import com.entity.EmployeeSimple;
import com.entity.SampleData;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/** Created by nichaurasia on Thursday, February/13/2020 at 11:50 AM */
public class EmployeeSorting {
    public static void main(String[] args) {
        final List<EmployeeSimple> list = SampleData.getSimpleEmployees();

        /* System.out.println("Sorting with ageDifference method");
        //sortAgeByAgeDiffMethod(list);
        System.out.println();

        System.out.println("Sorting with stream sorted (Comparator.comparing)");
        //sortUsingAgeLambda(list);

        System.out.println("Reverse Sorting with stream sorted (Comparator.comparing)");
        reverseSortUsingAgeLambda(list);

        System.out.println("Reverse Sorting with age and if age is same, sort by salary sorted (Comparator.comparing)");
        reverseSortUsingAgeNSalaryLambda(list);

        System.out.println("Employee with max age");
        //maxAgeEmployee(list);

        System.out.println("Employee with max salary");
        //maxSalaryEmployee(list);

        System.out.println("Employee with min salary");
        //minSalaryEmployee(list);

        System.out.println("Employee with min salary");
        //minSalaryEmployee(list);

        System.out.println("Employee with distinct age");
        // TODO :: find the way
        //distinctAgeEmployee(list);*/
        test(list).stream().forEach(System.out::println);
    }

    private static void distinctAgeEmployee(List<EmployeeSimple> list) {
        list.stream().filter(x -> x.getAge() > 0).distinct().forEach(System.out::println);
    }

    private static void minSalaryEmployee(List<EmployeeSimple> list) {
        System.out.println(list.stream().min(Lambdas.salaryLambda).get());
    }

    private static void maxSalaryEmployee(List<EmployeeSimple> list) {
        System.out.println(list.stream().max(Lambdas.salaryLambda).get());
    }

    private static void reverseSortUsingAgeNSalaryLambda(List<EmployeeSimple> employees) {

        employees.stream()
                .sorted(Lambdas.revAgeLambda.thenComparing(Lambdas.salaryLambda))
                .forEach(System.out::println);
    }

    private static void reverseSortUsingAgeLambda(List<EmployeeSimple> list) {
        Comparator<EmployeeSimple> salaryComparator =
                (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary());
        Comparator<EmployeeSimple> salaryComparatorMethodRef = EmployeeSimple::salaryDifference;
        list.stream().sorted(EmployeeSimple::salaryDifference).forEach(System.out::println);
    }

    private static void maxAgeEmployee(List<EmployeeSimple> list) {
        EmployeeSimple e = list.stream().max(Lambdas.ageLambda).get();
        System.out.println(e);
    }

    private static void sortUsingAgeLambda(List<EmployeeSimple> list) {
        list.stream().sorted(Lambdas.ageLambda).forEach(System.out::println);
    }

    private static void sortAgeByAgeDiffMethod(List<EmployeeSimple> list) {
        list.stream().sorted(Lambdas.ageLambda).forEach(System.out::println);
    }

    private static List<String> test(List<EmployeeSimple> list) {
        List<String> empList =
                list.stream()
                        .sorted(
                                Comparator.comparing(
                                        EmployeeSimple::getSalary,
                                        Comparator.nullsLast(Comparator.naturalOrder())))
                        .map(
                                employee -> {
                                    String sb =
                                            employee.getName()
                                                    + " has a salary of "
                                                    + employee.getSalary()
                                                    + " at the age of "
                                                    + employee.getAge();
                                    return sb;
                                })
                        .collect(Collectors.toList());

        return empList;
    }
}

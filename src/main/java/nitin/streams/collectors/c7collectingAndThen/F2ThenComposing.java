package nitin.streams.collectors.c7collectingAndThen;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;

import com.entity.EmployeeSimple;
import com.entity.SampleData;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class F2ThenComposing {
    public static void main(String[] args) {
        // groupingBy, mapping, filtering -> taking first argument (function or predicate) and
        // second argument as Collector
        // It means, first apply the function or Predicate and then Collect

        // collectingAndThen -> Collector as first argument adn then Function as second argument

        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        // Find the names of the employees and the corrosponding count
        findNameCount(employees);

        /*employees.stream()
        .filter(Objects::nonNull).filter(emp -> null != emp.getAge()).filter(emp -> null != emp.getName())
        .collect(Collectors.groupingBy(emp -> emp.getName(), emp.);*/

    }

    private static void findNameCount(List<EmployeeSimple> employeeSimples) {
        Map<String, Integer> byName =
                employeeSimples.stream()
                        .filter(Objects::nonNull)
                        .filter(emp -> null != emp.getAge())
                        .filter(emp -> null != emp.getName())
                        .collect(
                                groupingBy(
                                        EmployeeSimple::getName, // First Argument of Grouping By
                                        collectingAndThen( // Collector as Second Argument of
                                                // Grouping By
                                                Collectors
                                                        .counting(), // Collector as First argument
                                                // of CAT (collectingNThen)
                                                Long::intValue // finisher function as second
                                                // Argument
                                                ) // CollectingAndThen returns a Collector, so it
                                        // can be further continued
                                        // Function.identity() can be used if there is no
                                        // mapper/transformer/convertor/enricher needed
                                        ));

        System.out.println(byName); // {Wayne=2, Don=1, John=3, Jane=1, Dow=1}
    }
}

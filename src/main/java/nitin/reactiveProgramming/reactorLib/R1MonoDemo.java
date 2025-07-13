package nitin.reactiveProgramming.reactorLib;

import com.entity.EmployeeSimple;
import com.entity.SampleData;
import java.util.List;
import java.util.Optional;
import reactor.core.publisher.Mono;

public class R1MonoDemo {
    public static void main(String[] args) {
        Optional<List<EmployeeSimple>> simpleEmployees =
                Optional.of(SampleData.getSimpleEmployees());

        // Creating Publisher
        Mono<List<EmployeeSimple>> employeeJust = Mono.just(SampleData.getSimpleEmployees());

        // Evaluated only when subscibed. just like Streams Lazy evaluation

        // Single Subscribe
        employeeJust.subscribe(
                empList ->
                        empList.stream()
                                .forEach(
                                        singleEmployee ->
                                                System.out.println(
                                                        singleEmployee.getName()
                                                                + "::"
                                                                + singleEmployee.getSalary())));
    }
}

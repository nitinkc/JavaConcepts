package nitin.reactiveProgramming.reactorLib;

import com.entity.EmployeeSimple;
import com.entity.SampleData;
import com.github.javafaker.Faker;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class R2MultiSubscribe {
    public static void main(String[] args) {
        //Creating Publisher
//        Mono<List<EmployeeSimple>> employeeJust = Mono.just(SampleData.getSimpleEmployees())
//                .map(employeeSimples -> employeeSimples.stream().filter());

        //Evaluated only when subscibed. just like Streams Lazy evaluation

        //Single Subscribe
//        employeeJust.subscribe(empList -> empList
//                .stream()
//                .forEach(singleEmployee ->
//                        System.out.println(singleEmployee.getName() + "::" + singleEmployee.getSalary())));

        String fakeName = Faker.instance().funnyName().name();
        Mono<String> stringMono = Mono
                .just(fakeName)
                .map(fName -> fName + " : " + fName.length()/0)
                ;

        //Subscribe with single parameter
        stringMono.subscribe(item -> System.out.println("Received from Publisher :: "+ item));

        //
        stringMono.subscribe(
                item -> System.out.println(item),//onNext, consumer
                err -> System.out.println(err.getMessage()),//onError, Throwable
                () -> System.out.println("-- Completed --")//onComplete, Runnable
        );
    }
}

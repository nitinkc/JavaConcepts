package nitin.streams.collectors.c5flatMapping;

import static java.util.stream.Collectors.*;

import com.entity.EmployeeSimple;
import com.entity.SampleData;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class C6FlatMapping {

    // <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
    // <R> Stream<R> map    (Function<? super T, ? extends R> mapper);

    // groupingBy, mapping, filtering -> taking first argument (function or predicate) and second
    // argument as Collector
    // It means, first apply the function or Predicate and then Collect

    // collectingAndThen -> Collector as first argument adn then Function as second argument

    // map first and flattening later -> mapFlattening -> flatMap
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        one2one(numbers);
        one2Many(numbers);
        one2manyFlatMap(numbers);

        // Find the age and unique characters in employees name
        findAgeAndUniqueChars();
    }

    private static void findAgeAndUniqueChars() {
        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        System.out.println(
                employees.stream()
                        .filter(Objects::nonNull)
                        .filter(emp -> null != emp.getAge())
                        .filter(emp -> null != emp.getName())
                        .collect(
                                groupingBy(
                                        EmployeeSimple::getAge,
                                        mapping(
                                                EmployeeSimple::getName,
                                                // filtering(name -> name.length() < 4,
                                                Collectors.flatMapping(
                                                        name -> List.of(name.split("")).stream(),
                                                        toList())
                                                // )
                                                ))));
    }

    private static void one2manyFlatMap(List<Integer> numbers) {
        // one-to-many function
        // Stream<T>.map(oneToManyFunction) ==> Stream<R> (not Stream of List of R)
        List<Integer> one2manyflatMap =
                numbers.stream()
                        .flatMap(element -> List.of(element + 1, element - 1).stream())
                        .collect(Collectors.toList());
        // FlatMap is MapFlatten, map first then flat, takes an iterator and a Stream is a iterator
        System.out.println(one2manyflatMap);
    }

    private static void one2Many(List<Integer> numbers) {
        // one-to-many
        // Stream<T>.map(oneToManyFunction) ==> Stream<List<R>>
        List<List<Integer>> one2many =
                numbers.stream()
                        .map(element -> List.of(element + 1, element - 1))
                        .collect(Collectors.toList());
        // use Case : Given a list of employees, give the personal email id's
        System.out.println(one2many);
    }

    private static void one2one(List<Integer> numbers) {
        // one-to-one function
        // Stream<T>.map(oneToOneFunction) ==> Stream<R>
        List<Integer> one2one =
                numbers.stream()
                        .map(element -> element * 2) // Takes a Stream of <T> and returns a Stream
                        // of <R>
                        .collect(Collectors.toList());
        System.out.println(one2one);
    }
}

package nitin.oops.interfaces.functionalInterface.PredefinedFunctionalInterfaces.functionUsage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by nitin on Tuesday, October/08/2019 at 9:01 PM
 * Converting the Strings into integers using a function
 */
public class FunctionUsage {
    public static final int DEFAULT_VALUE = Integer.MAX_VALUE;

    public static void main(String[] args) {
        List<String> lists = Arrays.asList("1", "2", "3", "n", "", null);

        Function<String, Integer> function = x -> NumberUtils.toInt(x, DEFAULT_VALUE);
        Predicate<Integer> predicate = (Integer x) -> (x == DEFAULT_VALUE);

        //MAP is used to apply a function
        List<Integer> intList = lists.stream()
                .map(list -> function.apply(list))
                .collect(Collectors.toList());
        intList.forEach(System.out::println);

        //all the numbers except for the default replacement number
        List<Integer> intList2 = lists.stream()
                .map(function)
                .filter(predicate.negate())
                .collect(Collectors.toList());
        intList2.forEach(System.out::println);

        System.out.println("#######################################################");
        Student student1 = new Student("Tom", 20);
        Student student2 = new Student("Harry", 21);
        Student student3 = new Student("Joe", 22);
        Student student4 = new Student("Jane", 23);
        Student student5 = new Student("Justin", 24);
        Student student6 = new Student("James", 25);

        List<Student> students = Arrays.asList(student1,student2,student3,student4,student5,student6);
       // TransformExecutor<Student,String> transformExecutor2 = new TransformExecutor();

        Function<Student,String> transformer = (stud) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(stud.getName());
            sb.append(" is of age ");
            sb.append(stud.getAge());

            return sb.toString();
        };

        List<String> finalList = students.stream()
                .map(stud -> transformer.apply(stud))
                //.map(transformer)
                .collect(Collectors.toList());


        finalList.forEach(System.out::println);
    }
}

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
class Student{
    String name;
    int age;
}

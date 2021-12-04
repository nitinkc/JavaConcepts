package java8.zJava8Revisions.a1lambdas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by nitin on Tuesday, February/04/2020 at 3:19 AM
 */
public class StreamsRevisionObject {
    public static void main(String[] args) {
        Student s1 = new Student("Bob Square",47,1234L);
        Student s2 = new Student("Zig Ziggler",25,123L);
        Student s3 = new Student("Great Wall",17,124L);
        Student s4 = new Student("Rocky Balboa",32,234L);
        Student s5 = new Student("Stien Balboa",32,234L);


        List<Student> studentList = new ArrayList<>();
        studentList.add(s1);studentList.add(s2);studentList.add(s3);studentList.add(s4);studentList.add(s5);

        // Show Students with Age sort, and name
        Stream.of(s1,s2,s3,s4,s5)
                .sorted(Comparator
                        .comparing(Student::getAge).reversed()
                        .thenComparing(Student::getName).reversed()
                )
                .forEach(System.out::println);

        studentList
                .stream()
                .sorted(Comparator.comparing(Student::getEnrollmentNumber))
                .map((Student s) -> s.getName().toUpperCase())
                .map(str -> str.split(" ")[0])
                .sorted()
                .forEach(System.out::println);


        // Sum Total of all the Student ages.
        System.out.println(
                studentList.stream()
                .map((Student s) -> s.getAge())
                .reduce((s,t)-> s+t)
                .get()
        );
    }
}

@Getter
@Setter
@AllArgsConstructor
@ToString
class Student{
    private String name;
    private int age;
    //private Date dob;
    private Long enrollmentNumber;
}

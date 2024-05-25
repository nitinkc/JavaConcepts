package nitin.a6oops.interfaces.functionalInterface.PredefinedFunctionalInterfaces.sorting;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class F6ComparatorAsLambda {
    public static void main(String[] args) {

        Set<Student> students = new TreeSet<Student>(Comparator
                .comparing(Student::getName)
                .thenComparing(Student::getAge)
                .thenComparing((Student s1) -> s1.getName().length())
        );

        addElements(students);
        students.forEach(System.out::println);
    }

    private static void addElements(Set<Student> students) {
        Student s1 = new Student("name1", 23);
        Student s2 = new Student("name2", 24);
        Student s3 = new Student("yname3", 25);
        Student s4 = new Student("zname4", 24);
        Student s5 = new Student("zname4", 24);

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
    }
}

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
class Student {
    String name;
    int age;
}

package nitin.collections.a_list.ArrayList.ListSortingApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/** Created by synergisticit on 2/26/2016. */
public class ListSortDriver {
    public static void main(String[] args) {
        Student s1 = new Student(4, "ducy", "Taylor", "Jenkov Taylor");
        Student s2 = new Student(2, "Tracy", "Rajaei", "Bill Taylor");
        Student s3 = new Student(1, "Joe", "Kresman", "Andrew Taylor");
        Student s4 = new Student(4, "lucy", "Green", "Taylor Zimmarman");

        List<Student> students = new ArrayList<Student>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        System.out.println("List before sorting");
        for (Student s : students) {
            System.out.println(s);
        }

        Collections.sort(students, new StudentComparator());
        System.out.println("List after Sorting");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}

@Data
@AllArgsConstructor
class Student {
    int id;
    String fName;
    String lName;
    String fathersFullName;
}

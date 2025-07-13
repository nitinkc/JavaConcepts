package nitin.streams.StreamsWRTInheritance;

import com.entity.SampleData;
import com.entity.Student;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Created by nichaurasia Created on Tuesday, September/29/2020 at 10:24 PM
 */
public class StudentRunner {
    public static void main(String[] args) {
        List<Student> studentList = SampleData.getStudents();

        studentList =
                studentList.stream()
                        .filter(student -> student.getFirstName().startsWith("A"))
                        .collect(Collectors.toList());

        studentList.stream().forEach(x -> System.out.println(x));
    }
}

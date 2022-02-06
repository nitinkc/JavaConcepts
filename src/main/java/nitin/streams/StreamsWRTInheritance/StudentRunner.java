package nitin.streams.StreamsWRTInheritance;

import nitin.streams.StreamsWRTInheritance.data.StudentData;

import java.util.List;

/**
 * @author Created by nichaurasia
 * Created on Tuesday, September/29/2020 at 10:24 PM
 */

public class StudentRunner {
    public static void main(String[] args) {
        List<? extends Student> studentList = StudentData.createStudent();

        studentList.stream()
                .filter(student -> student.getFirstName().startsWith("A"))
                .forEach(System.out::println);
    }
}

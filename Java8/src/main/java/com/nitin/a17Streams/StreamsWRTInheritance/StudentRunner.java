package com.nitin.a17Streams.StreamsWRTInheritance;

import com.nitin.a17Streams.StreamsWRTInheritance.data.StudentData;

import java.util.List;

/**
 * @Author Created by nichaurasia
 * @create on Tuesday, September/29/2020 at 10:24 PM
 */

public class StudentRunner {
    public static void main(String[] args) {
        List<? extends Student> studentList = StudentData.createStudent();

        studentList.stream()
                .filter(student -> student.getFirstName().startsWith("A"))
                .forEach(System.out::println);
    }
}

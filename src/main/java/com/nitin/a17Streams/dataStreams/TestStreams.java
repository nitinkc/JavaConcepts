package com.nitin.a17Streams.dataStreams;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by nitin on Sunday, January/05/2020 at 12:02 AM
 */
public class TestStreams {
    public static void main(String[] args) {
        Student s1 = new Student("Nitin","Kumar","Chaurasia",34,new Date(1985,06,11),90000);
        Student s2= new Student("Kirti","","Chaurasia",29,new Date(1989,03,28),80000);
        Student s3 = new Student("Mohandas","Karamchand","Gandhi",134,new Date(1869,11,02),85000);
        Student s4 = new Student("John","","Joe",34,new Date(1985,06,11),70000);
        Student s5 = new Student("Nitin","","Chaurasia",34,new Date(1986,06,11),69000);

        List<Student> list = new ArrayList<>();
        list.add(s1);list.add(s2);list.add(s3);list.add(s4);list.add(s5);
        //Stream<Student> listStream = Stream.of(s1,s2,s3,s4,s5);

        /* Map takes a function */
        list.stream()
                .map((Student s) -> s.getSalary())
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println)
        ;

        // Filtering the folks based on the salary
        /*list.stream()
                .filter(s -> s.getSalary() > 80000)
                //.collect(Collectors.toList())
                .forEach(System.out :: println);

        Student result = list.stream()
                .filter((s -> s.getSalary() > 80000))
                .findFirst()
                .orElse(null);
        System.out.println("Filtering the folks based on the salary\n");
        System.out.println(result);

        list.stream()
                .map(s -> s.getDob())
                .sorted()
                .forEach(System.out::println);
*/
    }
}

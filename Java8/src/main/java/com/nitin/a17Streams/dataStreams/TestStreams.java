package com.nitin.a17Streams.dataStreams;

import java.util.*;
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
        Stream.of(s1,s2,s3);
        List<Student> list = new ArrayList<>();
        list.add(s1);list.add(s2);list.add(s3);list.add(s4);list.add(s5);
        //Stream<Student> listStream = Stream.of(s1,s2,s3,s4,s5);

        //findAllSalary(list);
        //findSelectiveSalary(list);
        //sortedSalary(list);
        //ageSortedStudents(list);
        //printCapitalNAmes(list);
        playWithRandomInts();
    }

    private static void playWithRandomInts() {
        List<Integer> list = new Random()
                .ints(10,1,100000)
                .boxed()
                //.forEach(System.out::println);
                //.collect(Collectors.toCollection(ArrayList::new));
                .collect(Collectors.toList());

        long result = list.stream()
                .map(x -> x/2)
                .reduce((a,b) -> a+b)
                .get();

        System.out.println(result);
    }

    private static void printCapitalNAmes(List<Student> list) {
        String filler = " ";
        list.stream()
                .map(s -> s.getFirstName().toUpperCase() + filler +
                        s.getMiddleName().toLowerCase() + filler +
                        s.getLastName().toUpperCase())
                .forEach(System.out::println);
    }

    private static void ageSortedStudents(List<Student> list) {
        list.stream()
                .sorted(Comparator
                        .comparing(Student::getAge)
                        .thenComparing(Student::getSalary))
                .forEach(System.out::println);
    }

    private static void findAllSalary(List<Student> list) {
        /* Map takes a function */
        list.stream()
                .map((Student s) -> s.getAge())
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    // Filtering the folks based on the salary
    private static void findSelectiveSalary(List<Student> list) {
        list.stream()
                .filter(s -> s.getSalary() > 80000)
                //.collect(Collectors.toList())
                .forEach(System.out :: println);

        Student result = list.stream()
                .filter((s -> s.getSalary() > 80000))
                .findFirst()
                .orElse(null);
        System.out.println("Filtering the folks based on the salary\n");
        System.out.println(result);
    }

    private static void sortedSalary(List<Student> list){
        list.stream()
                .map(s -> s.getSalary())
                .sorted()
                .forEach(System.out::println);
    }
}
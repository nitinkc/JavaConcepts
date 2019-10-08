package com.nitin.a16functionalInterface.predicateUsage;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by nitin on Tuesday, October/08/2019 at 12:51 AM
 */
public class multipleIfs {
    public static void main(String[] args) {
        Student s1 = new Student(4,"ducy","Taylor","Jenkov Taylor");
        Student s2 = new Student(2,"Tracy","Rajaei","Bill Taylor");
        Student s3 = new Student(1,"Joe","Kresman","Andrew Taylor");
        Student s4 = new Student(4,"lucy","Green","Taylor Zimmarman");

        List<Student> studentList = new ArrayList<Student>();
        studentList.add(s1);studentList.add(s2);
        studentList.add(s3);studentList.add(s4);

        Predicate<String> firstNameLength = str -> (str.length() <= 3);

        //Find out all the students based on firstNameLength predicate

        studentList.stream().filter(firstNameLength).forEach(System.out::println);


    }

}

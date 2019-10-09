package com.nitin.a16functionalInterface.predicateUsage;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by nitin on Tuesday, October/08/2019 at 12:51 AM
 */
public class multipleIfs {
    public static void main(String[] args) {
        Student s1 = new Student(1,"ducy","Taylor","Jenkov Taylor",
                "MEC", (short) 1, Arrays.asList("MEC1001","MEC1002","MEC1003"));

        Student s2 = new Student(2,"Tracy","Rajaei","Bill Taylor", "CSE",
                (short)1, Arrays.asList("CS1001","CS1002","CS1003"));
        Student s3 = new Student(3,"Joe","Kresman","Andrew Taylor","CSE",
                (short)2, Arrays.asList("CS2001","CS2002","CS2003"));
        Student s4 = new Student(4,"lucy","Green","Taylor Zimmarman", "CSE",
                (short)3, Arrays.asList("CS3001","CS3002","CS3003"));

        List<Student> studentList = new ArrayList<Student>();
        studentList.add(s1);studentList.add(s2);
        studentList.add(s3);studentList.add(s4);

        Predicate<Student> firstNameLength = Student -> (Student.getfName().length() <= 3);
        Predicate<Student> deptPredicate = Student -> (Student.getDeptCode().equalsIgnoreCase("mec"));

        //Find out all the students based on firstNameLength predicate
        studentList
                .stream()
                .filter(deptPredicate)
                .forEach(System.out::println);
    }
}

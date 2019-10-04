package com.nitin.a16functionalInterface;
import entity.Student;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class F6ComparatorAsLambda {
    public static void main(String[] args) {
        Student s1 = new Student("name1", 23);
        Student s2 = new Student("name2", 24);
        Student s3 = new Student("name3", 25);
        Student s4 = new Student("name4", 24);

      Comparator<Student> c = (a,b) -> a.getAge() > b.getAge()? -1: 0;
        Set<Student> students = new TreeSet<Student>();

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        students.forEach(System.out :: println);
    }
}

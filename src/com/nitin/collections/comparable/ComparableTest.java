package com.nitin.collections.comparable;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by synergisticit on 2/25/2016
 *
 * If we wish to insert Student object into TreeSet (which needs compare logic), we will get the following error
 * java.lang.ClassCastException if Student doen not implement java.lang.Comparable
 * MNEMONIC BC (conparaBle - ClassCast)
 *
 * Whenever we use Object other THAN WRAPPER
 *
 * This problem CANNOT be solved with COMPARATOR.
 * Comparator can be used when we call java Utility Class
 * collections.sort(List<Integer>, Comparator<...>)
 */
public class ComparableTest {
    public static void main(String[] args) {
        Student s1 = new Student(4,"Lucy","Taylor","Jenkov Taylor");
        Student s2 = new Student(2,"Tracy","Rajaei","Bill Taylor");
        Student s3 = new Student(1,"Joe","Kresman","Andrew Taylor");
        Student s4 = new Student(4,"Lucy","Green","Taylor Zimmarman");

        //HashSet does not need COMPARATOR, but TREE DOES
        Set<Student> studentSet = new TreeSet<Student>();

        studentSet.add(s1);
        studentSet.add(s2);
        studentSet.add(s3);
        studentSet.add(s4);

        Iterator<Student> itr = studentSet.iterator();

        while(itr.hasNext()){
            System.out.println(itr.next());
        }


    }
}

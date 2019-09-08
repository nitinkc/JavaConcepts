package com.nitin.a10collections.comparator;

import java.util.Comparator;

/**
 * Created by synergisticit on 2/26/2016.
 *
 * First Compare with StudentId, if found same, compare with
 * First name. If the first name is also same
 * then compare with the fathers name.
 */
public class StudentComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;

        //System.out.println(s1.id.compareTo(s2.id));

        if(s1.id > s2.id)
            return 1;
        else if (s1.id < s2.id)
            return -1;
        else
            return compareNameCompare(s1,s2);
    }
private int compareNameCompare(Student s1, Student s2) {
    if(s1.fName.compareTo(s2.fName) > 0 )
        return 1;
    else if (s1.fName.compareTo(s2.fName) < 0)
        return -1;
    else
        return compareFathersName(s1,s2);
    }

    private int compareFathersName(Student s1, Student s2) {
        return s1.fathersFullName.compareTo(s2.fathersFullName);
    }
}

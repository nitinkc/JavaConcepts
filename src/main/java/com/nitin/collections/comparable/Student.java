package com.nitin.collections.comparable;

/**
 * Created by synergisticit on 2/25/2016.
 */
public class Student {
    int id;
    String fName;
    String lName;
    String fathersFullName;

    public Student(int id, String fName, String lName, String fathersFullName) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.fathersFullName = fathersFullName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", fathersFullName='" + fathersFullName + '\'' +
                '}';
    }


    // Lexicographical Order
    private int compareFirstNames(Object o) {
        Student curr =(Student)o;
        int ret = this.fName.compareTo(curr.fName);
        if (ret != 0)
            return ret;
        else
            return compareFathersName(o);


    }

    private int compareFathersName(Object o) {
        Student curr =(Student)o;

        return this.fathersFullName.compareTo(curr.fathersFullName);


    }
}


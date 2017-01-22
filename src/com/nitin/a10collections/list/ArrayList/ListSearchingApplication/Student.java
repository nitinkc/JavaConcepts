package com.nitin.a10collections.list.ArrayList.ListSearchingApplication;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (fName != null ? !fName.equals(student.fName) : student.fName != null) return false;
        if (lName != null ? !lName.equals(student.lName) : student.lName != null) return false;
        return fathersFullName != null ? fathersFullName.equals(student.fathersFullName) : student.fathersFullName == null;
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
}
package com.entity;

import java.util.Objects;

public class Student {
    //instance member variables
    private String Name;
    private int Age;

    // parameterized constructor
    public Student(String Name, Integer Age) {
        this.Name = Name;
        this.Age = Age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer Age) {
        this.Age = Age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Age == student.Age &&
                Objects.equals(Name, student.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Age);
    }

    // overriding toString() method
    @Override
    public String toString() {
        return "Student{" + "Name=" + Name + ", Age=" + Age + '}';
    }

}

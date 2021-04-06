package com.nitin.a17Streams.StreamsWRTInheritance;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @Author Created by nichaurasia
 * @create on Tuesday, September/29/2020 at 3:11 AM
 */

@Setter
@Getter
@ToString
public class Student extends Person{
    public Long enrollmentNumber;
    public StudentOf studentOf;

    public Student(String firstName, String lastName, Date dob, Ethnicity ethnicity,
                   Address address, Long enrollmentNumber, StudentOf studentOf) {

        super(firstName, lastName, dob, ethnicity, address);
        this.enrollmentNumber = enrollmentNumber;
        this.studentOf = studentOf;
    }
}

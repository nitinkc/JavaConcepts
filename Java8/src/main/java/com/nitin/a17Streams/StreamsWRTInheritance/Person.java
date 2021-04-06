package com.nitin.a17Streams.StreamsWRTInheritance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @Author Created by nichaurasia
 * @create on Tuesday, September/29/2020 at 2:58 AM
 */

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Person {
    public String firstName;
    public String lastName;
    public Date dob;
    public Ethnicity ethnicity;
    public Address address;
}

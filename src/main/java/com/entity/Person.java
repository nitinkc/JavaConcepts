package com.entity;

import java.util.Date;
import lombok.*;

/**
 * @author Created by nichaurasia Created on Tuesday, September/29/2020 at 2:58 AM
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
@RequiredArgsConstructor
@Builder
public class Person {
    private String firstName;
    private String lastName;
    private Date dob;
    private Ethnicity ethnicity;
    private Address address;
}

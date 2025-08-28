package com.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

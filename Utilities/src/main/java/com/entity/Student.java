package com.entity;


import lombok.*;

@Data
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
public class Student {
    //instance member variables
    private String Name;
    private int Age;
}

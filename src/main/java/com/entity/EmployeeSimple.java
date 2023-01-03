package com.entity;

import lombok.*;

/**
 * Created by nichaurasia on Thursday, February/13/2020 at 11:50 AM
 */

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class EmployeeSimple {
    private String name;
    private Integer age;
    private Double salary;
    private char level;
    private int experience;

    public int ageDifference(final EmployeeSimple other) {
        return this.age - other.age;
    }

    public int salaryDifference(final EmployeeSimple other) {
        return this.getSalary().compareTo(other.getSalary());
    }

    public void printNameWithSalary() {
        System.out.println(this.getName() + " Earns $" + this.getSalary() + " as salary.");
    }
}

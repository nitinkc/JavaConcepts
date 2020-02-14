package com.nitin.sortingNcomparators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by nichaurasia on Thursday, February/13/2020 at 11:50 AM
 */

@Getter
@Setter
@AllArgsConstructor
public class Person {
    private final String name;
    private final int age;

    public int ageDifference(final Person other){
        return this.age - other.age;
    }
    @Override
    public String toString() {
        return String.format("%s - %d", name, age);
    }
}

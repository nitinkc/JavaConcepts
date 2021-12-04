package java8.sortingNcomparators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by nichaurasia on Thursday, February/13/2020 at 11:50 AM
 */

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Employee {
    private final String name;
    private final int age;
    private final double salary;
    private final char  level;
    private final int experience;

    public int ageDifference(final Employee other){
        return this.age - other.age;
    }
}

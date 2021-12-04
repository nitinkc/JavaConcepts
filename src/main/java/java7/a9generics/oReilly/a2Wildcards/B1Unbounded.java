package java7.a9generics.oReilly.a2Wildcards;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

//The idea behind the question mark operator is that when we declare a collection of that type,
// we're saying we don't know what the underlying type is
public class B1Unbounded {
    public static void main(String[] args) {
        List<?> list = Arrays.asList((22/7),"test", LocalDate.now(),'c');

        //size method is independent of underlying data type
        System.out.println(list.size());

        //Invoking Lambda on the list
        list.forEach((Object o) -> System.out.println(o));

        // Cannot write to it.
        //list.add("another String");//incompatible types: java.lang.String cannot be converted to capture#1 of ?

        //CHECK THE contailsAll() METHOD
        System.out.println(list.containsAll(Arrays.asList("test", (22/7))));
    }
}

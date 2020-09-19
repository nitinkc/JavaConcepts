package com.nitin.a9generics.oReilly.a1Inheritance;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BasicInheritance {
    public static void main(String[] args) {
        //Generic list of object that can have any type of Object
        List<Object> objects = new ArrayList<>();
        objects.add("string");
        objects.add(LocalDateTime.now());
        objects.add(3.14);

        System.out.println(objects);

        List<String> strings = new ArrayList<>();

        //Compile time error
        //incompatible types: java.util.List<java.lang.String> cannot be converted to java.util.List<java.lang.Object>
        //List<Object> objectsTest = strings;//eventhough Object is super class of strings
        /* List of Strings is not a subclass of List of Pbjects */

        Object o = "anotherString";  //String is subclass of Object so this is Valid

        //Compile time error:Error:incompatible types: java.lang.Object cannot be converted to java.lang.String
        //strings.add(o);
        strings.add((String)o);

        System.out.println(strings);
    }
}

package com.nitin.zCoreServletsTraining.t1Lambdas.lambdas1.comparator;

import java.awt.*;

public class RandomUtilsTest {
  public static void main(String[] args) {
    String[] names = { "Joe", "John", "Jane" };
    String name = RandomUtils.randomElement(names);
    System.out.println("Selected name: " + name);
    Color[] colors = { Color.RED, Color.GREEN, Color.BLUE };
    Color color = RandomUtils.randomElement(colors);
    System.out.println("Selected color: " + color);
    Person[] people = 
      { new Person("Larry", "Page"), new Person("Larry", "Ellison"),
        new Person("Larry", "Bird"), new Person("Larry", "King") };
    Person person = RandomUtils.randomElement(people);
    System.out.println("Selected person: " + person);
    Integer[] nums = { 1, 2, 3, 4 };    // Integer[], not int[]
    int num = RandomUtils.randomElement(nums);
    System.out.println("Selected number: " + num);
  }
}

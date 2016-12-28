package com.nitin.a1languageFundamentals;

/**
 * Created by Nitin C on 11/25/2015.
 */

class Car1 {

    static int numberofobjects;
    static int numberofwheels = 4;
    int enginecapacity;
    static {
        System.out.println(numberofwheels);
        System.out.println("from static block");
    }

    public Car1() {

        numberofobjects++;
        System.out.println("this is from default constructor of class car");

    }
    public void x()
    {
//	System.out.println(numberofobjects);
    }
}

public class StaticTest {
    int x = 10;

    public static void main(String[] args) {
        Car1 c1 = new Car1();
        Car1 c2 = new Car1();
        System.out.println(c1.numberofobjects);
        Car c3 = new Car();
        //System.out.println(x);
        c1.numberofwheels = 4;
        c1.enginecapacity = 1500;
        // System.out.println(c2.numberofwheels);
        // System.out.println(c3.numberofwheels);

        // System.out.println(c2.enginecapacity);
        // System.out.println(c3.enginecapacity);
    }

}

package nitin.a3accessModifiers.staticTest;

/** Created by Nitin C on 11/25/2015. */
class Car1 {

    static int numberofobjects;
    static int numberofwheels = 4;

    /*
     * Runs FIRST. At Class loading .
     * Can have as many blocks as possible, but the execution will be in sequence. JVM Combines all together
     * */
    static { // Static block 1
        System.out.println("********** Static Block 1 **********************");
        System.out.println(numberofwheels++);
        System.out.println("from static block 1");
        System.out.println("************Static Block END **********************");
    }

    static { // Static Block 2
        System.out.println("********** Static Block 2 **********************");
        System.out.println("from static block 2");
        System.out.println(++numberofwheels);
        System.out.println("*****************Static Block 2 END ************************");
    }

    int enginecapacity;

    public Car1() {

        numberofobjects++;
        System.out.println("this is from default constructor of class car");
    }

    public void x() {
        //	System.out.println(numberofobjects);
    }
}

public class StaticInitializationBlocks {
    int x = 10;

    public static void main(String[] args) {
        Car1 c1 = new Car1();
        Car1 c2 = new Car1();
        // System.out.println(c1.numberofobjects);
        Car1 c3 = new Car1();
        System.out.println(
                "************************************ PROGRAM STARTS HERE *******************************************");
        Car1.numberofwheels = 4;
        c1.enginecapacity = 1500; // non static var, related to each a5object
        System.out.println(Car1.numberofwheels);
        System.out.println(Car1.numberofwheels);

        System.out.println(c2.enginecapacity);
        System.out.println(c3.enginecapacity);
        System.out.println(c1.enginecapacity);
    }
}

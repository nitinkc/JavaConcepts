package nitin.classLoadingJVM;

class Car {
    static Integer numberofwheels = 4;

    /* Runs FIRST. At Class loading .
      Can have as many blocks as possible, but the execution will be in sequence. JVM Combines all together
    */
    static { // Static block 1
        System.out.println("********** Static Block 1 **********************");
        System.out.println(numberofwheels++);
        // enginecapacity++;//Not Accessible here
    }

    static { // Static Block 2
        System.out.println("********** Static Block 2 **********************");
        System.out.println(numberofwheels++);
    }

    private Integer enginecapacity = 0; // If not initiazlized, then constructor gived NPE

    public Car() {
        System.out.println("********** Default Constructor of class **********************");
        System.out.println(numberofwheels++);
        System.out.println(enginecapacity++);
    }

    public static void main(String[] args) {
        Car c = new Car();
    }
}

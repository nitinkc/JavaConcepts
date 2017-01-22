package com.nitin.a7oopsConcepts.interfaces;

/**
 * Created by nitin on 12/29/16.
 *
 * A Class can extend only one class but can implement multiple interfaces
 */
interface Interface {
    void m1();
    void m2();
}

interface AnotherInterface{
    void m1();
    void m3();
    void m4();
}

// Not compulsory to provide all implementation (declare the class as abstract)
 abstract class ServiceProvider implements Interface{

    @Override
    public void m1() {
        System.out.println("From Abstract Class, Not all Methods has to be implemented");
    }
}

// Compulsorily all methods needs to be implemented
class AnotherServiceProvider implements Interface, AnotherInterface{

    // m1 exists in both interfaces. Naming conflict
    @Override
    public void m1() {
        System.out.println("First implementation");
    }

    @Override
    public void m2() {
        System.out.println("Second Implementation");
    }

    @Override
    public void m3() {

    }

    @Override
    public void m4() {

    }
}

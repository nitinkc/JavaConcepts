package nitin.oops.interfaces;

/**
 * Created by nitin on 12/29/16.
 * <p>
 * BasicConnection Class can extend only one class but can implement multiple interfaces
 */
interface Interface {
    void m1();

    void m2();
}

interface AnotherInterface {
    void m1();

    void m3();

    void m4();
}

// Not compulsory to provide all implementation (declare the class as abstract)
abstract class ServiceProvider implements Interface {

    @Override
    public void m1() {
        System.out.println("From Abstract Class, Not all Methods has to be implemented");
    }
}

// Compulsorily all methods needs to be implemented
class AnotherServiceProvider extends ServiceProvider implements Interface, AnotherInterface {

    public static void main(String[] args) {
        AnotherServiceProvider a = new AnotherServiceProvider();
        a.m1();

    }
    // m1 exists in both interfaces. Naming conflict
    // Error: reference to m1() is ambiguous

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
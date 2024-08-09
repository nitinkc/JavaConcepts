package nitin.zKnowYourJava.T7;

public class Base {
    public Base() {//Constructor
        System.out.println("In base");
        check();// The check of the Derived is called
    }

    //No Definition
    public void check() {
    }
}

package nitin.oops.interfaces.a10interfaces.DefaultMethodsInJava8;

/**
 * Created by Nitin Chaurasia on 1/30/18 at 5:20 PM.
 * Since Java 8 onwards, Interface can have concrete implementation in Default method
 */
public class D1Example1 implements DefaultMethodInInterface {
    public static void main(String[] args) {
        D1Example1 d= new D1Example1() ;
        // The method can be over ridden as well in the implementation class
        d.m1();
        d.m2();
    }

    @Override
    public void m2() {
        System.out.println("My own implementation in the Implemented class");
    }
}

interface DefaultMethodInInterface{

    //Default method with implementation, in an Interface
    default void m1(){
        System.out.println("From Default method");
    }

   void m2();
}

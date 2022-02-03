package nitin.oops.interfaces.functionalInterface.methodNconstructorReference;

/**
 * Created by Nitin Chaurasia on 1/30/18 at 10:30 PM.
 */
public class DCO1MethodReference {
    public static void main(String[] args) {
        Interf i = Test :: m2;
        i.m1();//Invokes m2 of Test Class
    }
}

class Test{
    public static void m2(){
        System.out.println("Method m2 from class Test");
    }
}

@FunctionalInterface
interface Interf{
    void m1();
}


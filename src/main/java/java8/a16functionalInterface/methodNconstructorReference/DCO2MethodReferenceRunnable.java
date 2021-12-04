package java8.a16functionalInterface.methodNconstructorReference;

/**
 * Created by Nitin Chaurasia on 1/30/18 at 10:43 PM.
 */
public class DCO2MethodReferenceRunnable {
    public static void main(String[] args) {

        // Using Lambda Expression
        /* Runnable r = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Child thread");
            }
        }; */

        RunTest rt = new RunTest();
        // Referencing m1 method from RunTest class
        Runnable r = rt::m1;

        Thread t = new Thread(r);
        t.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("Main Method");
        }
    }
}

//method m1 is like run method of Runnable class, in terms of arguments and return types
// This is non static method or instance Method
class RunTest{
    public void m1(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Child thread");
        }
    }
}
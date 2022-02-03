package nitin.oops.interfaces.functionalInterface.AnonymousInnerClassVSLambda;

/**
 * Created by Nitin Chaurasia on 1/30/18 at 4:31 PM.
 */
public class F5LambdaThreads {
    public static void main(String[] args) {
        Runnable r = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Child thread");
            }
        };

        Thread t = new Thread(r);
        t.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("Main Thread");
        }
    }
}

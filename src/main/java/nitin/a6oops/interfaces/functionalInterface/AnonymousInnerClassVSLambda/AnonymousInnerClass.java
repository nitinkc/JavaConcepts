package nitin.a6oops.interfaces.functionalInterface.AnonymousInnerClassVSLambda;

/**
 * Created by Nitin Chaurasia on 1/30/18 at 5:04 PM. Anonymous inner class can be replaced with
 * Lambda in some conditions
 */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        Runnable r = new Runnable() { // Anonymous Inner Class
                    @Override
                    public void run() {
                        for (int i = 0; i < 5; i++) {
                            System.out.println("Child Class");
                        }
                    }
                };
        Thread t = new Thread(r);
        t.start();

        // Main thread continues
        for (int i = 0; i < 5; i++) {
            System.out.println("Main Class");
        }
    }
}

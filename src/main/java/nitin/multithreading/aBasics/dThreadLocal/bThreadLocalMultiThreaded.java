package nitin.multithreading.aBasics.dThreadLocal;

/**
 * Created by nitin.chaurasia on 12/26/2016.
 */
public class bThreadLocalMultiThreaded {
    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            Thread c = new Thread("Customer Thread-" + i);
            c.start();
        }
    }
}

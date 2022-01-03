package nitin.multithreading.multithreadingEnhancements.dThreadLocal;

/**
 * Created by nitin.chaurasia on 12/26/2016.
 */
public class CustomerThread extends Thread {
    static int custId = 0;

    private static final ThreadLocal tl = new ThreadLocal(){
        protected Integer initialValue(){
            return ++custId;
        }
    };

    // Constructor
    CustomerThread(String name){
        super(name);
    }

    public void run(){
        System.out.println(Thread.currentThread().getName() + " is Executing with Customer Id : " + tl.get());
    }
}

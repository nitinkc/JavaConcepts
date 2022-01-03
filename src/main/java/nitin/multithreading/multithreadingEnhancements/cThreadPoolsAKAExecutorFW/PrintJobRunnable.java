package nitin.multithreading.multithreadingEnhancements.cThreadPoolsAKAExecutorFW;

/**
 * Created by nitin.chaurasia on 12/26/2016.
 */
public class PrintJobRunnable implements Runnable {

    String name;
    PrintJobRunnable(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " ... Job Started By Thread : " + Thread.currentThread().getName());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + " ... Jon Completed by Thread : " + Thread.currentThread().getName());
    }
}

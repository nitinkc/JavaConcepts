package java7.a13multithreadingEnhancements.aThreadGroups;

/**
 * Created by nitin.chaurasia on 12/25/2016.
 */
public class MyThread extends Thread{
    MyThread(ThreadGroup g, String name){
        super(g,name);
    }

    public void run(){
        System.out.println("Child thread" );
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e){
            //Swallowing the Exception
        }
    }
}

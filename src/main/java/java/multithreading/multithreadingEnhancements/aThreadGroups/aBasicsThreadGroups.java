package java.multithreading.multithreadingEnhancements.aThreadGroups;

/**
 * Created by nitin.chaurasia on 12/25/2016.
 */
public class aBasicsThreadGroups {

    public static void main(String[] args) {

        // Get the Default Thread Grp name
        System.out.println(Thread.currentThread().getThreadGroup());

        //Get the Name of the Parent of the Default ThreadGroup
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());//main, def. MAX_PRIORITY = 5

        ThreadGroup g1 = new ThreadGroup("First thread");
        System.out.println(g1.getParent().getName());//main

        ThreadGroup g2 = new ThreadGroup(g1,"Second thread");
        System.out.println(g2.getParent().getName());//First Thread
    }
}

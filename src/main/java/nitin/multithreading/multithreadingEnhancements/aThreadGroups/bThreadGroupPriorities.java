package nitin.multithreading.multithreadingEnhancements.aThreadGroups;

/**
 * Created by nitin.chaurasia on 12/25/2016.
 */
public class bThreadGroupPriorities {
    public static void main(String[] args) {
        ThreadGroup g = new ThreadGroup("Nitin");

        Thread t1 = new Thread(g, "First Thread");
        Thread t2 = new Thread(g, "Second Thread");

        System.out.println("Default Priorities");
        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        //Threads created after this will have priorities 3
        g.setMaxPriority(3);
        Thread t3 = new Thread(g, "Third thread");

        // Priority of only thread t3 will change
        System.out.println("After Setting MAX_PRIORITY Priorities");
        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        System.out.println(t3.getPriority());

        // prints info about thread grp to the console
        g.list();

    }
}

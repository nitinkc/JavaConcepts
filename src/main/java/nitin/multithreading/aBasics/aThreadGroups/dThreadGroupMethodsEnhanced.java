package nitin.multithreading.aBasics.aThreadGroups;

/**
 * Created by nitin.chaurasia on 12/25/2016.
 * <p>
 * Displaying the System Thread groups MetaData
 */
public class dThreadGroupMethodsEnhanced {
    public static void main(String[] args) {
        ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
        Thread[] t = new Thread[system.activeCount()];

        system.enumerate(t);
        for (Thread t1 : t) {
            System.out.println(t1.getName() + " ... " + t1.isDaemon());
        }
    }
}

package nitin.multithreading.aBasics.executionPrevention;

/**
 * Created by Nitin Chaurasia on 12/3/15 at 2:11 AM.
 * wait() method RELEASE the acquired lock when thread is waiting while
 * Thread.sleep() method keeps the lock or monitor
 * <p>
 * Also wait  should be called from synchronized method or block
 * while there is no such requirement for sleep() method.
 * <p>
 * Another difference isThread.sleep() method is a static method and applies on current thread,
 * while wait() is an instance specific method and only got wake up if some other thread
 * calls notify method on same a5object.
 */
public class T4SleepNWait {
}

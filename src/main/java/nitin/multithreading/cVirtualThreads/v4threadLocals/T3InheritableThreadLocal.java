package nitin.multithreading.cVirtualThreads.v4threadLocals;

import nitin.multithreading.cVirtualThreads.Student;
import static com.utilities.MultiThreadUtility.logShortMessage;

public class T3InheritableThreadLocal {
    // Child thread will see the thread local values of the Parent.
    // Thread local map is automatically copied when the child thread is created
    public static final InheritableThreadLocal<Student> studentInheritableThreadLocal = new InheritableThreadLocal<>();
    
    public static void main(String[] args) throws InterruptedException {

        logShortMessage("Initial => " + studentInheritableThreadLocal.get());
        // Main thread sets the user
        studentInheritableThreadLocal.set(Student.builder().name("Harry Potter").build());//First getting the parent object then mutating it.
        logShortMessage("Final => " + studentInheritableThreadLocal.get());


        // Start a Child Thread
        Thread thread = Thread.ofVirtual().start(() -> {
            Thread.currentThread().setName("ron");
            logShortMessage("Initial => " + studentInheritableThreadLocal.get());
            //This DOES NOT CHANGE THE PARENT VALUE
            //studentInheritableThreadLocal.set(new Student("Ron Weasley"));//Creating a new instance of Student and assigning to the child thread.
            studentInheritableThreadLocal.get().setName("Ron Weasley");//First getting the parent object then mutating it.
            logShortMessage("Final => " + studentInheritableThreadLocal.get());
        });

        thread.join();
        logShortMessage(STR."Finally => \{studentInheritableThreadLocal.get()}");//Since child thread set a new name, parent should reflect the same
    }
}
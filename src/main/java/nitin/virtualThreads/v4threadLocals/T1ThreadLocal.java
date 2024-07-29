package nitin.virtualThreads.v4threadLocals;

import nitin.virtualThreads.Student;
import static com.utilities.MultiThreadUtility.logShortMessage;

public class T1ThreadLocal {
    // Main and Child Thread can set different User object in Threadlocal
    public static final ThreadLocal<Student> studentThreadLocal = new ThreadLocal<Student>();
    
    public static void main(String[] args) throws InterruptedException {
        //setStudentInAThread(student,"Harry Potter");
        logShortMessage("Initial => " + studentThreadLocal.get());
        // Main thread sets the user
        studentThreadLocal.set(Student.builder().name("Harry Potter").build());//Creating a new instance
        logShortMessage("Final => " + studentThreadLocal.get());

        // Start a Child Thread
        Thread thread = Thread.ofVirtual().start(() -> {
            Thread.currentThread().setName("ron");
            //setStudentInAThread(student,"Ron Weasley");
            logShortMessage("Initial => " + studentThreadLocal.get());
            //studentThreadLocal.set(Student.builder().name("Ron Weasley").build());//Creating a new instance
            studentThreadLocal.get().setName("Ron Weasley");
            logShortMessage("Final => " + studentThreadLocal.get());
        });
        
        thread.join();
        logShortMessage(STR."Finally => \{studentThreadLocal.get()}");
    }
}

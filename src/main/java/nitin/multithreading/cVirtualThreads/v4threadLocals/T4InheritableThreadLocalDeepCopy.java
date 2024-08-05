package nitin.multithreading.cVirtualThreads.v4threadLocals;

import nitin.multithreading.cVirtualThreads.Student;
import static com.utilities.MultiThreadUtility.logShortMessage;

public class T4InheritableThreadLocalDeepCopy {
    // deep copy ONLY WHEN childValue() method is used
    public static final InheritableThreadLocal<Student> studentDeepCopy = new InheritableThreadLocal<Student>() {
        @Override
        protected Student childValue(Student parentValue) {
            // Create a deep copy of the parent value for the child thread
            return new Student(parentValue.getName());
        }

        @Override
        protected Student initialValue() {
            return new Student("Albus Dumbledore");
        }
    };
    
    public static void main(String[] args) throws InterruptedException {

        logShortMessage("Initial => " + studentDeepCopy.get());
        // Main thread sets the user
        studentDeepCopy.set(Student.builder().name("Harry Potter").build());//Creating a new instance
        logShortMessage("Final => " + studentDeepCopy.get());

        // Start a Child Thread
        Thread thread = Thread.ofVirtual().start(() -> {
            Thread.currentThread().setName("ron");
            logShortMessage("Initial => " + studentDeepCopy.get());
            // Main thread sets the user
            studentDeepCopy.set(Student.builder().name("Ron Weasley").build());//Creating a new instance
            logShortMessage("Final => " + studentDeepCopy.get());
        });

        thread.join();
        logShortMessage(STR."Finally => \{studentDeepCopy.get()}");
    }
}
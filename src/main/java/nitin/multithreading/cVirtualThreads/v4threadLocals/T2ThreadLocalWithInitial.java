package nitin.multithreading.cVirtualThreads.v4threadLocals;

import static com.utilities.MultiThreadUtility.logShortMessage;

import nitin.multithreading.cVirtualThreads.Student;

public class T2ThreadLocalWithInitial {
    // With Default Initial Value using a Supplier
    // The Supplier is called when calling get()
    // After remove(), if get() is called again, the supplier will be invoked Again
    public static final ThreadLocal<Student> studentThreadLocal =
            ThreadLocal.withInitial(() -> new Student("Albus Dumbledore"));

    public static void main(String[] args) throws InterruptedException {
        logShortMessage("Initial => " + studentThreadLocal.get());
        // Main thread sets the user
        studentThreadLocal.set(
                Student.builder().name("Harry Potter").build()); // Creating a new instance
        logShortMessage("Final => " + studentThreadLocal.get());

        // Start a Child Thread
        Thread thread =
                Thread.ofPlatform()
                        .start(
                                () -> {
                                    Thread.currentThread().setName("ron");
                                    logShortMessage("Initial => " + studentThreadLocal.get());
                                    // Main thread sets the user
                                    studentThreadLocal.set(
                                            Student.builder()
                                                    .name("Ron Weasley")
                                                    .build()); // Creating a new instance
                                    logShortMessage("Final => " + studentThreadLocal.get());
                                });

        thread.join();
        logShortMessage(STR."Finally => \{studentThreadLocal.get()}");
        studentThreadLocal.remove();
        logShortMessage(STR."After Removal => \{studentThreadLocal.get()}");
    }
}

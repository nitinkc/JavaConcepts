package nitin.multithreading.cVirtualThreads.v5scopedvalue;

import nitin.multithreading.cVirtualThreads.Student;

import static com.utilities.MultiThreadUtility.logShortMessage;

public class S3ScopedValueInheritance {
    public static ScopedValue<Student> studentScopedValue = ScopedValue.newInstance();
    
    public static void main(String[] args) throws Exception {
        ScopedValue
            .where(studentScopedValue, new Student("Harry Potter"))
            .run(S3ScopedValueInheritance::invokeThread);
    }
    
    private static void invokeThread() {
        try {
            logShortMessage("isBound? " + studentScopedValue.isBound());
            Student reqStudent = studentScopedValue.get();
            logShortMessage("invokeThread - user " + reqStudent);

            //Starting a new named child Thread
            Thread thread = Thread.ofVirtual().name("hp-thread").start(()->getHarryPotter());
            //Connecting with the main thread
            thread.join();
            logShortMessage("invokeThread - user " + reqStudent);

        } catch (InterruptedException exp) { /* do something */ }
    }

    private static void getHarryPotter() {
        logShortMessage("isBound? " + studentScopedValue.isBound());
        Student requestStudent = studentScopedValue.orElse(new Student("Ron Weasley"));
        logShortMessage("invokeThread - user " + requestStudent);
    }
}

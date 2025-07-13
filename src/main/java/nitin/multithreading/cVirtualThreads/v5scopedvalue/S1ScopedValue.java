package nitin.multithreading.cVirtualThreads.v5scopedvalue;

import static com.utilities.MultiThreadUtility.logShortMessage;

import nitin.multithreading.cVirtualThreads.Student;

public class S1ScopedValue {
    // Not yet bound
    public static final ScopedValue<Student> studentScopedValue = ScopedValue.newInstance();

    public static void main(String[] args) throws Exception {
        logShortMessage("isBound? " + studentScopedValue.isBound());

        Student hp = new Student("Harry Potter");
        boolean result // bind a key (studentScopedValue) to a value (hp) with an operation op
                // (handleUser())
                =
                ScopedValue.callWhere(
                        studentScopedValue, hp, S1ScopedValue::handleUser); // using a callable

        // boolean result = handleUser();
        logShortMessage("Result: " + result);
        logShortMessage("isBound? " + studentScopedValue.isBound());

        // logShortMessage("Finally: " + studentScopedValue.get());
        // Exception in thread "main" java.util.NoSuchElementException
        //	at java.base/java.lang.ScopedValue.slowGet(ScopedValue.java:700)
    }

    private static boolean handleUser() {
        ScopedUserHandler handler = new ScopedUserHandler();
        return handler.handle();
    }
}

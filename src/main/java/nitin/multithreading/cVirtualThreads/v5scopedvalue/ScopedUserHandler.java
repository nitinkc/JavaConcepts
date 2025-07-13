package nitin.multithreading.cVirtualThreads.v5scopedvalue;

import static com.utilities.MultiThreadUtility.logShortMessage;

import nitin.multithreading.cVirtualThreads.Student;

public class ScopedUserHandler {

    public boolean handle() {
        boolean bound = S1ScopedValue.studentScopedValue.isBound();
        logShortMessage("handle - isBound? " + bound);

        if (bound) {
            Student requestStudent = S1ScopedValue.studentScopedValue.get();
            logShortMessage("handle - User: " + requestStudent);
        }

        return bound;
    }
}

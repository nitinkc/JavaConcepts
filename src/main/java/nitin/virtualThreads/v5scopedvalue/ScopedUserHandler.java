package nitin.virtualThreads.v5scopedvalue;


import nitin.virtualThreads.Student;

import static com.utilities.MultiThreadUtility.logShortMessage;

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

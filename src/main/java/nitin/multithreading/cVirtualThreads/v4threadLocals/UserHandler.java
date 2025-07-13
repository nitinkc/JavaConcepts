package nitin.multithreading.cVirtualThreads.v4threadLocals;

import nitin.multithreading.cVirtualThreads.Student;

public class UserHandler {

    public void handle() {
        Student requestStudent = T0ThreadLocal.studentThreadLocal.get();
        print("handle - User => " + requestStudent);

        // handle user 'requestUser'
    }

    public static void print(String m) {
        T0ThreadLocal.print(m);
    }
}

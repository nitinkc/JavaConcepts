package nitin.virtualThreads.v4threadLocals;

import nitin.virtualThreads.Student;

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
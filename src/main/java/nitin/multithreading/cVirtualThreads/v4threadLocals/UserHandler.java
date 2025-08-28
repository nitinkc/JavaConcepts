package nitin.multithreading.cVirtualThreads.v4threadLocals;

import nitin.multithreading.cVirtualThreads.Student;

public class UserHandler {

  public static void print(String m) {
    T0ThreadLocal.print(m);
  }

  public void handle() {
    Student requestStudent = T0ThreadLocal.studentThreadLocal.get();
    print("handle - User => " + requestStudent);

    // handle user 'requestUser'
  }
}

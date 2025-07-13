package nitin.multithreading.cVirtualThreads.v4threadLocals;

import nitin.multithreading.cVirtualThreads.Student;

/**
 * Simple example with a Single Thread. Demonstrates use of Thread Local as an implicit parameter in
 * whole method stack
 */
public class T0ThreadLocal {

    public static ThreadLocal<Student> studentThreadLocal = new ThreadLocal<Student>();

    public static void main(String[] args) {
        mainThread();
        handleUser();
        System.out.println(
                STR."\{studentThreadLocal.get()}Nitin\{studentThreadLocal.get().getName()}");
    }

    private static void mainThread() {
        print("User => " + studentThreadLocal.get());
        // Main thread sets the user
        studentThreadLocal.set(new Student("anonymous"));
        print("User => " + studentThreadLocal.get());
    }

    private static void handleUser() {
        UserHandler handler = new UserHandler();
        handler.handle();
    }

    public static void print(String m) {
        System.out.printf("[%s] %s\n", Thread.currentThread().getName(), m);
    }
}

package nitin.virtualThreads.threadLocalsNScopedValue;

import nitin.virtualThreads.threadLocalsNScopedValue.scopedvalue.user.User;
import nitin.virtualThreads.threadLocalsNScopedValue.scopedvalue.user.UserHandler;

/**
 * Simple example with a Single Thread. Demonstrates use of Thread Local
 * as an implicit parameter in whole method stack
 */
public class ThreadLocalSimplePlay {

    public static ThreadLocal<User> user = new ThreadLocal<User>();

    public static void main(String[] args) {
        mainThread();
        handleUser();
    }

    private static void mainThread() {
        print("User => " + user.get());
        // Main thread sets the user
        user.set(new User("anonymous"));
        print("User => " + user.get());
    }

    private static void handleUser() {
        UserHandler handler = new UserHandler();
        handler.handle();
    }

    public static void print(String m) {
        System.out.printf("[%s] %s\n", Thread.currentThread().getName(), m);
    }

}


package nitin.virtualThreads.threadLocalsNScopedValue;


import nitin.virtualThreads.threadLocalsNScopedValue.scopedvalue.user.User;

/*
 * Main and Child Thread can set different User object in Threadlocal.
 * Demonstrates how Thread Locals work when multiple threads are in 
 * play.
 */
public class ThreadLocalPlay {
    
    public static final ThreadLocal<User> user = new ThreadLocal<User>();
    
    public static void main(String[] args) throws InterruptedException {
        print("User => " + user.get());
        // Main thread sets the user 
        user.set(new User("main"));
        print("Modified User => " + user.get());

        // Start a Child Thread for "bob"
        Thread thread = Thread.ofVirtual().start(() -> {
            Thread.currentThread().setName("bob-thread");
            
            print("User => " + user.get());
            user.set(new User("bob"));
            print("Modified User => " + user.get());
        });
        
        thread.join();
        print("User => " + user.get());
    }
    
    private static void print(String m) {
        System.out.printf("[%s] %s\n", Thread.currentThread().getName(), m);
    }

}

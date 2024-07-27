package nitin.virtualThreads.threadLocalsNScopedValue;


import nitin.virtualThreads.threadLocalsNScopedValue.scopedvalue.user.User;

/*
 * - Child thread will see the thread local values of the Parent. 
 * - Thread local map is automatically copied when the child thread is created
 * - No deep copy unless childValue() method is used.
 */
public class InheritableThreadLocalPlay {
    
    public static final InheritableThreadLocal<User> user = new InheritableThreadLocal<>();
//    {
//        
//        @Override
//        protected User initialValue() { 
//           return new User("anonymous"); 
//        }
//
//        @Override
//        protected User childValue(User parentValue) { 
//           return new User(parentValue.getId()); 
//        }
//    };
    
    public static void main(String[] args) throws InterruptedException {
                
        print("User => " + user.get());

        // Main thread sets the user 
        user.set(new User("main"));
        print("Modified User => " + user.get());

        // Start a Child Thread for "bob"
        Thread thread = Thread.ofVirtual().start(() -> {
            
            Thread.currentThread().setName("bob-thread");
            
            print("User => " + user.get()); 
            
            user.get().setId("bobby");
            print("Modified User => " + user.get());
            
        });
        
        thread.join();
        print("User => " + user.get());
       
    }
    
    private static void print(String m) {
        System.out.printf("[%s] %s\n", Thread.currentThread().getName(), m);
    }
}
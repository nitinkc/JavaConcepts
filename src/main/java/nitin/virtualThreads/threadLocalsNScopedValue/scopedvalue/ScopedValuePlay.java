package nitin.virtualThreads.threadLocalsNScopedValue.scopedvalue;
import nitin.virtualThreads.threadLocalsNScopedValue.scopedvalue.user.ScopedUserHandler;
import nitin.virtualThreads.threadLocalsNScopedValue.scopedvalue.user.User;


/*
 * Advantages
 *   - Scoped Value only available for use within the dynamic scope of the method 
 *      - during the bounded period of execution of a method
 *      - bound during start of scope and unbounded during end of scope (even exception)
 *   - Rebinding allowed but cannot modify Scoped Value
 *   - No cleanup required. automatically handled
 */
public class ScopedValuePlay {
    
    public static final ScopedValue<User> user = ScopedValue.newInstance();
    
    public static void main(String[] args) throws Exception {

        print("user is Bound => " + user.isBound());

        User bob = new User("bob");
        boolean result 
            = ScopedValue.callWhere(user, bob, ScopedValuePlay::handleUser);
                        
        // boolean result = handleUser();
        print("Result => " + result);
        print("user is Bound => " + user.isBound());
    }
    
    private static boolean handleUser() {
        ScopedUserHandler handler = new ScopedUserHandler();
        return handler.handle();
    }

    public static void print(String m) {
        System.out.printf("[%s] %s\n", Thread.currentThread().getName(), m);
    }
}
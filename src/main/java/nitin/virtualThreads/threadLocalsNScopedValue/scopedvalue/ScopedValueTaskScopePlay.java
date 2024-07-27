package nitin.virtualThreads.threadLocalsNScopedValue.scopedvalue;

import nitin.virtualThreads.threadLocalsNScopedValue.scopedvalue.user.User;

import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.ThreadFactory;


/*
 * Scoped Values can be accessed from Child threads started
 * from StructuredTaskScope fork() method. This is because 
 * threads started from StructuredTaskScope block are guaranteed
 * to complete before the try-with-resources block ends and THUS
 * remains within the scope of the ScopedValue.
 */
public class ScopedValueTaskScopePlay {
    
    public static final ScopedValue<User> user = ScopedValue.newInstance();
    
    public static void main(String[] args) throws Exception {
        ScopedValue
            .where(user, new User("sally"))
            .call(ScopedValueTaskScopePlay::invokeTaskScope);
    }
    
    private static String invokeTaskScope() throws Exception {
        
        ThreadFactory factory = Thread.ofVirtual().name("test-",0).factory();
        try (var scope = new StructuredTaskScope<String>("test-scope", factory)) {

            scope.fork(() -> {
                                
                User reqUser = user.orElse(new User("anonymous"));
                print("invokeTaskScope - user " + reqUser);
                
                // set the Id for the user
                reqUser.setId("bob");
                
                return "done";
            });
            
            scope.join();
        }
 
        User reqUser = user.orElse(new User("anonymous"));
        print("invokeTaskScope - user " + reqUser);
        return "done";
    }

    public static void print(String m) {
        System.out.printf("[%s] %s\n", Thread.currentThread().getName(), m);
    }

}

package nitin.virtualThreads.threadLocalsNScopedValue.scopedvalue;

import nitin.virtualThreads.threadLocalsNScopedValue.scopedvalue.user.User;

/*
 * How does Scoped Values work with threads ? Scoped values are not available 
 * for Child threads except the ones initiated with StructuredTaskScope
 */
public class ScopedValueThreadPlay {
    
    public static final ScopedValue<User> user = ScopedValue.newInstance();
    
    public static void main(String[] args) throws Exception {
        ScopedValue
            .where(user, new User("sally"))
            .run(ScopedValueThreadPlay::invokeThread);
    }
    
    private static void invokeThread() {
 
        try {
            
            print("user is Bound => " + user.isBound());
            
            User reqUser = user.get();
            String thrName = reqUser.getId() + "-thread";
            Thread thr = Thread.ofVirtual().name(thrName).start(() -> {
                print("user is Bound => " + user.isBound());
                User requestUser = user.orElse(new User("anonymous"));
                print("invokeThread - user " + requestUser);
            });
            
            thr.join();
        } catch (InterruptedException exp) { /* do something */ }
    }
    
    public static void print(String m) {
        System.out.printf("[%s] %s\n", Thread.currentThread().getName(), m);
    }
}

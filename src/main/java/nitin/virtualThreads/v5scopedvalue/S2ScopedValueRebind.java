package nitin.virtualThreads.v5scopedvalue;

import nitin.virtualThreads.Student;

import static com.utilities.MultiThreadUtility.logShortMessage;

public class S2ScopedValueRebind {
    
    public static ScopedValue<Student> studentScopedValue = ScopedValue.newInstance();
    
    public static void main(String[] args) throws Exception {
        logShortMessage("isBound? " + studentScopedValue.isBound());//False - outside the dynamic scope of the method
        Student hp = new Student("Harry Potter");
        ScopedValue.runWhere(studentScopedValue, hp, S2ScopedValueRebind::runnableVoidMethod);

        logShortMessage("isBound? " + studentScopedValue.isBound());//False - outside the dynamic scope of the method
    }
    
    private static void runnableVoidMethod() {
        logShortMessage("handleUser - isBound? " + studentScopedValue.isBound());
        logShortMessage("handleUser - " + studentScopedValue.get());
        ScopedValue.runWhere(studentScopedValue, new Student("Default Student"),//Rebinding
                S2ScopedValueRebind::anonylousCall);
        logShortMessage("handleUser - " + studentScopedValue.get());
    }
    
    private static void anonylousCall() {
        logShortMessage("callAsAnonymous - isBound? " + studentScopedValue.isBound());
        logShortMessage("callAsAnonymous - " + studentScopedValue.get());
   }
}

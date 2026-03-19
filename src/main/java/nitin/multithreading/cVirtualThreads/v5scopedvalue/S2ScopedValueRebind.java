package nitin.multithreading.cVirtualThreads.v5scopedvalue;

import static com.utilities.MultiThreadUtility.logShortMessage;

import nitin.multithreading.cVirtualThreads.Student;

public class S2ScopedValueRebind {

    public static ScopedValue<Student> studentScopedValue = ScopedValue.newInstance();

    public static void main(String[] args) throws Exception {
        logShortMessage(
                "isBound? "
                        + studentScopedValue
                                .isBound()); // False - outside the dynamic scope of the method
        Student hp = new Student("Harry Potter");
        ScopedValue.where(studentScopedValue, hp).run(S2ScopedValueRebind::runnableVoidMethod);

        logShortMessage(
                "isBound? "
                        + studentScopedValue
                                .isBound()); // False - outside the dynamic scope of the method
    }

    private static void runnableVoidMethod() {
        logShortMessage("handleUser - isBound? " + studentScopedValue.isBound());
        logShortMessage("handleUser - " + studentScopedValue.get());
        ScopedValue.where(studentScopedValue, new Student("Default Student"))
                .run(S2ScopedValueRebind::anonylousCall); // Rebinding
        logShortMessage("handleUser - " + studentScopedValue.get());
    }

    private static void anonylousCall() {
        logShortMessage("callAsAnonymous - isBound? " + studentScopedValue.isBound());
        logShortMessage("callAsAnonymous - " + studentScopedValue.get());
    }
}

package nitin.virtualThreads.v5scopedvalue;

import nitin.virtualThreads.Student;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.ThreadFactory;

import static com.utilities.MultiThreadUtility.logShortMessage;

public class S4ScopedValueStructuredTaskScope {
    public static final ScopedValue<Student> studentScopedValue = ScopedValue.newInstance();

    public static void main(String[] args) throws Exception {
        ScopedValue
                .where(studentScopedValue, new Student("Harry Potter"))
                .call(S4ScopedValueStructuredTaskScope::invokeTaskScope);
    }

    private static String invokeTaskScope() throws InterruptedException {

        ThreadFactory factory = Thread.ofVirtual().name("child-",0).factory();
        try (var scope = new StructuredTaskScope<String>("child-scope", factory)) {//

            scope.fork(() -> {
                Student reqUser = studentScopedValue.orElse(new Student("Ron Weasley"));
                logShortMessage("invokeTaskScope - user " + reqUser);

                // set the Id for the user
                reqUser.setName("Jennie");//Changing the Parent thread value
                return "done";
            });
            scope.join();
        }//All child threads finish in the structured task scope. Child thread can't run beyond Parent thread

        Student reqUser = studentScopedValue.orElse(new Student("Ron Weasley"));//Set new if there is nothing returned
        logShortMessage("invokeTaskScope - user " + reqUser);
        return "done";
    }
}
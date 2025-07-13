package nitin.multithreading.cVirtualThreads.v6DelimitedContinuations;

import static com.utilities.MultiThreadUtility.logShortMessage;

import java.time.Duration;
import jdk.internal.vm.Continuation;
import jdk.internal.vm.ContinuationScope;

public class C2CascadingContinuationsCallingObjects {
    private static final ContinuationScope SCOPE = new ContinuationScope("scope");

    public static void main(String[] args) throws Exception {
        logShortMessage("Main method : START");
        Continuation c =
                new Continuation(SCOPE, new RunnableContinuationProcessor()); // Calling an object
        while (!c.isDone()) {
            c.run();
            logShortMessage(">> main : scope1 loop");
            Thread.sleep(Duration.ofSeconds(3));
        }
        logShortMessage("main : exit");
    }
}

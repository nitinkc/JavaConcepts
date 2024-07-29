package nitin.virtualThreads.v6DelimitedContinuations;
import jdk.internal.vm.Continuation;
import jdk.internal.vm.ContinuationScope;

import java.time.Duration;
import java.time.ZonedDateTime;

import static com.utilities.MultiThreadUtility.logShortMessage;
import static com.utilities.ZonedDateTimeUtility.zonedDateTimeStr;

public class C1ContinuationsAsCoroutines {
    private static final ContinuationScope SCOPE = new ContinuationScope("scope");

    // --add-exports java.base/jdk.internal.vm=ALL-UNNAMED in the grdle build package
    //Package 'jdk.internal.vm' is declared in module 'java.base', which does not export it to the unnamed module
    public static void main(String[] args) throws Exception {
        logShortMessage("Main method : START");

        Continuation continuation = new Continuation(SCOPE, C1ContinuationsAsCoroutines::continuationMethod);
        while (!continuation.isDone()) {//Run as long as Continuations are running.
            continuation.run();//Run with each Continuation.yield method
            logShortMessage("##### Continuation loop #####");
            Thread.sleep(Duration.ofSeconds(3));
        }
        logShortMessage("Main method : END");
    }


    private static void continuationMethod() {
        logShortMessage("continuationMethod : enter");
        Incrementer incrementer = new Incrementer(1, zonedDateTimeStr(ZonedDateTime.now()));

        logShortMessage("State 1 : " + incrementer);
        //Restores the state
        Continuation.yield(SCOPE);//Run until here and send the control back to the main method

        //Restore from previous point, Resumes the state
        modifyIncrementer(incrementer);
        logShortMessage("State 2 : " + incrementer);
        Continuation.yield(SCOPE);

        //Restore from previous point, Resumes the state
        modifyIncrementer(incrementer);
        logShortMessage("State 3 : " + incrementer);
        Continuation.yield(SCOPE);

        logShortMessage("continuationMethod : exit");
    }

    private static void modifyIncrementer(Incrementer incrementer) {
        incrementer.setCounter(incrementer.getCounter() + 1);
        incrementer.setTimeOfIncrement(zonedDateTimeStr(ZonedDateTime.now()));
    }
}
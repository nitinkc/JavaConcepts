package nitin.LambdaExpressions.t1Lambdas.lambdas2.timing;

public class TimingUtils {
    private static final double ONE_BILLION = 1_000_000_000;

    public static void timeOp(Op operation) {
        long startTime = System.nanoTime();
        operation.runOp();
        long endTime = System.nanoTime();
        double elapsedSeconds = (endTime - startTime) / ONE_BILLION;
        System.out.printf("  Elapsed time: %.3f seconds.%n", elapsedSeconds);
    }
}

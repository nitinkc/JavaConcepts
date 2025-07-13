package nitin.streams.timing;

@FunctionalInterface
public interface Op {
    static void timeOp(Op operation) {
        long startTime = System.nanoTime();
        operation.runOp();
        long endTime = System.nanoTime();
        double oneBillion = 1_000_000_000;
        double elapsedSeconds = (endTime - startTime) / oneBillion;
        System.out.printf("  Elapsed time: %.3f seconds.%n", elapsedSeconds);
    }

    void runOp();

    default Op combinedOp(Op secondOp) {
        return (() -> {
            runOp();
            secondOp.runOp();
        });
    }
}

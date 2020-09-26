package com.nitin.zCoreServletsTraining.t0Interfaces.java8Interfaces.timing;

/** Represents an operation that we will want to time. 
 *  Added a static and default method to the interface
 *  that we had used earlier.
 */

@FunctionalInterface
public interface Op {
  static final double ONE_BILLION = 1_000_000_000;

  //SAM
  void runOp();

  //Static method is allowed
  static void timeOp(Op operation) {
    long startTime = System.nanoTime();
    operation.runOp();
    long endTime = System.nanoTime();
    double elapsedSeconds = (endTime - startTime)/ONE_BILLION;
    System.out.printf("  Elapsed time: %.3f seconds.%n", elapsedSeconds);
  }

  //Default method is allowed
  default Op combinedOp(Op secondOp) {
    return(() -> { runOp();
                   secondOp.runOp(); });
  }
}

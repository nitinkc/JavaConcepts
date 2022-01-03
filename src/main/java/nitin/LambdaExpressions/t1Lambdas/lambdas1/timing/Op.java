package nitin.LambdaExpressions.t1Lambdas.lambdas1.timing;

// We will see later that we should use @FunctionalInterface here.
// But still tremendously useful, even without that annotation.

/** Represents an operation that we will want to time. */

public interface Op {
  void runOp();
}

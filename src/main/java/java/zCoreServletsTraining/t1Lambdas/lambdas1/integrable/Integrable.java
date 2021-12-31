package java.zCoreServletsTraining.t1Lambdas.lambdas1.integrable;

// We will later see that we should use @FunctionalInterface
// We will also later see that we can dispense with this interface
// definition totally and use java.util.DoubleUnaryOperato instead.
// But, even without knowing about either of these things, lambdas
// let you make a much more reusable numerical integration routine
// than you could have had in Java 7.

/** Represents a function to be integrated. */

public interface Integrable {
  double eval(double x);
} 

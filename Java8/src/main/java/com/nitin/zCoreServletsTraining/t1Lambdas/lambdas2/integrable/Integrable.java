package com.nitin.zCoreServletsTraining.t1Lambdas.lambdas2.integrable;

// Added the optional-but-highly-recommended @FunctionalInterface
// annotation.
//
// We will see later that we can dispense with this interface
// definition totally and use java.util.DoubleUnaryOperato instead.

/** Represents a function to be integrated. */

@FunctionalInterface
public interface Integrable {
  double eval(double x);
} 

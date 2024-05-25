package com.utilities;

import java.math.BigInteger;

/**
 * A few utilities to generate a large random BigInteger,
 * and find the next prime number above a given BigInteger.
 */

public class Primes {
    private static final BigInteger ZERO = BigInteger.ZERO;
    private static final BigInteger ONE = BigInteger.ONE;
    private static final BigInteger TWO = new BigInteger("2");

    // Likelihood of false prime is less than 1/2^ERR_VAL.
    // Presumably BigInteger uses the Miller-Rabin test or
    // equivalent, and thus is NOT fooled by Carmichael numbers.
    // See Cormen et al.'s Introduction to Algorithms for details.
    private static final int ERR_VAL = 100;
    private static final String[] DIGITS =
            "0,1,2,3,4,5,6,7,8,9".split(",");
    private static final String[] NON_ZERO_DIGITS =
            "0,1,2,3,4,5,6,7,8,9".split(",");

    private Primes() {
    } // Uninstantiatable class

    /**
     * Finds the next prime number above a threshold.
     */
    public static BigInteger nextPrime(BigInteger start) {
        if (isEven(start)) {
            start = start.add(ONE);
        } else {
            start = start.add(TWO);
        }
        if (start.isProbablePrime(ERR_VAL)) {
            return (start);
        }
        return (nextPrime(start));
    }

    /**
     * Generates a random number of the given length,
     * then finds the first prime number above that random number.
     */
    public static BigInteger findPrime(int numDigits) {
        if (numDigits < 1) {
            numDigits = 1;
        }
        return (nextPrime(randomNum(numDigits)));
    }

    private static boolean isEven(BigInteger n) {
        return (n.mod(TWO).equals(ZERO));
    }

    private static String randomDigit(boolean isZeroOk) {
        if (isZeroOk) {
            return (RandomUtils.randomElement(DIGITS));
        }
        return (RandomUtils.randomElement(NON_ZERO_DIGITS));
    }

    /**
     * Creates a random big integer where every digit is
     * selected randomly (except that the first digit
     * cannot be a zero).
     */

    public static BigInteger randomNum(int numDigits) {
        StringBuilder s = new StringBuilder();
        // First digit must be non-zero.
        s.append(randomDigit(false));
        for (int i = 0; i < numDigits - 1; i++) {
            s.append(randomDigit(true));
        }
        return (new BigInteger(s.toString()));
    }

    /**
     * Simple command-line program to test. Enter number
     * of digits, and the program picks a random number of that
     * length and then prints the first 50 prime numbers
     * above that.
     */

    public static void main(String[] args) {
        int numDigits;
        try {
            numDigits = Integer.parseInt(args[0]);
        } catch (Exception e) { // No args or illegal arg.
            numDigits = 2;
        }
        BigInteger currentPrime = randomNum(numDigits);
        for (int i = 0; i < 50; i++) {
            System.out.println(currentPrime);
            currentPrime = nextPrime(currentPrime);
        }
    }
}

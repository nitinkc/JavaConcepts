package com.nitin.zCoreServletsTraining.t2Streams.streams1;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.*;

public class PrimeStream {
  /** Makes an "infinite" (unbounded) stream of consecutive prime numbers. 
   *  This method is for when you want to control the size-limiting steps later.
   *  The more common usage is the next method, where you limit the
   *  size in the call to the original method.
   */
  public static Stream<BigInteger> makePrimeStream(int numDigits) {
    return(Stream.iterate(Primes.findPrime(numDigits), Primes::nextPrime));
  }
  
  /** Makes a Stream of the specified number of consecutive n-digit primes. */
  
  public static Stream<BigInteger> makePrimeStream(int numDigits, int numPrimes) {
    return(makePrimeStream(numDigits).limit(numPrimes));
  }
  
  /** Makes a List of the specified number of consecutive n-digit primes. */
  
  public static List<BigInteger> makePrimeList(int numDigits, int numPrimes) {
    return(makePrimeStream(numDigits, numPrimes).collect(Collectors.toList()));
  }
  
  /** Makes an array of the specified number of consecutive n-digit primes. */
  // toArray returns Object[], not T[], so the typecast is needed
  
  //public static BigInteger[] makePrimeArray(int numDigits, int numPrimes) {
 //   return((BigInteger[])makePrimeStream(numDigits, numPrimes).toArray());
  //} 
  
  public static BigInteger[] makePrimeArray(int numDigits, int numPrimes) {
    return(makePrimeStream(numDigits, numPrimes).toArray(BigInteger[]::new));
  } 
  
  private PrimeStream() {} // Uninstantiatable class
}

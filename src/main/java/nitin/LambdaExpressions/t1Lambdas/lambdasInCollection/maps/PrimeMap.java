package nitin.LambdaExpressions.t1Lambdas.lambdasInCollection.maps;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimeMap {
  private static Map<Integer,BigInteger> primes = new HashMap<>();
  
  public static void main(String[] args) {
    List<Integer> lengths = Arrays.asList(2, 10, 20, 100, 200);
    System.out.println("First pass");
    lengths.forEach(size -> System.out.printf("  %3s-digit prime: %s.%n", size, findPrime(size)));
    System.out.println("Second pass");
    lengths.forEach(size -> System.out.printf("  %3s-digit prime: %s.%n", size, findPrime(size)));
  }
  
  public static BigInteger findPrime1(int numDigits) {
    return(Primes.findPrime(numDigits));
  }
  
  public static BigInteger findPrime(int numDigits) {
    return(primes.computeIfAbsent(numDigits, n -> Primes.findPrime(n)));
  }
}

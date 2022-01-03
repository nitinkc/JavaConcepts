package nitin.LambdaExpressions.t1Lambdas.lambdasInCollectionEx;

import nitin.LambdaExpressions.t1Lambdas.lambdasInCollectionEx.timing.Op;

import java.util.List;

public class UtilsExamples {
  private static int cutoff = 1_000;
  
  public static void main(String[] args) {
    showAverages1(1_000_000, 0.5);
    showAverages1(10_000_000, 0.5);
    showAverages2(1_000_000);
    showAverages2(10_000_000);
    verifySmallCounts();
    profilePrimeCounts();
  }
  
  private static void showAverages1(int size, double cutoff) {
    List<Double> nums = Utils.randomNumberList(size);
    System.out.printf("Made %,d-element list of random numbers from 0 to 1.%n", size);
    System.out.printf("  Average value: %.5f.%n", Utils.average(nums));
    Utils.removeBelow(nums, cutoff);
    System.out.printf("Removed values below: %.3f.%n", cutoff);
    System.out.printf("  Average value: %.5f.%n", Utils.average(nums));
  }
  
  private static void showAverages2(int size) {
    List<Double> nums = Utils.randomNumberList(size);
    System.out.printf("Made %,d-element list of random numbers from 0 to 1.%n", size);
    System.out.printf("  Average value: %.5f.%n", Utils.average(nums));
    Utils.doubleAllValues(nums);
    System.out.printf("Doubled all values.%n");
    System.out.printf("  Average value: %.5f.%n", Utils.average(nums));
  }
  
  private static void profilePrimeCounts() {
    for(int i=0; i<9; i++) {
      Op.timeOp(() -> System.out.printf("Number of primes up to %,d is %,d [version 1].%n", cutoff, Utils.countPrimes1(cutoff)));
      Op.timeOp(() -> System.out.printf("Number of primes up to %,d is %,d. [version 2]%n", cutoff, Utils.countPrimes(cutoff)));
      cutoff = cutoff + 1_000;
    }
  }
  
  private static void verifySmallCounts() {
    int[] tests = { 10, 100, 200 };
    for(int test: tests) {
      System.out.printf("Number of primes <= %s is %s.%n", test, Utils.countPrimes1(test));
    }
    listPrimes(200);
  }
  
  private static void listPrimes(int cutoff) {
    for(int i=0; i<=cutoff; i++) {
      if (Primes.isPrime(i)) {
        System.out.println(i);
      }
    }
  }
}

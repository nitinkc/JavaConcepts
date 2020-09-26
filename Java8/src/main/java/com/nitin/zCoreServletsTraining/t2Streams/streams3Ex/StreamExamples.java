package com.nitin.zCoreServletsTraining.t2Streams.streams3Ex;

import java.util.*;
import java.util.stream.*;
import com.nitin.zCoreServletsTraining.t2Streams.streams3Ex.timing.*;

/** Solutions to third set of Stream exercises from Java 8 tutorial at coreservlets.com.
 */

public class StreamExamples {
  public static void main(String[] args) {
    timeSums();
    otherExamples();
  }
  
  private static void timeSums() {
    double[] nums1 = { 1, 4, 9 };
    System.out.println("For array {1,4,9}");
    timeSumSequential(DoubleStream.of(nums1));
    timeSumParallel(DoubleStream.of(nums1));
    int arraySize = 1_000_000;
    double[] nums2 = MathUtils.randomArray(arraySize);
    System.out.printf("For random array with %,d nums:%n", arraySize);
    timeSumSequential(DoubleStream.of(nums2));
    timeSumParallel(DoubleStream.of(nums2));
    arraySize = 100_000_000;
    nums2 = MathUtils.randomArray(arraySize);
    System.out.printf("For random array with %,d nums:%n", arraySize);
    timeSumSequential(DoubleStream.of(nums2));
    timeSumParallel(DoubleStream.of(nums2));
  }
  
  private static void timeSumSequential(DoubleStream numStream) {
    System.out.println(" Summing sequentially:");
    Op.timeOp(() -> {
      double sum = MathUtils.sqrtSum(numStream);
      System.out.printf("  Sum is %,.8f.%n", sum);
    });
  }
  
  private static void timeSumParallel(DoubleStream numStream) {
    System.out.println(" Summing in parallel:");
    Op.timeOp(() -> {
      double sum = MathUtils.sqrtSumParallel(numStream);
      System.out.printf("  Sum is %,.8f.%n", sum);
    });
  }
  
  private static void otherExamples() {
    System.out.println("Random nums:");
    MathUtils.randomNums(10).limit(5).forEach(System.out::println);
    List<Double> randomNums1 = 
      MathUtils.randomNums(10).limit(10).collect(Collectors.toList());
    System.out.println("List of random nums: " + randomNums1);
    Double[] randomNums2 =
      MathUtils.randomNums(10).limit(20).toArray(Double[]::new);
    System.out.println("Array of random nums: " + Arrays.asList(randomNums2));
  }
}

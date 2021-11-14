package com.nitin.zCoreServletsTraining.t2Streams.streams3Ex.timing;

import java.util.Arrays;

public class TimingTests {
  public static void main(String[] args) {
    for(int i=3; i<8; i++) {
      int size = (int)Math.pow(10, i);
      System.out.printf("Sorting array of length %,d.%n", size);
      Op.timeOp(() -> sortArray(size));
    }
  }
  
  /** Make an n-length array of random numbers. */
  
  public static double[] randomNums(int length) {
    double[] nums = new double[length];
    for(int i=0; i<length; i++) {
      nums[i] = Math.random();
    }
    return(nums);
  }
  
  public static void sortArray(int length) {
    double[] nums = randomNums(length);
    Arrays.sort(nums);
  }
}

package com.nitin.zCoreServletsTraining.t2Streams.streams3.parallel;

import java.util.stream.*;

public class MathUtils {
  public static double fancySum1(double[] nums) {
    return DoubleStream.of(nums)
                       .map(d -> Math.sqrt(2*d))
                       .sum();
  }
  
  public static double fancySum2(double[] nums) {
    return DoubleStream.of(nums)
                       .parallel()
                       .map(d -> Math.sqrt(2*d))
                       .sum();
  }

  
  /** Make an n-length array of random numbers. */
  
  public static double[] randomNums(int length) {
    double[] nums = new double[length];
    for(int i=0; i<length; i++) {
      nums[i] = Math.random() * 3;
    }
    return(nums);
  }
}

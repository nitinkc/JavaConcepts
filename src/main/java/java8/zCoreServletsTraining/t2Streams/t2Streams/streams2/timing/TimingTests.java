package java8.zCoreServletsTraining.t2Streams.t2Streams.streams2.timing;

import java.util.Arrays;

public class TimingTests {
  public static void main(String[] args) {
    for(int i=3; i<8; i++) {
      int size = (int)Math.pow(10, i);
      Op sortArray = () -> sortArray(size);
      Op wasteTime = () -> wasteTime(size);
      Op doBoth = sortArray.combinedOp(wasteTime);
      System.out.printf("Sorting array of length %,d.%n", size);
      Op.timeOp(sortArray);
      System.out.printf("Wasting time (%,d repeats).%n", size);
      Op.timeOp(wasteTime);
      System.out.printf("Doing both (%,d repeats).%n", size);
      Op.timeOp(doBoth);
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
  
  public static void wasteTime(int repeats) {
    for(int i=0; i<repeats; i++) {
      double d = Math.sqrt(Math.random()) +
                 Math.sin(Math.random()) +
                 Math.exp(Math.random());
      doSomethingWith(d);
    }
  }
  
  private static void doSomethingWith(double d) {
    // Nothing to see here. Move along.
  }
}

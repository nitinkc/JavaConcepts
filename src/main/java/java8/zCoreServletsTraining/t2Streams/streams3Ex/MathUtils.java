package java8.zCoreServletsTraining.t2Streams.streams3Ex;

import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class MathUtils {
  /** Produces an array containing size doubles, each between 0 and 1.
   */
  public static double[] randomArray(long size) {
    return(new Random().doubles(size).toArray());
  }
  
  /** Returns the sum of the square roots of entries in the stream. 
   *  Serial version.
   */
  public static double sqrtSum(DoubleStream numStream) {
    return(numStream.map(Math::sqrt).sum());
  }
  
  /** Returns the sum of the square roots of entries in the stream. 
   *  Parallel version.
   */
  public static double sqrtSumParallel(DoubleStream numStream) {
    return(numStream.parallel().map(Math::sqrt).sum());
  }
  
  // Or, use DoubleStream.generate, which produces DoubleStream
  // instead of Stream<Double>
  public static Stream<Double> randomNums(double maxValue) {
    return(Stream.generate(() -> Math.random() * maxValue));
  }
}

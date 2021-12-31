package java.zCoreServletsTraining.t2Streams.t2Streams.streams2.specializedstreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

// Notice the call to "boxed" in the second example!

public class DoubleStreamTest {
  public static void main(String[] args) {
    List<Double> nums1 = 
        Stream.of(1.2, 2.3, 3.4)
              .collect(Collectors.toList());
    System.out.println(nums1);
    List<Double> nums2 = 
        DoubleStream.of(1.2, 2.3, 3.4)
                     .boxed()
                     .collect(Collectors.toList());
    System.out.println(nums2);
  }
}

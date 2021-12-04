package java8.zCoreServletsTraining.t2Streams.streams3.streams;

import java.util.function.Supplier;

public class FibonacciMaker implements Supplier<Long> {
  private long previous = 0;
  private long current = 1;

  @Override
  public Long get() {
    long next = current + previous;
    previous = current;
    current = next;
    return(previous);
  }
}

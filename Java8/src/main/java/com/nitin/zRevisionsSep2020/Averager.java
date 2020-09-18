package com.nitin.zRevisionsSep2020;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.DoubleStream;

class Average {
  private double sum;
  private long count;
  
  public void include(double d) {
    sum += d;
    count++;
  }
  
  public void merge(Average other) {
    sum += other.sum;
    count += other.count;
  }
  
  public double get() {
    return sum / count;
  }
}

public class Averager {
  public static void main(String[] args) {
    long start = System.nanoTime();
    Average av = DoubleStream.generate(() -> ThreadLocalRandom.current().nextDouble(-Math.PI, Math.PI))
        .parallel()
        .limit(200_000_000)
        .map(Math::sin)
        .collect(Average::new, Average::include, Average::merge);
    long end = System.nanoTime();
    
    double mean = av.get();
    System.out.println("Average is " + mean);
    System.out.println("Time taken: " + ((end - start) / 1_000_000) + " ms");
  }
}

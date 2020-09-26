package com.nitin.zCoreServletsTraining.t1Lambdas.lambdasInCollection.maps;

import java.util.*;

import com.nitin.zCoreServletsTraining.t1Lambdas.lambdasInCollection.timing.*;

public class Fibonacci {
  private static int i;
  private static Map<Integer,Integer> fibMap = new HashMap<>();
  
  public static void main(String[] args) {
    profileFib();
  }
  
  public static void profileFib() {
    for(i=0; i<47; i++) {
      Op.timeOp(() -> System.out.printf("fib1(%s)=%s.%n", i, fib1(i)));
      Op.timeOp(() -> System.out.printf("fib(%s) =%s.%n", i, fib(i)));
    }
  }
  
  public static int fib1(int n) {
    if (n <= 1) {
      return(n);
    } else {
      return(fib1(n-1) + fib1(n-2));
    }
  }
  
  public static int fib(int num) {
    return
      fibMap.computeIfAbsent(num, n -> {
        if (n <= 1) {
          return(n);
        } else {
          return(fib(n-1) + fib(n-2));
        }
      });
  }
}

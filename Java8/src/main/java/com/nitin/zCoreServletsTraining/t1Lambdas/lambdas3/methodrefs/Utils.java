package com.nitin.zCoreServletsTraining.t1Lambdas.lambdas3.methodrefs;

import java.util.function.*;

public class Utils {
  public static <T,R> R transform(T value, Function<T,R> f) {
    return(f.apply(value));
  }
  
  public static String makeExciting(String s) {
    return(s + "!!");
  }
  
  private Utils() {}
}

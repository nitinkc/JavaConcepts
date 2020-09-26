package com.nitin.zCoreServletsTraining.t1Lambdas.lambdas3.function;

import java.util.*;
import java.util.function.*;

public class FunctionUtils {
  /** Returns first entry from list that passes the match function. This is
   *  a generalized version of EmployeeUtils.firstMatchingEmployee. 
   */
  public static <T> T firstMatch(List<T> candidates, Predicate<T> matchFunction) {
    for(T possibleMatch: candidates) {
      if(matchFunction.test(possibleMatch)) {
        return(possibleMatch);
      }
    }
    return(null); 
  }
  
  /** A generic and more flexible variation of EmployeeUtils.salarySum. */
  
  public static <T> int mapSum(List<T> entries, Function<T, Integer> mapper) {
    int sum = 0;
    for(T entry: entries) {
      sum += mapper.apply(entry);
    }
    return(sum);
  }
  
  public static int mapSum(List<Integer> entries) {
    return(mapSum(entries, Function.identity()));
  }
  
  public FunctionUtils() {} // Uninstantiatable class; static methods only
}

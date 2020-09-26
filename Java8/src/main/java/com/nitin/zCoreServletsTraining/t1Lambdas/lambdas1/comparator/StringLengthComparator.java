package com.nitin.zCoreServletsTraining.t1Lambdas.lambdas1.comparator;

import java.util.*;

public class StringLengthComparator implements Comparator<String> {
  @Override
  public int compare(String s1, String s2) {
    return(s1.length() - s2.length());
  }
}

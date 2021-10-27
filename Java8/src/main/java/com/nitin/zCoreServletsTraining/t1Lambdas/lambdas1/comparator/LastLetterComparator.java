package com.nitin.zCoreServletsTraining.t1Lambdas.lambdas1.comparator;

import java.util.Comparator;

public class LastLetterComparator implements Comparator<String> {
  @Override
  public int compare(String s1, String s2) {
    return(s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1));
  }
}

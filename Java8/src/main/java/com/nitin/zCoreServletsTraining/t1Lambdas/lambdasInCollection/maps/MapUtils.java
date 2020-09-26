package com.nitin.zCoreServletsTraining.t1Lambdas.lambdasInCollection.maps;

import java.util.*;

public class MapUtils {
  public static <K,V> void printMapEntries(Map<K,V> map) {
    map.forEach((key, value) -> System.out.printf("(%s,%s)%n", key, value));
  }

  private MapUtils() {}
}

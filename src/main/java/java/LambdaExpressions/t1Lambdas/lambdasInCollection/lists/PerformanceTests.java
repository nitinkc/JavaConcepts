package java.LambdaExpressions.t1Lambdas.lambdasInCollection.lists;

import java.LambdaExpressions.t1Lambdas.lambdasInCollection.timing.Op;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

/** Class that attempts to compare the performance of removeIf, replaceAll, and sort
 *  vs. streaming the List, using the corresponding Stream methods, and then accumulating
 *  the results back into a new List. Results were highly variable and did not show
 *  clear trends, so should be taken with skepticism. What <b>is</b> clear is that for
 *  sizes below a million entries, there was no measurable performance difference. 
 *  <p>
 *  So, if you want to modify the original List, use the List methods because they
 *  are more convenient, not because they are faster.
 */
public class PerformanceTests {
  private static LinkedList<Integer> list1;
  private static ArrayList<Integer> list2;
  private static LinkedList<Integer> list3;
  private static ArrayList<Integer> list4;
  private static String message = "%s entries in %s with %,d elements.%n";
  
  public static void main(String[] args) {
    profileRemoveIf();
    profileReplaceAll();
    profileSort();
  }
  
  private static void profileRemoveIf() {
    int size = 1_000_000;
    for(int i=0; i<4; i++) {
      initializeLists(size);
      Predicate<Integer> isEven = n -> n%2 == 0;
      Predicate<Integer> isOdd = n -> n%2 != 0;
      System.out.printf(message, "Removing even", "LinkedList", size);
      Op.timeOp(() -> list1.removeIf(isEven));
      System.out.printf(message, "Removing even", "ArrayList", size);
      Op.timeOp(() -> list2.removeIf(isEven));
      System.out.printf(message, "Streaming and filtering even", "LinkedList", size);
      Op.timeOp(() -> list3 = list3.stream().filter(isOdd).collect(Collectors.toCollection(LinkedList::new)));
      System.out.printf(message, "Streaming and filtering even", "ArrayList", size);
      Op.timeOp(() -> list4 = list4.stream().filter(isOdd).collect(Collectors.toCollection(ArrayList::new)));
      size = size * 2;
      System.out.println();
    }
  }
  
  private static void profileReplaceAll() {
    int size = 1_000_000;
    for(int i=0; i<4; i++) {
      initializeLists(size);
      UnaryOperator<Integer> doubleIt = n -> n*2;
      System.out.printf(message, "Doubling", "LinkedList", size);
      Op.timeOp(() -> list1.replaceAll(doubleIt));
      System.out.printf(message, "Doubling", "ArrayList", size);
      Op.timeOp(() -> list2.replaceAll(doubleIt));
      System.out.printf(message, "Streaming and doubling", "LinkedList", size);
      Op.timeOp(() -> list3 = list3.stream().map(doubleIt).collect(Collectors.toCollection(LinkedList::new)));
      System.out.printf(message, "Streaming and doubling", "ArrayList", size);
      Op.timeOp(() -> list4 = list4.stream().map(doubleIt).collect(Collectors.toCollection(ArrayList::new)));
      size = size * 2;
      System.out.println();
    }
  }
  
  private static void profileSort() {
    int size = 1_000_000;
    for(int i=0; i<4; i++) {
      initializeLists(size);
      Comparator<Integer> evensFirst = (i1, i2) -> (i1 % 2) - (i2 % 2);
      System.out.printf(message, "Sorting", "LinkedList", size);
      Op.timeOp(() -> list1.sort(evensFirst));
      System.out.printf(message, "Sorting", "ArrayList", size);
      Op.timeOp(() -> list2.sort(evensFirst));
      System.out.printf(message, "Streaming and sorting", "LinkedList", size);
      Op.timeOp(() -> list3 = list3.stream().sorted(evensFirst).collect(Collectors.toCollection(LinkedList::new)));
      System.out.printf(message, "Streaming and sorting", "ArrayList", size);
      Op.timeOp(() -> list4 = list4.stream().sorted(evensFirst).collect(Collectors.toCollection(ArrayList::new)));
      size = size * 2;
      System.out.println();
    }
  }
  
  private static void initializeLists(int size) {
    list1 = new LinkedList<>();
    fillList(list1, size);
    list2 = new ArrayList<>(size);
    fillList(list2, size);
    list3 = new LinkedList<>();
    fillList(list3, size);
    list4 = new ArrayList<>();
    fillList(list4, size);
  }
  
  private static void fillList(List<Integer> nums, int size) {
    for(int i=0; i<size; i++) {
      nums.add(i);
    }
  }
}

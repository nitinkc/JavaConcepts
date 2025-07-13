package nitin.collections.unmodifiableCollection;

import com.entity.EmployeeSimple;
import com.entity.SampleData;
import java.util.*;

/** Created by Nitin Chaurasia on 2/1/18 at 12:05 AM. */
public class F1ImmutableList {
    public static void main(String[] args) {
        // Traditional way

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        // This is how an unmodifiable collection is created
        list = Collections.unmodifiableList(list);
        // list.add(3);// java.lang.UnsupportedOperationException

        // What is Static Factory Method?
        // When a static method returns the same Class Object (reference type) of its own class,
        // its called Static Factory Method
        Runtime r = Runtime.getRuntime();

        /* JAVA 9 Enhancement; of() method is static factory method */
        // shortcut way to create UNMODIFIABLE Collection Object (no add or remove works after it)
        List<Integer> l = List.of(2, 3, 4, 5, 6, 7); // upto 10 elements, post which var-arg method
        // but using var arg is costly

        // Internally java.util.ImmutableCollections$ListN, inner class is created, not ArrayList or
        // LL
        System.out.println(l.getClass().getName());

        // Element should not be null else NULL POINTER EXCEPTION
        // List<Integer> test = List.of(3,null);//java.lang.NullPointerException

        Optional<List<String>> strOptional = Optional.of(Arrays.asList("John", "Doe"));
        List<String> stringList = strOptional.get();

        int[] arr = {4, 5, 3, 8, 2};
        Arrays.sort(arr);
        for (int a : arr) System.out.println(arr);

        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        Queue<EmployeeSimple> heap =
                new PriorityQueue<>(
                        Comparator.comparing(EmployeeSimple::getAge)
                                .reversed()
                                .thenComparing(EmployeeSimple::getSalary)
                                .reversed());

        for (EmployeeSimple emp : employees) {
            heap.add(emp);
        }
        heap.forEach(x -> System.out.println(x.getAge() + x.getName() + x.getSalary()));
    }
}

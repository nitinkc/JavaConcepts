package nitin.collections.b_set;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by synergisticit on 2/25/2016. while adding into a set, a test of equality happens, to
 * determine if the a5object being pushed already exist
 */
public class S2BasicSetInteger {
    public static void main(String[] args) {

        // With Integer, no need to override hashCode and equals
        // With Tree set it will sort to DNSO

        // Sorted values while iterating
        Set<Integer> set = new TreeSet<Integer>();

        // Ordering NOT guarenteed in HashSet
        // Set<Integer> b_set = new HashSet<Integer>();

        // How to Add
        addSet(set);

        // How to Iterate
        printSet(set);

        // How to Remove
        removeOddNumber(set);

        printSet(set);
    }

    private static void removeOddNumber(Set<Integer> set) {
        Iterator<Integer> itr = set.iterator();

        while (itr.hasNext()) {
            int curr = itr.next();
            if (curr % 2 != 0) {
                itr.remove();
                // ConcurrentModificationException
                // b_set.remove(curr);
            }
        }
    }

    /** 3 main methods of iterator 1. hasNext() 2. next() 3. remove() */
    private static void printSet(Set<Integer> set) {
        // Printing with Iterator
        Iterator<Integer> itr = set.iterator();
        // From this point on, DO NOT USE set.get or set.remove!!
        // USE ONLY ITERATOR
        while (itr.hasNext()) {
            System.out.print(itr.next() + " - ");
        }
        System.out.println();

        System.out.println("Print Using For Each Loop");

        for (Integer i : set) {
            System.out.print(i);
        }

        System.out.println();
    }

    /**
     * 1. Demonstrating adding USING A COLLECTION 2. and adding individual elements
     *
     * @param set
     */
    private static void addSet(Set<Integer> set) {
        set.addAll(Arrays.asList(2, 4, 6, 9, 10, 11, 12));
        set.add(1234);
    }
}

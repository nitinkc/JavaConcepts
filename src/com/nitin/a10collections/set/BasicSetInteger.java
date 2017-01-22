package com.nitin.a10collections.set;

import java.util.*;

/**
 * Created by synergisticit on 2/25/2016.
 * while adding into a set, a test of eqality happens, to determine if the object being pushed already exist
 */
public class BasicSetInteger {
    public static void main(String[] args) {

        // With Integer, no need to override hashCode and equals
        // With Tree set it will sort to DNSO

        // Sorted values while iterating
        Set<Integer> set = new TreeSet<Integer>();

        // Ordering NOT guarenteed in HashSet
        //Set<Integer> set = new HashSet<Integer>();

        // How to Add
        addSet(set);

        //How to Iterate
        printSet(set);

        //How to Remove
        removeOddNumber(set);

        printSet(set);

    }

    private static void removeOddNumber(Set<Integer> set) {
        Iterator<Integer> itr = set.iterator();

        while(itr.hasNext()){
            int curr = itr.next();
            if (curr%2 != 0){
                itr.remove();
                // ConcurrentModificationException
                //set.remove(curr);
            }
        }

    }

    /**
     *  3 main methids of iterator
     1. hasNext()
     2. next()
     3. remove()
     */
    private static void printSet(Set<Integer> set) {
        //Printing with Iterator
        Iterator itr = set.iterator();
        //From this point on, DO NOT USE set.get or set.remove!!
        // USE ONLY ITERATOR
        while (itr.hasNext()) {

            System.out.print(itr.next() + " - ");
        }

        System.out.println();

    }

    /**
     * 1. Demonstrating adding USING N1PathFileTest COLLECTION
     * 2. and adding individual elements
     *
     * @param set
     */
    private static void addSet(Set<Integer> set){
        Integer[] arr = new Integer[]{2, 4, 6, 9, 10, 11, 12};
        List arr1 = new ArrayList<Integer>();
        //Adding some other collection into the set
        arr1 = Arrays.asList(arr);
        set.addAll(arr1);

        //Adding an individual element
        set.add(1234);
    }
}

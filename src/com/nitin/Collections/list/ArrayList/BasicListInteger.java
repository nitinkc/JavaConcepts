package com.nitin.collections.list.ArrayList;

import java.util.*;

/**
 * Created by synergisticit on 2/25/2016.
 */
public class BasicListInteger {
    public static void main(String[] args) {

        // With Integer, no need to override hashCode ansd equals
        // With Tree set it will sort to DNSO

        // Sorted values while iterating

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(6);
        list.add(5);
        list.add(4);

        // Ordering not guarenteed in HashSet
        //Set<Integer> set = new TreeSet<Integer>();

        // How to Add
        //addSet(set);

        removeOddNumber(list);

        //How to Iterate
        printList(list);

        //NOTE: FOR EACH NOT APPLICABLE FOR ITERATOR

        //How to Remove

        //printSet(set);

    }



    private static void removeOddNumber(List<Integer> list) {
        Iterator<Integer> itr = list.iterator();

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
    private static void printList(List<Integer> list) {
        //Printing with Iterator
        Iterator itr = list.iterator();
        //From this point on, DO NOT USE set.get or set.remove!!
        // USE ONLY ITERATOR
        while (itr.hasNext()) {

            System.out.print(itr.next() + " - ");
        }
        System.out.println();

    }

}

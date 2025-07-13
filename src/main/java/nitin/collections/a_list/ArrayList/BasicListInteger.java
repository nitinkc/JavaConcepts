package nitin.collections.a_list.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** Created by synergisticit on 2/25/2016. */
public class BasicListInteger {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(6);
        list.add(5);
        list.add(4);
        removeOddNumber(list);

        // How to Iterate
        printList(list);

        // NOTE: FOR EACH NOT APPLICABLE FOR ITERATOR

        // printSet(b_set);

    }

    private static void removeOddNumber(List<Integer> list) {
        Iterator<Integer> itr = list.iterator();

        while (itr.hasNext()) {
            int curr = itr.next();
            if (curr % 2 != 0) {
                itr.remove();
                // ConcurrentModificationException
                list.remove(curr);
            }
        }
    }

    /** 3 main methods of iterator 1. hasNext() 2. next() 3. remove() */
    private static void printList(List<Integer> list) {
        // Printing with Iterator
        Iterator itr = list.iterator();
        // From this point on, DO NOT USE b_set.get or b_set.remove!!
        // USE ONLY ITERATOR
        while (itr.hasNext()) {
            System.out.print(itr.next() + " - ");
        }
        System.out.println();
    }
}

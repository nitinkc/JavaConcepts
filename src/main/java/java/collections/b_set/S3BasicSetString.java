package java.collections.b_set;

import java.util.*;

/**
 * Created by synergisticit on 2/25/2016.
 */
public class S3BasicSetString {
    public static void main(String[] args) {

        // With STRING, no need to override hashCode ansd equals
        // With Tree b_set it will sort to DNSO

        // Sorted values while iterating
        Set<String> set = new TreeSet<String>();

        // Ordering not guarenteed in HashSet
        //Set<Integer> b_set = new TreeSet<Integer>();

        // How to Add
        addSet(set);

        //How to Iterate
        printSet(set);

        //How to find
        System.out.println(findLongString(set));

    }

    /**
     * 1. Demonstrating adding USING A COLLECTION
     * 2. and adding individual elements
     *
     * @param set
     */
    private static void addSet(Set<String> set) {
        String[] arr = new String[]{"Lucia", "Brendan", "Sophia", "Sara"};
        List arr1 = new ArrayList<Integer>();
        //Adding some other collection into the b_set
        arr1 = Arrays.asList(arr);
        set.addAll(arr1);

        //Adding an individual element
        set.add("1234");
    }

    /**
     * 3 main methids of iterator
     * 1. hasNext()
     * 2. next()
     * 3. remove()
     */
    private static void printSet(Set<String> set) {
        //Printing with Iterator
        Iterator itr = set.iterator();
        //From this point on, DO NOT USE b_set.get or b_set.remove!!
        // USE ONLY ITERATOR
        while (itr.hasNext()) {

            System.out.print(itr.next() + " - ");
        }
        System.out.println("END");
    }

    /**
     * ASSUMPTION: largest string occurs ONLY Once;
     * @param set
     * @return
     */
    private static String findLongString(Set<String> set) {
        Iterator<String> itr = set.iterator();
        int strLen = -1;
        String ret = null;

        while (itr.hasNext()) {
            //Save the current value to avoid two itr.next
            String current = itr.next();

            if (current.length() > strLen ){
                strLen = current.length();
                ret = current;
            }
        }
        return ret;
    }
}

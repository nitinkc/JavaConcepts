package java7.a10collections.a_list.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by synergisticit on 2/25/2016.
 */
public class BasicListString {
    public static void main(String[] args) {

        // With Integer, no need to override hashCode ansd equals
        // With Tree b_set it will sort to DNSO

        // Sorted values while iterating

        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("ab");
        list.add("abcdefght");
        list.add("mps");
        list.add("1234");
        list.add("luluo");

        // Ordering not guarenteed in HashSet
        //Set<Integer> b_set = new TreeSet<Integer>();

        // How to Add
        //addSet(b_set);
       System.out.println("Longest string is="+findlongestString(list));


        //How to Iterate
        printSet(list);

        //How to Remove


        //printSet(b_set);

    }

    private static String findlongestString(List<String> list) {
        Iterator<String> itr = list.iterator();
            String ret=null;
        int temp=0;
        while(itr.hasNext()){
            String curr = itr.next();
            if (curr.length()>=temp){
                temp=curr.length();
               ret=curr;

            }
        }
        return ret;

    }

    /**
     *  3 main methids of iterator
     1. hasNext()
     2. next()
     3. remove()
     */
    private static void printSet(List<String> list) {
        //Printing with Iterator
        Iterator itr = list.iterator();
        //From this point on, DO NOT USE b_set.get or b_set.remove!!
        // USE ONLY ITERATOR
        while (itr.hasNext()) {

            System.out.print(itr.next() + " ");
        }
        System.out.println();

    }



}

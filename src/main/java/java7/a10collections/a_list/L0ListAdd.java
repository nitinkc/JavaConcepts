package java7.a10collections.a_list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by nitin on 1/13/16.
 * Add at a particular Index. It has to be in an order.
 *
 * You can change the value at a particular index
 */
public class L0ListAdd {
    public static void main(String[] args) {
        List list=new LinkedList();
        list.add(0,"abc");
        list.add(1,"def");
        list.add("pqr");
        list.add("xyz");
        //a_list.add(6,"wer");// Will throw an exception IndexOutOfBoundsException: Index: 6, Size: 4

        System.out.println(list);
        list.add(0,"ADDED VALUE!!!");// This will shift the entire array!!

        list.set(1,"REPLACING THE VALUE");// Set replaces the value

        Iterator itr=list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

    }
}

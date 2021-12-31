package java.collections.a_list.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by nitin on 1/13/16.
 * ArrayList arrayList=new ArrayList(11);
 * ArrayList Initial Size 10; Later incremented by 3/2 + 1
 * Vector Initial Size 16; Incremented by 2X
 *
 * list.remove() --> ConcurrentModificationException
 * itr.remove() --> correct way to remove
 */
public class L3RemoveElementsUsingIterator {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        list.remove(2);// Removing the element, from anywhere

        System.out.println("******************* LIST BEFORE REMOVAL ***************************** ");
        System.out.println(list );

        Iterator itr = list.iterator();

        // Removing the elements from the a_list
        System.out.println("******************* LIST DURING REMOVAL ***************************** ");
        while (itr.hasNext()) {
            // itr.remove();// Wrong Place as the itr is accessed in SOP
            // list.remove(1);//ConcurrentModificationException
            System.out.println(itr.next());
            itr.remove();
        }// The a_list will be empty after this

        System.out.println("******************* LIST AFTER REMOVAL ***************************** ");
        System.out.println(list );
    }
}

package nitin.collections.a_list;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/** Created by nitin on 1/13/16. Part of Java Util Concurrent. Can write while Reading!! */
public class L2CopyOnWrite {
    public static void main(String[] args) {
        CopyOnWriteArrayList list = new CopyOnWriteArrayList();
        // List a_list=new ArrayList();// List will Give Concurrent Modification Exception
        list.add("abc");
        list.add("def");
        list.add("pqer");

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            list.add(
                    "bcd"); // Adding while Iterating possible with CopyOnWriteArrayList, Concurrent
            // modification Exception with ArrayList
            System.out.println(iterator.next());
        }

        System.out.println("********************************");
        iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

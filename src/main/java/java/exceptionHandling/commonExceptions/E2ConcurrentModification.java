package java.exceptionHandling.commonExceptions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by nitin on 1/13/16.
 * While iterating the a_list, if the STRUCTURE IS modified.
 */
public class E2ConcurrentModification {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("A");
        list.add("B");

        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
            list.remove(0);//ConcurrentModificationException
            itr.remove();//Will Work as its currently being pointed
        }
    }
}

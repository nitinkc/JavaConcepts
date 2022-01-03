package nitin.exceptionHandling.commonExceptions;

import java.util.*;

/**
 * Created by nitin on 1/13/16.
 */
public class E1UnsupportedOperationException {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);

        Collection collection = Collections.unmodifiableList(list);
        list.add("123"); //Gets added Normally to the a_list

        collection.add(55);// Unsupported Operation Exception

        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}

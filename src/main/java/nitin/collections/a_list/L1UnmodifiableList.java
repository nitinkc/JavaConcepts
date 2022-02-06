package nitin.collections.a_list;

import java.util.*;

/**
 * Created by nitin on 1/13/16.
 * <p>
 * The a10collections Utility Class provides the method to make a a_list FINAL
 * Collections.unmodifiableList(a_list)
 * READ ONLY. Throws UnsopportedOperationException
 */
public class L1UnmodifiableList {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        //Makes the a_list Unmodifiable
        Collection collection = Collections.unmodifiableList(list);
        //a_list.add("123"); // Collections$UnmodifiableCollection

        //collection.add(55); // Collections$UnmodifiableCollection

        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}

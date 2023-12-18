package nitin.exceptionHandling.commonExceptions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by nitin on 1/13/16.
 * While iterating the a_list, if the STRUCTURE IS modified.
 */
public class E2ConcurrentModification {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("A");list.add("B");list.add("A");list.add("B");
        list.add("A");list.add("B");list.add("A");list.add("B");
        list.add("A");list.add("B");list.add("A");list.add("B");
        list.add("A");list.add("B");list.add("A");list.add("B");
        System.out.println("Initial Size = "+ list.size());

        for (int i = 0; i < list.size() ; i++) {
            String currentString = list.get(i);
            if(currentString.equals("A")){
                String removed = list.remove(i);//No ConcurrentModificationException
                System.out.println("Removed :: " +removed +" List Size :: "+list.size());
                i--;
            }
        }
        System.out.println(list);

        list = new ArrayList();
        list.add("A");list.add("B");list.add("A");list.add("B");
        list.add("A");list.add("B");list.add("A");list.add("B");
        list.add("A");list.add("B");list.add("A");list.add("B");
        list.add("A");list.add("B");list.add("A");list.add("B");
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            String currentString = itr.next();
            if(currentString.equals("A")){
                //boolean remove = list.remove(currentString);//ConcurrentModificationException
                itr.remove();//Will Work as its currently being pointed
                System.out.println("Removed :: " +currentString +" List Size :: "+list.size());

            }
        }

        System.out.println(list);
    }
}

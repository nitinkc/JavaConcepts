package java.collections.a_list.ArrayList.ListApplication;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Nitin Chaurasia on 1/24/18 at 9:27 PM.
 */
public class RemoveVSIterator {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(4, 7, 9, 2, 7, 7, 5, 3, 5, 1, 7, 8, 6, 7));
        //filterRange(list, 5, 7); should remove all values between 5 and 7,
        filterRange(list, 5, 7);
        System.out.println(list);
    }

    private static void filterRange(ArrayList<Integer> list, int min, int max) {

        //To remove an element from an arraylist, running from the end is a good deal    
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) >= min && list.get(i) <= max)
                list.remove(i);
        }
        return;
    }
}
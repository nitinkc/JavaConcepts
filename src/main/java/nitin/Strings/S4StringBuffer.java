package nitin.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by nitin on Thu, 12/29/16 at 3:04 AM.
 */
public class S4StringBuffer {
    public static void main(String[] args) {
        // Declaring a Rectangular Matrix
        List<List<Integer>> list = new ArrayList<>();

        list.add(0, Arrays.asList(11,12,13));
        list.add(1, Arrays.asList(21,22));
        list.add(2, Arrays.asList(31,32,33,34));
        list.add(3, Arrays.asList(41));
        list.add(4, Arrays.asList(51,52,53));

        //Printing the Matrix using FOR Loop
        for (int i = 0; i < list.size(); i = i + 1) {
            for (int j = 0; j < list.get(i).size(); j = j + 1) {
                System.out.print(list.get(i).get(j) + "\t");
            }
            System.out.println();
        }
    }
}

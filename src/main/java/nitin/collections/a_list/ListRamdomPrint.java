package nitin.collections.a_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ListRamdomPrint {
    public static void main(String[] args) {

        List<String> listOfFriends = new ArrayList<String>();
        listOfFriends.add("Ritesh"); // index0
        listOfFriends.add("Leena");
        listOfFriends.add("Prashant");
        listOfFriends.add("Madhur");
        listOfFriends.add("Skand");
        listOfFriends.add("Neeraj");
        // listOfFriends.b_set(17, "Rochelle"); //IndexOutOfBoundsException: Index: 17, Size: 6

        // List<String> frndNcoll = new ArrayList<String>();

        System.out.println(listOfFriends);
        Collections.shuffle(listOfFriends, new Random());
        System.out.println(listOfFriends); // shuffeled

        System.out.println(listOfFriends.get(2)); // indexing begins at 0
        System.out.println(listOfFriends.getClass());

        System.out.println(listOfFriends.hashCode());

        listOfFriends.clear();
        System.out.println(listOfFriends);
    }
}

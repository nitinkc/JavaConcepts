package java7.a10collections.a_list.ArrayList.ListApplication;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by synergisticit on 2/26/2016.
 */
public class Driver {
    public static void main(String[] args) {
        String[] str = {"I­40","I­85","I­95"};
        Info i1 = new Info(4,"Raleigh", "North Carolina", (ArrayList<String>) Arrays.asList(str));

        str = new String[]{"I­94", "I­90", "I­88", "I­57", "I­55"};
        Info i2 = new Info(27,"Chicago","Illinois", (ArrayList<String>) Arrays.asList(str));

        str= new String[]{"I­5","I­80"};
        Info i3 = new Info(10, "San Jose", "California", (ArrayList<String>) Arrays.asList(str));


    }
}


package java7.a10collections;

import java.util.ArrayList;
import java.util.List;

public class ListRemovalUsingForLoop {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        for (int i = 0; i < list.size(); i++) {
            if (i == 2){
                //System.out.println(list.get(i));
                list.remove(i);
            }
            System.out.println(list.get(i));

        }
    }
}
package sandbox.test;

import java.util.*;

public class RakutenTest {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> tempList  = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                tempList.add((int) (Math.pow(2,i)*Math.pow(3,j)));
            }
        }

        Collections.sort(tempList);
        for (int i = 0; i < 200; i++) {
            //System.out.println(tempList.get(i));
            map.put(i, tempList.get(i));
        }

        System.out.println(map.size());

        Iterator<Integer> itr = map.keySet().iterator();
        while (itr.hasNext()){
            Integer key = itr.next();
            System.out.println("key = " + key + " ; value = "+ map.get(key));
        }
    }
}

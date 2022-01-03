package nitin.collections.b_set;

import java.util.*;

/**
 * Created by synergisticit on 2/26/2016.
 */
public class SetApplication {
    public static void main(String[] args) {
       Integer[] arr = {1,2,1,3,4,5,2,1,3,4,5,6,7,8,97,1,2};
        List<Integer> list = Arrays.asList(arr);

        int uniqueElements = countUnique(list);
        int maxValue = maxValueInList(list);

        System.out.println("Unique Elements : "+uniqueElements);
        System.out.println("Max value is : "+maxValue);

    }

    private static int countUnique(List<Integer> list) {
        Set<Integer> set = new HashSet<Integer>();

        Iterator<Integer> itr = list.iterator();
        while(itr.hasNext()){
            int value = itr.next();
            set.add(value);
        }
        return set.size();
    }

    private static int maxValueInList(List<Integer> list) {
        Set<Integer> set = new TreeSet<Integer>();

        Iterator<Integer> itr = list.iterator();
        while(itr.hasNext()){
            int value = itr.next();
            set.add(value);
        }

        itr = set.iterator();
        int max = -1;
        while (itr.hasNext()){
                int value = itr.next();
                System.out.println(value);
                if (value > max)
                    max = value;
        }
        return max;
    }

}

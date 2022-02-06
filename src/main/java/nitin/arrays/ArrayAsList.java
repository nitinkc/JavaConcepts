package nitin.arrays;

import java.util.Arrays;
import java.util.List;


public class ArrayAsList {
    public static void main(String[] nitin) {
        String[] a = {"one", "two", "three", "four"};
        String[] b = new String[]{"one", "two", "three", "four"};//another way of declaration

        //String Array does not behave like regular arrays. contains method won't work
        //a.contains("one");// cannot resolve method 'contains (java.lang.String)'

        System.out.println(Arrays.asList(a).contains("two"));//true
        System.out.println(Arrays.asList(a).contains("Nitin"));//false

        // Arrays Class has method asList returning is
        System.out.println(Arrays.asList(a));
        List<String> aList = Arrays.asList(a);
        System.out.println(aList.size());
    }

}

package com.j9.nitin.factoryMethodsForUnmodifiableCollection;

import java.util.Map;

/**
 * Created by Nitin Chaurasia on 2/1/18 at 12:33 AM.
 */
public class F3UnmodifiableMap {
    public static void main(String[] args) {
        Map<Integer, String> map = Map.of(1,"Nitin",2,"Kirti");
        //null is not allowed either for key or value

        //For more than 10 K-V pairs, have to use ofEntries method

        //Creating Map.Entry Object (Entry is an interface inside Map Interface)
        Map.Entry<Integer,String> e1 = Map.entry(1,"Test1");
        Map.Entry<Integer,String> e2 = Map.entry(2,"Test2");

        //Creating unmodifiable Map using ofEntries method
        Map<Integer,String> m = Map.ofEntries(e1,e2);

        System.out.println(m);
    }
}

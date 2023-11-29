package nitin.zKnowYourJava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class T1ListVsCollections {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(getIntegers());//Polymnorphism
        list.remove(1);System.out.println(list);

        Collection<Integer> list2 = new ArrayList<>(getIntegers());//Polymnorphism
        list2.remove(1);System.out.println(list2);

        var list3 = new ArrayList<>(getIntegers());//Polymnorphism
        list3.remove(1);System.out.println(list3);
    }

    private static List<Integer> getIntegers() {
        return List.of(1, 2, 3);
    }
}
package nitin.collections.b_set;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {
    public static void main(String[] args) {

        String[] test = {"i", "came", "i", "saw", "i", "left"};
        Set<String> s = new HashSet<String>();
        for (String g : test) {
            if (!s.add(g)) System.out.println("Duplicate detected " + g);
            else System.out.println("Value Added " + g);
        }

        System.out.println(s.size() + " distinct words: " + s);

        Set<String> uniques = new HashSet<String>();
        Set<String> dups = new HashSet<String>();

        for (String g : test)
            if (!uniques.add(g)) // uniques.add will return true
            dups.add(g);

        uniques.removeAll(dups);

        System.out.println("Unique words:    " + uniques);
        System.out.println("Duplicate words: " + dups);
    }
}

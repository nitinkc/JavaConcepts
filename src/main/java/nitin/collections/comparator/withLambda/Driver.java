package nitin.collections.comparator.withLambda;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Nitin C on 3/3/2016.
 */
public class Driver {
    public static void main(String[] args) {
        Set<Squirrel> s = new TreeSet<>(new SquirrelComparator());

        s.add(new Squirrel("Angie", 20));
        s.add(new Squirrel("Angie", 23));
        s.add(new Squirrel("Cngie", 28));
        s.add(new Squirrel("Angie", 20));//NOT ADDED
        s.add(new Squirrel("Engie", 22));
        s.add(new Squirrel("Fngie", 20));
        s.add(new Squirrel("Gngie", 14));
        s.add(new Squirrel("Hngie", 06));
        s.add(new Squirrel("Ingie", 29));

        Iterator itr = s.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}

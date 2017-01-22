package com.nitin.a10collections.Comparator.withLambda;

import java.util.Comparator;

/**
 * Created by Nitin C on 3/3/2016.
 */
public class SquirrelComparator implements Comparator<Squirrel> {
    @Override
    public int compare(Squirrel s1, Squirrel s2) {
        Comparator<Squirrel> c = Comparator.comparing(s -> s.getSpecies());
        c = c.thenComparing(s -> s.getWeight());
        return c.compare(s1,s2);
    }
}

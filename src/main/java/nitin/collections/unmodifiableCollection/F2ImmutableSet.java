package nitin.collections.unmodifiableCollection;

import java.util.Set;

/**
 * Created by Nitin Chaurasia on 2/1/18 at 12:26 AM.
 */
public class F2ImmutableSet {
    public static void main(String[] args) {
        // For more elements, internally var args method is called
        Set<Integer> set = Set.of(1,2,3,4,5,6,7,8,9,10,11,12);

        System.out.println(set.getClass().getName());//java.util.ImmutableCollections$SetN

    }
}

package nitin.LambdaExpressions.t1Lambdas.lambdasInCollection.maps;

import java.util.HashMap;
import java.util.Map;

public class CountEntries {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 3, 4, 2, 2, 1};
        MapUtils.printMapEntries(countEntries(nums));
    }

    public static Map<Integer, Integer> countEntries(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.merge(num, 1, (old, initial) -> old + 1);
        }
        return (counts);
    }
}

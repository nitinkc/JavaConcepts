package nitin.LambdaExpressions.t1Lambdas.lambdasInCollectionEx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
    private static final Map<Integer, Integer> primeCounts = new HashMap<>();

    public static List<Double> randomNumberList(int size) {
        List<Double> nums = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            nums.add(Math.random());
        }
        return (nums);
    }

    public static double average(List<Double> nums) {
        return (nums.stream().mapToDouble(n -> n.doubleValue()).average().orElse(Double.NaN));
    }

    public static void removeBelow(List<Double> nums, double cutoff) {
        nums.removeIf(n -> n < cutoff);
    }

    public static void doubleAllValues(List<Double> nums) {
        nums.replaceAll(n -> n * 2);
    }

    /**
     * Returns the number of primes from 0 to this number, inclusive.
     */

    public static int countPrimes1(int upperBound) {
        if (upperBound <= 2) {
            return (1);
        }
        if (Primes.isPrime(upperBound)) {
            return (1 + countPrimes1(upperBound - 1));
        } else {
            return (countPrimes1(upperBound - 1));
        }
    }

    public static int countPrimes(int upperBound) {
        return
                primeCounts.computeIfAbsent(upperBound, bound -> {
                    if (bound <= 2) {
                        return (1);
                    }
                    if (Primes.isPrime(bound)) {
                        return (1 + countPrimes(bound - 1));
                    } else {
                        return (countPrimes(bound - 1));
                    }
                });
    }
}

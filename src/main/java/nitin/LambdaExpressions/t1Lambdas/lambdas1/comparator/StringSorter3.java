package nitin.LambdaExpressions.t1Lambdas.lambdas1.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class StringSorter3 {
    public void doTests() {
        String[] testStrings = {"one", "two", "three", "four"};
        System.out.print("Original: ");
        ArrayUtils.printArray(testStrings);
        Arrays.sort(testStrings, new StringLengthComparator2());
        System.out.print("After sorting by length: ");
        ArrayUtils.printArray(testStrings);
        Arrays.sort(testStrings, new LastLetterComparator2());
        System.out.print("After sorting by last letter: ");
        ArrayUtils.printArray(testStrings);
    }

    private class StringLengthComparator2 implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return (s1.length() - s2.length());
        }
    }

    private class LastLetterComparator2 implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1));
        }
    }
}

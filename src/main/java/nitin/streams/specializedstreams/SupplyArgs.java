package nitin.streams.specializedstreams;

public class SupplyArgs {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int result1 = UseArgs.firstNumber(1, 2, 3);
        System.out.printf("result1: %s%n", result1);
        int result2 = UseArgs.firstNumber(nums);
        System.out.printf("result2: %s%n", result2);
        Object result3 = UseArgs.firstObject(1, 2, 3);
        System.out.printf("result3: %s%n", result3);
        Object result4 = UseArgs.firstObject(nums);
        System.out.printf("result4: %s%n", result4);
    }
}

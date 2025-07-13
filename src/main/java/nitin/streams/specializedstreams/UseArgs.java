package nitin.streams.specializedstreams;

public class UseArgs {
    private UseArgs() {}

    public static int firstNumber(int... nums) {
        return (nums[0]);
    }

    public static Object firstObject(Object... objects) {
        return (objects[0]);
    }
}

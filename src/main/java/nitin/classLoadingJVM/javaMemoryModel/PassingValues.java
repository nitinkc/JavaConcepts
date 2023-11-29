package nitin.classLoadingJVM.javaMemoryModel;

/**
 * Created by nitin.chaurasia on 2/16/2017.
 * <p>
 * In Java Pass by reference is not possible for Primitive Types
 */
public class PassingValues {

    public static void main(String[] args) {

        int localValue = 5;
        String localString = "Nitin";

        // Pass by VALUE
        calculatePrimitive(localValue);
        calculateObject(localString);

        System.out.println(localValue);
        System.out.println(localString);
    }

    private static void calculateObject(String localString) {
        localString = "Chaurasia";
    }

    private static void calculatePrimitive(int localValue) {
        localValue *= 100;
    }
}

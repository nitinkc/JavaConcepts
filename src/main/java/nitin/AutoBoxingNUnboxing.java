package nitin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nitin Chaurasia on 2/1/18 at 9:03 PM.
 */
public class AutoBoxingNUnboxing {
    public static void main(String[] args) {
        int i = 5;
        long j = 105L;

        //passed the int, will get converted to Integer object at Runtime
        doSomething(i);

        List<Long> list = new ArrayList<>();
        //autoboxing to add primitive type in collection classes
        list.add(j);
    }

    private static void doSomething(Integer in) {
        //unboxing, at runtime Integer.intValue() is called implicitly to return int
        int j = in;
        //unboxing, Integer is passed where int was expected
        doPrimitive(in);
    }

    private static void doPrimitive(int i) {
    }
}
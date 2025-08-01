package nitin;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test {

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            runTest();
        }
    }

    private static void runTest() {
        CopyOnWriteArrayList<String> list =
                new CopyOnWriteArrayList(Arrays.asList("A", "b", "C", "d"));

        new Thread(
                        () -> {
                            list.set(0, "A");
                            list.set(1, "B");
                            list.set(2, "C");
                            list.set(3, "D");
                        })
                .start();

        new Thread(
                        () -> {
                            list.set(0, "a");
                            list.set(1, "b");
                            list.set(2, "c");
                            list.set(3, "d");
                        })
                .start();

        System.out.println(list);
    }
}

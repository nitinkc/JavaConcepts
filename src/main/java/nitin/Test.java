package nitin;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

public class Test {

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            runTest();
        }
    }

    private static void runTest() {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList(Arrays.asList("A","b","C","d"));

        new Thread(() -> {
            list.set(0,"A");
            list.set(1,"B");
            list.set(2,"C");
            list.set(3,"D");
        }).start();

        new Thread(() -> {
            list.set(0,"a");
            list.set(1,"b");
            list.set(2,"c");
            list.set(3,"d");
        }).start();

        System.out.println(list);
    }
}
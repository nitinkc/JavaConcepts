package nitin.performance.list;

import static com.utilities.PerformanceUtility.*;

import com.github.javafaker.Book;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVsLinkedList {
    public static void main(String[] args) {
        final int SIZE = 1_000_000;
        Book bookName = Faker.instance().book();
        ;
        List<String> list = new ArrayList<>(SIZE);
        List<String> linkedList = new LinkedList<>();

        for (int i = 0; i < SIZE; i++) {
            String s = STR."bookName\{i}";
            list.add(s);
            linkedList.add(s);
        }

        startTimer();
        String book1 = list.get(798123);
        System.out.println(book1);
        stopTimer();
        resetTimer();

        startTimer();
        String book2 = linkedList.get(798123);
        System.out.println(book2);
        stopTimer();
        resetTimer();
    }
}

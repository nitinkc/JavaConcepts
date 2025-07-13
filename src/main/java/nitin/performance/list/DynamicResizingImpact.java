package nitin.performance.list;

import static com.utilities.PerformanceUtility.*;

import com.github.javafaker.Book;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;

public class DynamicResizingImpact {
    public static void main(String[] args) {
        final int SIZE = 1_000_000;

        Book bookName = Faker.instance().book();
        ;
        List<Book> defaultList = new ArrayList<>();
        startTimer();
        for (int i = 0; i < SIZE; i++) {
            defaultList.add(bookName);
        }
        stopTimer();
        resetTimer();

        List<Book> initialSizeList = new ArrayList<>(SIZE);
        startTimer();
        for (int i = 0; i < SIZE; i++) {
            initialSizeList.add(bookName);
        }
        stopTimer();
        resetTimer();
    }
}

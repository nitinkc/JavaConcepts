package nitin.collections.collectionsClass;

import com.utilities.InternetUtilities;

import javax.sound.sampled.ReverbType;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nitin on Wednesday, September/25/2019 at 10:15 PM
 */
public class CollectionsClassPrimitive {
    private static final int WORD_LENGTH = 15;

    public static void main(String[] args) {
        List<String> list = InternetUtilities.bringWordListFromNet();

        list = list.stream()
                .filter(s -> s.length() > WORD_LENGTH)
                .collect(Collectors.toList());

        System.out.println(list);

        Collections.shuffle(list);
        System.out.println("Shuffled List");
        System.out.println(list);

        //Reverse Sorting
        list.sort(Comparator.naturalOrder());

        //list.stream().sorted(Comparator.comparing(s -> s.length()));

        System.out.println("Reversed SortedList");
        System.out.println(list);
    }
}

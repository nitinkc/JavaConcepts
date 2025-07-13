package nitin.streams.parallelStreams;

import static com.utilities.PerformanceUtility.*;

import com.utilities.InternetUtilities;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelProcessing {
    public static void main(String[] args) {

        List<String> wordList = InternetUtilities.bringWordListFromNet();

        System.out.println(
                "********************************** Sequential **********************************");
        startTimer();
        List<String> capitalListSequential =
                wordList.stream().map(str -> str.toUpperCase()).collect(Collectors.toList());
        stopTimer();
        System.out.println(capitalListSequential.size());

        resetTimer();
        System.out.println(
                "********************************** Parallel **********************************");
        startTimer();
        List<String> capitalListParallel =
                wordList.parallelStream()
                        .map(str -> str.toUpperCase())
                        .collect(Collectors.toList());
        stopTimer();
        System.out.println(capitalListParallel.size());
    }
}

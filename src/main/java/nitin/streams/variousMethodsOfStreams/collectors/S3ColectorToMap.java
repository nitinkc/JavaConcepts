package nitin.streams.variousMethodsOfStreams.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class S3ColectorToMap {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1,2,1,3,3,4,5,6,7,8,6,5,4,3,2,1);

        Map<Integer, Integer> map = intList
                .stream()
                .collect(Collectors.toMap(Function.identity(), x -> x+x));//Check

        System.out.println(map);
    }
}

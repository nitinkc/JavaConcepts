package nitin.streams.variousMethodsOfStreams.collectors;

import java.util.Arrays;
import java.util.Collections;

public class ParentDtoTest {
    public static void main(String[] args) {
        ParentDto parentDto = ParentDto.builder()
                .integerList(Arrays.asList(3,1,8,6,9,7))
                .stringList(Arrays.asList("quit", "squid", "book", "bookkeeper", "keep", "steep"))
                .build();

        Integer i = parentDto.getIntegerList().get(0);
        parentDto.setIntegerList(Collections.singletonList(i));
        String s = parentDto.getStringList().get(0);
        parentDto.setStringList(Collections.singletonList(s));

        System.out.println(parentDto);
    }
}

package nitin.streams;

import com.utilities.MathUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAssignment {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Great","Grand","Uncle");
        List<StringDto> resultList = new ArrayList<>();

//        for (String str:list) {
//            resultList.add(new StringDto(com.utilities.StringUtils.reverseString(StringUtils.upperCase(str)), Math.round(Math.random())));
//        }

        resultList = list.stream()
            .map(item -> new StringDto(com.utilities.StringUtils.reverseString(StringUtils.upperCase(item)), Math.round(Math.random())))
                .collect(Collectors.toList());
        resultList.stream().forEach(item -> System.out.println(item));

        System.out.println("+++++++++++++++++++++++++++++++++++++++++");
        // Example 2
        List<SomeDto> resultList2 = new ArrayList<>();
        resultList2 = list.stream()
                .map(item -> new SomeDto(com.utilities.StringUtils.reverseString((item))))
                .collect(Collectors.toList());

        resultList2.stream().forEach(item -> System.out.println(item));
    }
}

@Data
@AllArgsConstructor
@ToString
class StringDto{
    private String str;
    private long random;
}

@Data
@AllArgsConstructor
@ToString
class SomeDto{
    private String str;
}
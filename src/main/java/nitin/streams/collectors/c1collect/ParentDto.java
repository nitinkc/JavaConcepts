package nitin.streams.collectors.c1collect;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class ParentDto {

    private List<String> stringList;
    private List<Integer> integerList;
}

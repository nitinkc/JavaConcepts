package nitin.streams;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class ParentDto {

    private List<String> stringList;
    private List<Integer> integerList;
}

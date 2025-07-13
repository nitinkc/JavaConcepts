package nitin.mappers.mapstruct.dto;

import java.util.List;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class TesterDto {
    private String test;
    private List<String> testList;
}

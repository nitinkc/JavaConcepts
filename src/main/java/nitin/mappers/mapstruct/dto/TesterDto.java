package nitin.mappers.mapstruct.dto;

import lombok.*;

import java.util.List;

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
